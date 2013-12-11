package be.ephec.eveStone.model.listener;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Heros;
import be.ephec.eveStone.model.Serviteur;
import be.ephec.eveStone.model.net.ObjectSend;
import be.ephec.eveStone.vieuw.Area;
import be.ephec.eveStone.vieuw.container.CardPanel;
/**
 * Classe qui s'occupe de gérer les sort héroiques du  héros
 * 
 * Lorsque que l'on clique sur le sort héroique, le listenner determine quelle action il dit faire
 * en fonction du type du sort (Attaque, invocation).
 * 
 * Si il s'agit d'un sort d'attaque, on active la target sur les carte du terrain adverse. Les carte adverses
 * deviennent alors clicable et subissent les degats du sort.
 * 
 * Si il s'agit d'un invocation, on ajoute tout simplement le serviteur sur le terrain
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 *
 */
public class SortHerosListener implements MouseListener{

	private boolean enable;
	private JPanel terrain;
	private JPanel terrainAdv;
	private JLabel infoLabel;
	private Heros heros;
	private boolean offensive;
	private JLabel ressource;
	private JLabel labelHeros;
	private Area area;
	private Controller controller;
	
	private static final Cursor dispo = new Cursor(Cursor.HAND_CURSOR);
	private static final Cursor nonDispo = new Cursor(Cursor.DEFAULT_CURSOR);

	public SortHerosListener(Heros heros, Controller controller){
		super();
		this.enable=true;
		this.terrain=controller.getArea().getjPanelTerrain();
		this.terrainAdv=controller.getArea().getjPanelTerrainAdversaire();
		this.infoLabel=controller.getArea().getLabelInfo();
		this.heros=heros;
		this.ressource=controller.getArea().getjLabelRessource();
		this.labelHeros=controller.getArea().getjLabelHerosAdversaire();
		this.area = controller.getArea();
		this.controller = controller;
		offensive=isOffensive();
	}
	/**
	 * On vérifie si le sort héroique est disponible.
	 * On vérifie ensuite si les ressource sont suffisante pour lancer le sort
	 * On Vérifie si le sort est de nature offensive
	 * 		si oui, on ajoute une target sur les carte adverse avec le sort (on retire la carte qui pourrait avoir été enreigstrée
	 * 		comme attaquante)
	 * 		
	 * 		si non, on ajoute un serviteur au panel terrain
	 * 
	 * (A MODIFIER PROCHAINEMENT) : la nature du sort sera définir suivant un champs, afin de pouvoir appliquer d'autre
	 * effets supplémentaire (buff, degats sur plusieurs adversaires, débuff enemmis, neutralisation, ect...)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (enable){
			if (heros.getRessource() >= heros.getSortHero().getRessource()){
				if (offensive){
					MouseListener ml[];
					for(int i=0; i<terrainAdv.getComponentCount(); i++){
						ml = terrainAdv.getComponent(i).getMouseListeners();
						((CardListenerTerrainAdv)ml[0]).setTargetable(true);
						((CardListenerTerrainAdv)ml[0]).setSortHero(heros.getSortHero(), (JLabel)arg0.getComponent());
						((CardListenerTerrainAdv)ml[0]).setCardAttacking(null);
					}
					ml = labelHeros.getMouseListeners();
					((HerosListener)ml[0]).setSortAttacking(heros.getSortHero());
					((HerosListener)ml[0]).setTargetable(true);
				}
				else{
					CardPanel minion = new CardPanel();
					minion.setCard(new Serviteur("Hornet", 2, "img/FregateCard/hornet.png", "Drone d'attaque léger", 2, 2));
					minion.makeCard();
					minion.showInfo(false);
					minion.addMouseListener(new CardListenerTerrain(minion, area));
					System.out.println(minion.getCard().getNom());
					terrain.add(minion);
					if (controller.getMyClient()== null)
					{
						try {
							controller.getMyClientServer().getOos().writeObject(new ObjectSend(1, minion));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else 
					{
						try {
							controller.getMyClient().getOos().writeObject(new ObjectSend(1, minion));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					terrain.revalidate();
					terrain.repaint();
				}
				this.setEnable(false);
				heros.setRessource(heros.getRessource()-heros.getSortHero().getRessource());
				ressource.setText("<html><font color=white>"+heros.getRessource()+"</font></html>");
				ressource.revalidate();
				ressource.repaint();
			}
			else
				JOptionPane.showMessageDialog(null, "Ressources inssufisantes !");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		infoLabel.setText("<html><font color=white>Carte : "+heros.getSortHero().getNom()+"<br/><br/>"
				+"Type : Sort Héros<br/><br/>"
				+"Description : "+heros.getSortHero().getDescription()+"</font></html>");
		if(enable)
			arg0.getComponent().setCursor(dispo);
		else
			arg0.getComponent().setCursor(nonDispo);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		infoLabel.setText("<html><font color=white>Carte : <br/><br/>"
				+"Type :<br/><br/>"
				+"Description : </font></html>");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	public void setEnable(boolean check){
		this.enable=check;
	}

	private boolean isOffensive(){
		if(heros.getSortHero().getDegats()==0)
			return false;
		else
			return true;
	}

}
