package be.ephec.eveStone.model.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.net.ObjectSend;


/**
 * The listener interface for receiving finTour events.
 * The class that is interested in processing a finTour
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addFinTourListener<code> method. When
 * the finTour event occurs, that object's appropriate
 * method is invoked.
 *
 * @see FinTourEvent
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 */
public class FinTourListener implements MouseListener{

	/** The controller. */
	private Controller controller;

	/**
	 * Instantiates a new fin tour listener.
	 *
	 * @param controller the controller
	 */
	public FinTourListener(Controller controller){
		this.controller=controller;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getComponent().isEnabled())
		{
			jButtonFinTourClicked(arg0);
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * J button fin tour clicked.
	 *
	 * @param evt the evt
	 */
	protected void jButtonFinTourClicked(MouseEvent evt) {
		Controller.nbTour++;
		if (Controller.nbTour < Controller.NB_MAX_RESSOURCE)
		{
			controller.getMyHero().setRessource(Controller.nbTour);
		}
		else
		{
			controller.getMyHero().setRessource(Controller.NB_MAX_RESSOURCE);
		}
		setTargetableFalse();
		controller.getArea().getjLabelRessource().setText("<html><font color=white>"+controller.getMyHero().getRessource()+"</font></html>");
		setCanAttack();
		
		try{
			if(controller.getMyClient() == null)
				controller.getMyClientServer().getOos().writeObject(new ObjectSend(4, controller.getMyHero().getRessource()));
			else
				controller.getMyClient().getOos().writeObject(new ObjectSend(4, controller.getMyHero().getRessource()));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		controller.stateOfEnd();
		
		controller.getArea().revalidate();
		controller.getArea().repaint();
		evt.getComponent().setEnabled(false);
		
		sendBoutonFin();
	}
	
	/**
	 * Send bouton fin.
	 */
	public void sendBoutonFin()
	{
		try {
			if (controller.getMyClient() == null)
			{
				controller.getMyClientServer().getOos().writeObject(new ObjectSend(5, "Fin de tour",controller.getArea().getjPanelMain().getComponentCount()));
			}
			else
			{
				controller.getMyClient().getOos().writeObject(new ObjectSend(5, "Fin de tour",controller.getArea().getjPanelMain().getComponentCount()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the targetable false.
	 */
	private void setTargetableFalse(){
		MouseListener ml[];
		for(int i=0; i<controller.getArea().getjPanelTerrainAdversaire().getComponentCount(); i++){
			ml = controller.getArea().getjPanelTerrainAdversaire().getComponent(i).getMouseListeners();
			((CardListenerTerrainAdv)ml[0]).setTargetable(false);
		}
		ml = controller.getArea().getjLabelHerosAdversaire().getMouseListeners();
		((HerosListener)ml[0]).setTargetable(false);
	}

	/**
	 * Sets the can attack.
	 */
	private void setCanAttack(){
		MouseListener ml[];
		for (int i=0; i<controller.getArea().getjPanelTerrain().getComponentCount(); i++){
			ml = controller.getArea().getjPanelTerrain().getComponent(i).getMouseListeners();
			((CardListenerTerrain)ml[0]).setCanAttack(false);
		}
	}

}
