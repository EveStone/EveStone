package be.ephec.eveStone.model.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.net.ObjectSend;

public class FinTourListener implements MouseListener{

	private Controller controller;

	public FinTourListener(Controller controller){
		this.controller=controller;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getComponent().isEnabled())
		{
			jButtonFinTourClicked(arg0);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
		
		controller.stateOfEnd();
		
		controller.getArea().revalidate();
		controller.getArea().repaint();
		evt.getComponent().setEnabled(false);
		
		sendBoutonFin();
	}
	public void sendBoutonFin()
	{
		try {
			if (controller.getMyClient() == null)
			{
				controller.getMyClientServer().getOos().writeObject(new ObjectSend(5, "Fin de tour",controller.getArea().getjPanelMain().getComponentCount()));
			}
			else
			{
				controller.getMyClient().getOos().writeObject(new ObjectSend(5, "Fin de tour"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setTargetableFalse(){
		MouseListener ml[];
		for(int i=0; i<controller.getArea().getjPanelTerrainAdversaire().getComponentCount(); i++){
			ml = controller.getArea().getjPanelTerrainAdversaire().getComponent(i).getMouseListeners();
			((CardListenerTerrainAdv)ml[0]).setTargetable(false);
		}
		ml = controller.getArea().getjLabelHerosAdversaire().getMouseListeners();
		((HerosListener)ml[0]).setTargetable(false);
	}

	private void setCanAttack(){
		MouseListener ml[];
		for (int i=0; i<controller.getArea().getjPanelTerrain().getComponentCount(); i++){
			System.out.println("terrain : "+i);
			ml = controller.getArea().getjPanelTerrain().getComponent(i).getMouseListeners();
			((CardListenerTerrain)ml[0]).setCanAttack(true);
		}
	}

}
