package be.ephec.eveStone.model.net;


import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Hero;
import be.ephec.eveStone.model.Invisible;
import be.ephec.eveStone.model.Serviteur;
import be.ephec.eveStone.model.listener.CardListenerMain;
import be.ephec.eveStone.model.listener.CardListenerTerrain;
import be.ephec.eveStone.model.listener.CardListenerTerrainAdv;
import be.ephec.eveStone.model.listener.SortHerosListener;
import be.ephec.eveStone.vieuw.Area;
import be.ephec.eveStone.vieuw.container.CardPanel;


public class Reception implements Runnable {

	private ObjectInputStream ois;
	private ObjectSend message = null;
	private Controller controller;
	private boolean check = false;
	private Component[] terrainAdv; 
	private Component[] terrain;

	public Reception(Controller controller,ObjectInputStream ois){
		this.ois = ois;
		this.controller = controller;
	}

	public void run() {

		while(check != true){
			if(ois != null)
			{
				try {
					message = (ObjectSend) ois.readObject();
					int choix = message.getAction();
					if (choix == 1) //pour les changements de jPanelTerrainAdversaire
					{
						CardPanel carte = (CardPanel) message.getObj();
						carte.showInfo(false);
						carte.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource((carte.getCard().getImage()))).getImage().getScaledInstance(85, 132, Image.SCALE_AREA_AVERAGING)));
						carte.addMouseListener(new CardListenerTerrainAdv(carte, controller));
						controller.getArea().getjPanelTerrainAdversaire().add(carte);
						controller.getArea().getjPanelMainAdversaire().remove(controller.getArea().getComponent(controller.getArea().getComponentCount()-1));
						controller.getArea().revalidate();
						controller.getArea().repaint();
					}
					else if (choix == 2) //pour les changements de degats de carte attaqué
					{
						System.out.println("Je change mon terrain");
						controller.getArea().getjPanelTerrainAdversaire().removeAll();
						controller.getArea().getjPanelTerrain().removeAll();

						int[] nbVieTerrain = message.getNbVieTerrain();
						int[] nbDegatsTerrain = message.getNbDegatsTerrain();
						int[] nbVieAdv = message.getNbVieAdv();
						int[] nbDegatsAdv = message.getNbDegatsAdv();
						Boolean[] visibleTerrain = message.getVisibleTerrain();
						Boolean[] visibleTerrainAdv = message.getVisibleTerrainAdv();

						terrain = (Component[]) message.getTerrain();
						for (int i =0; i<terrain.length; i++)
						{
							controller.getArea().getjPanelTerrainAdversaire().add((CardPanel) terrain[i]);
							controller.getArea().getjPanelTerrainAdversaire().getComponent(i).addMouseListener(new CardListenerTerrainAdv((CardPanel)controller.getArea().getjPanelTerrainAdversaire().getComponent(i),controller));

							if (nbVieTerrain != null)
							{
								((Serviteur)((CardPanel)controller.getArea().getjPanelTerrainAdversaire().getComponent(i)).getCard()).setNbVie(nbVieTerrain[i]);
							}
							if (nbDegatsTerrain != null)
							{
								((Serviteur)((CardPanel)controller.getArea().getjPanelTerrainAdversaire().getComponent(i)).getCard()).setNbDommage(nbDegatsTerrain[i]);
							}
							if (visibleTerrain != null && ((CardPanel)controller.getArea().getjPanelTerrainAdversaire().getComponent(i)).getCard() instanceof Invisible)
							{
								((Invisible)((CardPanel)controller.getArea().getjPanelTerrainAdversaire().getComponent(i)).getCard()).setInvisible(visibleTerrain[i]);
							}
							((CardPanel)controller.getArea().getjPanelTerrainAdversaire().getComponent(i)).update();
						}

						terrainAdv = (Component[]) message.getTerrainAdv();
						for (int i =0; i<terrainAdv.length; i++)
						{
							controller.getArea().getjPanelTerrain().add((CardPanel) terrainAdv[i]);
							if(controller.getArea().getFinTourButton().isEnabled())
							{
								controller.getArea().getjPanelTerrain().getComponent(i).addMouseListener(new CardListenerTerrain((CardPanel)controller.getArea().getjPanelTerrain().getComponent(i),controller.getArea()));
							}
							if(nbVieAdv !=null)
							{
								((Serviteur)((CardPanel)controller.getArea().getjPanelTerrain().getComponent(i)).getCard()).setNbVie(nbVieAdv[i]);
							}
							if(nbDegatsAdv != null)
							{
								((Serviteur)((CardPanel)controller.getArea().getjPanelTerrain().getComponent(i)).getCard()).setNbDommage(nbDegatsAdv[i]);
							}
							if (visibleTerrainAdv!= null && ((CardPanel)controller.getArea().getjPanelTerrain().getComponent(i)).getCard() instanceof Invisible)
							{
								((Invisible)((CardPanel)controller.getArea().getjPanelTerrain().getComponent(i)).getCard()).setInvisible(visibleTerrainAdv[i]);
							}
							((CardPanel)controller.getArea().getjPanelTerrain().getComponent(i)).update();
						}

						controller.getArea().revalidate();
						controller.getArea().repaint();
					}
					else if (choix == 3) 
					{
						int nbCoque = message.getNbCoque();
						int nbStructure = message.getNbStruct();
						
						if (nbStructure <=0)
						{
							JOptionPane.showMessageDialog(null, "Vous avez perdu");
							System.exit(0);
						}
						else
						{
							controller.getMyHero().setNbCoque(nbCoque);
							controller.getMyHero().setNbStructure(nbStructure);
							controller.getArea().getjLabelCoque().setText("<html><font color=black>" +controller.getMyHero().getNbCoque() +"</font></html>");
							controller.getArea().getjLabelStructure().setText("<html><font color=white>" +controller.getMyHero().getNbStructure() +"</font></html>");
							controller.getArea().revalidate();
							controller.getArea().repaint();
						}
					}
					else if (choix == 4) 
					{

					}
					else if (choix == 5) //bouton fin de tour
					{
						controller.getArea().getFinTourButton().setEnabled(true);
						MouseListener ml[] = controller.getArea().getjLabelSortHeroique().getMouseListeners();
						((SortHerosListener)ml[0]).setEnable(true);
						for (int i = 0; i<controller.getArea().getjPanelTerrain().getComponentCount(); i++)
						{
							controller.getArea().getjPanelTerrain().getComponent(i).addMouseListener(new CardListenerTerrain((CardPanel)controller.getArea().getjPanelTerrain().getComponent(i),controller.getArea()));
						}
						for (int i = 0; i<controller.getArea().getjPanelMain().getComponentCount(); i++)
						{
							controller.getArea().getjPanelMain().getComponent(i).addMouseListener(new CardListenerMain((CardPanel)controller.getArea().getjPanelMain().getComponent(i), controller.getArea().getLabelInfo()));
						}
						controller.pioche();

					}
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					System.err.println("Erreur reception");
				}
			}
		}
	}
}



