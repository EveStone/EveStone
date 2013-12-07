package be.ephec.eveStone.model.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.ephec.eveStone.model.Invisible;
import be.ephec.eveStone.model.Protection;
import be.ephec.eveStone.model.Serviteur;
import be.ephec.eveStone.vieuw.container.CardPanel;

public class CardListenerTerrainAdv extends CardListenerTerrain{

	private boolean isTargetable;
	private CardPanel cardAttacking;

	public CardListenerTerrainAdv(CardPanel card, JLabel infoLabel, JPanel terrain, JPanel terrainAdv) {
		super(card, infoLabel, terrain, terrainAdv);
		isTargetable=false;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (isTargetable){
			if(makeDommage(arg0, ((Serviteur)cardAttacking.getCard()).getNbDommage())){
				MouseListener ml[]=cardAttacking.getMouseListeners();
				((CardListenerTerrain)ml[0]).setCanAttack(false);
				for(int i=0; i<getTerrainAdv().getComponentCount(); i++){
					ml = getTerrainAdv().getComponent(i).getMouseListeners();
					((CardListenerTerrainAdv)ml[0]).setTargetable(false);
					((CardListenerTerrainAdv)ml[0]).setCardAttacking(null);
				}
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
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	protected boolean checkListProtection(JPanel panel)
	{
		boolean check = false;
		for (int i = 0; i< panel.getComponentCount(); i++)
		{
			if (((CardPanel)panel.getComponent(i)).getCard() instanceof Protection)
			{
				return true;
			}
		}
		return check;
	}

	public CardPanel getCardAttacking() {
		return cardAttacking;
	}

	public void setCardAttacking(CardPanel cardAttacking) {
		this.cardAttacking = cardAttacking;
	}

	private boolean makeDommage(MouseEvent e, final int dommage)
	{
		if ((((CardPanel) e.getComponent()).getCard()) instanceof Invisible){
			if (((Invisible)((CardPanel) e.getComponent()).getCard()).isInvisible() == true)
			{
				JOptionPane.showMessageDialog(null, "Vous ne pouvez pas attaquer ce serviteur car il est invisible");
				return false;
			}
			else{
				dommageClicked((CardPanel)e.getComponent(), dommage);
				dommageClicked(cardAttacking, ((Serviteur)((CardPanel)e.getComponent()).getCard()).getNbDommage());
				return true;
			}
		}
		else{
			if (checkListProtection(getTerrainAdv()) == false || (((CardPanel)e.getComponent()).getCard()) instanceof Protection== true){
				dommageClicked((CardPanel)e.getComponent(), dommage);
				dommageClicked(cardAttacking, ((Serviteur)((CardPanel)e.getComponent()).getCard()).getNbDommage());
				return true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "L'adversaire a un serviteur sous protection, vous devez l'attaquer!");
				return false;
			}
		}
	}

	protected void dommageClicked(CardPanel card, final int dommage)
	{
		if (((Serviteur) (card.getCard())).getNbVie()-dommage >0){
			((Serviteur)(card.getCard())).setNbVie(((Serviteur)(card.getCard())).getNbVie() - dommage);
			card.update();
		}
		else{
			((Serviteur)card.getCard()).setNbVie(0);
		}
		if (((Serviteur)card.getCard()).getNbVie() == 0){
			card.setVisible(false);
			card.getParent().remove(card);
			System.out.println(""+getTerrainAdv().getComponentCount());
		}
	}

	public void setTargetable(boolean check){
		this.isTargetable=check;
	}
}
