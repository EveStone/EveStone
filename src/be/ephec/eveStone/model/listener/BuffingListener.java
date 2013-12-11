package be.ephec.eveStone.model.listener;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Buff;
import be.ephec.eveStone.model.Carte;
import be.ephec.eveStone.model.Serviteur;
import be.ephec.eveStone.vieuw.container.CardPanel;

public class BuffingListener implements MouseListener{

	private CardPanel cardBuffing;
	private JPanel terrain;
	private Controller controller;

	public BuffingListener(CardPanel card, Controller controller){
		this.cardBuffing = card;
		this.terrain = controller.getArea().getjPanelTerrain();
		this.controller = controller;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		buffClicked(arg0, getBuff(cardBuffing.getCard()));
		arg0.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		for(int i=0; i<terrain.getComponentCount(); i++){
			if (!terrain.getComponent(i).equals(cardBuffing)){
				MouseListener ml[] = terrain.getComponent(i).getMouseListeners();
				terrain.getComponent(i).removeMouseListener(ml[ml.length-1]);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		arg0.getComponent().setCursor(new Cursor(Cursor.MOVE_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Cette methode recoit un event et buff la carte en fonction du tableau buff
	 * @param e: event non null
	 * @param buff[0] ==> pv
	 *        buff[1] ==> degats 
	 */
	protected void buffClicked(MouseEvent e,  int buff[])
	{
		System.out.println(e.getComponent().getName());
		System.out.println("vie : "+((Serviteur)((CardPanel) e.getComponent()).getCard()).getNbVie());
		((Serviteur)((CardPanel) e.getComponent()).getCard()).setNbVie(((Serviteur)((CardPanel) e.getComponent()).getCard()).getNbVie() + buff[0]);
		((Serviteur)((CardPanel) e.getComponent()).getCard()).setNbDommage(((Serviteur)((CardPanel) e.getComponent()).getCard()).getNbDommage() + buff[1]);
		((CardPanel) e.getComponent()).update();
		controller.sendModif();
	}

	/**
	 * Retourne un tableau de int pour le buff de la carte
	 * @param une carte ne peut pas être null
	 * @return buff[0] ==> pv
	 *         buff[1] ==> degats
	 */
	private int[] getBuff(Carte c)
	{
		int buff[] = {0 , 0};
		if (c instanceof Serviteur)
		{
			buff[0] = ((Serviteur) c).getServBuffPv();
			buff[1] = ((Serviteur) c).getServBuffDeg();
			return buff;
		}
		else if (c instanceof Buff)
		{
			buff[0] = ((Buff) c).getBuffPv();
			buff[1] = ((Buff) c).getBuffDegats();
			return buff;
		}
		else
		{
			return buff;
		}
	}

}
