package be.ephec.eveStone.model.net;


import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Invisible;
import be.ephec.eveStone.model.Serviteur;
import be.ephec.eveStone.model.listener.CardListenerMain;
import be.ephec.eveStone.model.listener.CardListenerTerrain;
import be.ephec.eveStone.model.listener.CardListenerTerrainAdv;
import be.ephec.eveStone.model.listener.SortHerosListener;
import be.ephec.eveStone.vieuw.container.CardPanel;

/**
 * Cette classe permet la réception des objets que l'adveraire envoie.
 * @author Andy Vanbutsele et Dasseler Nicolas
 *
 */
public class Reception implements Runnable {

	/** The ois. */
	private ObjectInputStream ois;
	
	/** The message. */
	private ObjectSend message = null;
	
	/** The controller. */
	private Controller controller;
	
	/** The check. */
	private boolean check = false;
	
	/** The terrain adv. */
	private Component[] terrainAdv; 
	
	/** The terrain. */
	private Component[] terrain;

	/**
	 * Instantiates a new reception.
	 *
	 * @param controller the controller
	 * @param ois the ois
	 */
	public Reception(Controller controller,ObjectInputStream ois){
		this.ois = ois;
		this.controller = controller;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
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
						controller.getArea().revalidate();
						controller.getArea().repaint();
					}
					else if (choix == 2) //pour les changements de degats de carte attaqué
					{
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
							MouseListener ml[] = terrain[i].getMouseListeners();
							for(int j=0; j<ml.length; j++){
								terrain[i].removeMouseListener(ml[j]);
							}
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
							MouseListener ml[] = terrainAdv[i].getMouseListeners();
							for(int j=0; j<ml.length; j++){
								terrainAdv[i].removeMouseListener(ml[j]);
							}
							controller.getArea().getjPanelTerrain().add((CardPanel) terrainAdv[i]);
							if(controller.getArea().getFinTourButton().isEnabled() || (visibleTerrainAdv!= null && ((CardPanel)controller.getArea().getjPanelTerrain().getComponent(i)).getCard() instanceof Invisible))
							{
								((Invisible)((CardPanel)controller.getArea().getjPanelTerrain().getComponent(i)).getCard()).setInvisible(visibleTerrainAdv[i]);
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

							controller.getArea().getjPanelTerrain().getComponent(i).addMouseListener(new CardListenerTerrain((CardPanel)controller.getArea().getjPanelTerrain().getComponent(i),controller.getArea()));
							((CardPanel)controller.getArea().getjPanelTerrain().getComponent(i)).update();
						}

						controller.getArea().revalidate();
						controller.getArea().repaint();
					}
					else if (choix == 3) 
					{
						int nbCoque = message.getNbCoque();
						int nbStructure = message.getNbStruct();
						boolean[] visibleTerrainAdv = (boolean[]) message.getTerrainAdv();

						if (nbStructure <=0)
						{
							JOptionPane.showMessageDialog(null, "Vous avez perdu");
							System.exit(0);
						}
						else
						{
							if (terrainAdv != null){
								for (int i = 0; i<terrainAdv.length; i++)
								{
									if (visibleTerrainAdv!= null && ((CardPanel)controller.getArea().getjPanelTerrainAdversaire().getComponent(i)).getCard() instanceof Invisible)
									{
										((Invisible)((CardPanel)controller.getArea().getjPanelTerrainAdversaire().getComponent(i)).getCard()).setInvisible(visibleTerrainAdv[i]);
									}
								}
								controller.getMyHero().setNbCoque(nbCoque);
								controller.getMyHero().setNbStructure(nbStructure);
								controller.getArea().getjLabelCoque().setText("<html><font color=black>" +controller.getMyHero().getNbCoque() +"</font></html>");
								controller.getArea().getjLabelStructure().setText("<html><font color=white>" +controller.getMyHero().getNbStructure() +"</font></html>");
								controller.getArea().revalidate();
								controller.getArea().repaint();
							}
						}
					}
					else if (choix == 4)
					{
						int nbRessource = (int)message.getObj();
						controller.getAdverseHero().setRessource(nbRessource);
						controller.getArea().getjLabelRessourceAdversaire().setText("<html><font color=white>"+controller.getAdverseHero().getRessource()+"</font></html>");
					}
					else if (choix == 5) //bouton fin de tour
					{
						JOptionPane.showMessageDialog(null, "Votre tour");
						controller.getArea().getjLabelRessourceAdversaire().setText("<html><font color=white>"+controller.getAdverseHero().getRessource()+"</font></html>");
						int nbCarteMainAdv = message.getNbCarteMain();
						controller.getArea().getjPanelMainAdversaire().removeAll();
						for (int i = 0; i<nbCarteMainAdv;i++)
						{
							JLabel label = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("img/CarteDosV3.png")));
							controller.getArea().getjPanelMainAdversaire().add(label);
						}
						controller.getArea().getFinTourButton().setEnabled(true);
						MouseListener ml[] = controller.getArea().getjLabelSortHeroique().getMouseListeners();
						((SortHerosListener)ml[0]).setEnable(true);
						for (int i = 0; i<controller.getArea().getjPanelTerrain().getComponentCount(); i++)
						{
							ml = controller.getArea().getjPanelTerrain().getComponent(i).getMouseListeners();
							((CardListenerTerrain)ml[0]).setCanAttack(true);
						}
						for (int i = 0; i<controller.getArea().getjPanelMain().getComponentCount(); i++)
						{
							controller.getArea().getjPanelMain().getComponent(i).addMouseListener(new CardListenerMain((CardPanel)controller.getArea().getjPanelMain().getComponent(i), controller.getArea().getLabelInfo()));
						}
						controller.pioche();

					}
				} catch (ClassNotFoundException | IOException e) {
					System.err.println("Erreur reception");
					JOptionPane.showMessageDialog(null, "Connexion avec le serveur perdue");
					System.exit(0);
				}
			}
		}
	}
}



