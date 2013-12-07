package be.ephec.eveStone.model.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import be.ephec.eveStone.model.Serviteur;
import be.ephec.eveStone.vieuw.container.CardPanel;

public class CardListenerTerrain extends CardListenerMain{

	private CardPanel card;
	private JPanel terrain;
	private JPanel terrainAdv;
	private JLabel infoLabel;
	private boolean canAttack;

	public CardListenerTerrain(CardPanel card, JLabel infoLabel, JPanel terrain, JPanel terrainAdv){
		super(card, infoLabel);
		this.card = card;
		this.terrain = terrain;
		this.terrainAdv=terrainAdv;
		this.infoLabel=infoLabel;
		canAttack=true;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Nom : "+this.card.getName()+" vie : "+((Serviteur)card.getCard()).getNbVie());
		if (canAttack){
			for(int i=0; i<terrainAdv.getComponentCount(); i++){
				MouseListener ml[] = terrainAdv.getComponent(i).getMouseListeners();
				((CardListenerTerrainAdv)ml[0]).setTargetable(true);
				((CardListenerTerrainAdv)ml[0]).setCardAttacking(card);
			}
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
