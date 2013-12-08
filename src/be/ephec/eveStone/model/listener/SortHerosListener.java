package be.ephec.eveStone.model.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.ephec.eveStone.model.Hero;
import be.ephec.eveStone.model.Serviteur;
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
	private Hero heros;
	private boolean offensive;
	private JLabel ressource;

	public SortHerosListener(JPanel terrain, JPanel terrainAdv, JLabel infoLabel, Hero heros, JLabel ressource){
		super();
		this.enable=true;
		this.terrain=terrain;
		this.terrainAdv=terrainAdv;
		this.infoLabel=infoLabel;
		this.heros=heros;
		this.ressource=ressource;
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
					for(int i=0; i<terrainAdv.getComponentCount(); i++){
						MouseListener ml[] = terrainAdv.getComponent(i).getMouseListeners();
						((CardListenerTerrainAdv)ml[0]).setTargetable(true);
						((CardListenerTerrainAdv)ml[0]).setSortHero(heros.getSortHero(), (JLabel)arg0.getComponent());
						((CardListenerTerrainAdv)ml[0]).setCardAttacking(null);
					}
				}
				else{
					CardPanel minion = new CardPanel();
					minion.setCard(new Serviteur("Hornet", 2, "img/FregateCard/hornet.png", "Drone d'attaque léger", 2, 2));
					minion.makeCard();
					minion.showInfo(false);
					minion.addMouseListener(new CardListenerTerrain(minion, infoLabel, terrain, terrainAdv));
					System.out.println(minion.getCard().getNom());
					MouseListener ml[] = arg0.getComponent().getMouseListeners();
					((SortHerosListener)ml[0]).setEnable(false);
					terrain.add(minion);
					terrain.revalidate();
					terrain.repaint();
				}
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
				+"Desciption : "+heros.getSortHero().getDescription()+"</font></html>");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		infoLabel.setText("<html><font color=white>Carte : <br/><br/>"
				+"Type :<br/><br/>"
				+"Desciption : </font></html>");
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
