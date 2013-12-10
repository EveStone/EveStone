package be.ephec.eveStone.model.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import be.ephec.eveStone.controller.Controller;

public class FinTourListener implements MouseListener{

	private Controller controller;
	
	public FinTourListener(Controller controller){
		this.controller=controller;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		jButtonFinTourClicked(arg0);
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
		MouseListener ml[] = controller.getArea().getjLabelSortHeroique().getMouseListeners();
		((SortHerosListener)ml[0]).setEnable(true);
		controller.getArea().revalidate();
		controller.getArea().repaint();
		controller.pioche();
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
