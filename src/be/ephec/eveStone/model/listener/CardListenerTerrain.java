package be.ephec.eveStone.model.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import be.ephec.eveStone.vieuw.Area;
import be.ephec.eveStone.vieuw.container.CardPanel;
/**
 * Listener sur le terrain de jeu
 * 
 * De part sa définition, les listener sur les cartes du terrain sont forcement des serviteurs ou une instances
 * de ceux-ci. Il ne leur est donc possible que d'attaquer l'adversaire.
 * 
 * (ATTENTION : Fonctionne en symbiose avec le CardListenerTerrainAdv)
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 *
 */
public class CardListenerTerrain extends CardListenerMain{

	private CardPanel card;
	private JPanel terrain;
	private JPanel terrainAdv;
	private JLabel infoLabel;
	private JLabel herosAdvLabel;
	private boolean canAttack;

	public CardListenerTerrain(CardPanel card, Area area){
		super(card, area.getLabelInfo());
		this.card=card;
		this.terrain=area.getjPanelTerrain();
		this.terrainAdv=area.getjPanelTerrainAdversaire();
		this.herosAdvLabel=area.getjLabelHerosAdversaire();
		canAttack=true;
	}
	/**
	 * Lorsque l'on clique sur un serviteur du terrain, on active la fonction targetable
	 * sur les carte du terrain adverse. On enregistre par ailleurs la carte attaquante et on
	 * supprime le sort qui pourrait etre enregistré sur les carte (dans le cas ou on aurait cliqué sur
	 * le sort avant de cliquer ensuite sur un serviteur)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (canAttack){
			MouseListener ml[];
			for(int i=0; i<terrainAdv.getComponentCount(); i++){
				ml = terrainAdv.getComponent(i).getMouseListeners();
				((CardListenerTerrainAdv)ml[0]).setTargetable(true);
				((CardListenerTerrainAdv)ml[0]).setSortHero(null, null);
				((CardListenerTerrainAdv)ml[0]).setCardAttacking(card);
			}
			ml = herosAdvLabel.getMouseListeners();
			((HerosListener)ml[0]).setCardAttacking(getCard());
			((HerosListener)ml[0]).setSortAttacking(null);
			((HerosListener)ml[0]).setTargetable(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		super.mouseEntered(arg0);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		super.mouseExited(arg0);
		//delLastMotionListener();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public CardPanel getCard() {
		return card;
	}

	public void setCard(CardPanel card) {
		this.card = card;
	}

	public JPanel getTerrain() {
		return terrain;
	}

	public void setTerrain(JPanel terrain) {
		this.terrain = terrain;
	}

	public JPanel getTerrainAdv() {
		return terrainAdv;
	}

	public void setTerrainAdv(JPanel terrainAdv) {
		this.terrainAdv = terrainAdv;
	}

	public JLabel getInfoLabel() {
		return infoLabel;
	}

	public void setInfoLabel(JLabel infoLabel) {
		this.infoLabel = infoLabel;
	}

	public void setCanAttack(boolean check){
		this.canAttack=check;
	}
}
