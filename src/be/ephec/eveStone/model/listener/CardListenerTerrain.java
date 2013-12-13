package be.ephec.eveStone.model.listener;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import be.ephec.eveStone.vieuw.Area;
import be.ephec.eveStone.vieuw.container.CardPanel;
// TODO: Auto-generated Javadoc
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

	/** The card. */
	private CardPanel card;
	
	/** The terrain. */
	private JPanel terrain;
	
	/** The terrain adv. */
	private JPanel terrainAdv;
	
	/** The info label. */
	private JLabel infoLabel;
	
	/** The heros adv label. */
	private JLabel herosAdvLabel;
	
	/** The can attack. */
	private boolean canAttack;

	/**
	 * Instantiates a new card listener terrain.
	 *
	 * @param card the card
	 * @param area the area
	 */
	public CardListenerTerrain(CardPanel card, Area area){
		super(card, area.getLabelInfo());
		this.card=card;
		this.terrain=area.getjPanelTerrain();
		this.terrainAdv=area.getjPanelTerrainAdversaire();
		this.herosAdvLabel=area.getjLabelHerosAdversaire();
		canAttack=false;
	}
	
	/**
	 * Lorsque l'on clique sur un serviteur du terrain, on active la fonction targetable
	 * sur les carte du terrain adverse. On enregistre par ailleurs la carte attaquante et on
	 * supprime le sort qui pourrait etre enregistré sur les carte (dans le cas ou on aurait cliqué sur
	 * le sort avant de cliquer ensuite sur un serviteur)
	 *
	 * @param arg0 the arg0
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

	/* (non-Javadoc)
	 * @see be.ephec.eveStone.model.listener.CardListenerMain#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		super.mouseEntered(arg0);
		if(canAttack)
			arg0.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
		else
			arg0.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	/* (non-Javadoc)
	 * @see be.ephec.eveStone.model.listener.CardListenerMain#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		super.mouseExited(arg0);
		//delLastMotionListener();
	}

	/* (non-Javadoc)
	 * @see be.ephec.eveStone.model.listener.CardListenerMain#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see be.ephec.eveStone.model.listener.CardListenerMain#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the card.
	 *
	 * @return the card
	 */
	public CardPanel getCard() {
		return card;
	}

	/**
	 * Sets the card.
	 *
	 * @param card the new card
	 */
	public void setCard(CardPanel card) {
		this.card = card;
	}

	/**
	 * Gets the terrain.
	 *
	 * @return the terrain
	 */
	public JPanel getTerrain() {
		return terrain;
	}

	/**
	 * Sets the terrain.
	 *
	 * @param terrain the new terrain
	 */
	public void setTerrain(JPanel terrain) {
		this.terrain = terrain;
	}

	/**
	 * Gets the terrain adv.
	 *
	 * @return the terrain adv
	 */
	public JPanel getTerrainAdv() {
		return terrainAdv;
	}

	/**
	 * Sets the terrain adv.
	 *
	 * @param terrainAdv the new terrain adv
	 */
	public void setTerrainAdv(JPanel terrainAdv) {
		this.terrainAdv = terrainAdv;
	}

	/**
	 * Gets the info label.
	 *
	 * @return the info label
	 */
	public JLabel getInfoLabel() {
		return infoLabel;
	}

	/**
	 * Sets the info label.
	 *
	 * @param infoLabel the new info label
	 */
	public void setInfoLabel(JLabel infoLabel) {
		this.infoLabel = infoLabel;
	}

	/**
	 * Sets the can attack.
	 *
	 * @param check the new can attack
	 */
	public void setCanAttack(boolean check){
		this.canAttack=check;
	}
}
