package be.ephec.eveStone.model.net;


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
import javax.swing.JPanel;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Hero;
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
						CardPanel carte = (CardPanel) message.getObj();
						controller.getArea().getjPanelTerrain().getComponent(message.getIndex()).setVisible(false);
						carte.addMouseListener(new CardListenerTerrain(carte, controller.getArea()));
						if (((Serviteur)(carte.getCard())).getNbVie()>0){
							carte.addMouseListener(new CardListenerTerrain(carte, controller.getArea()));
							controller.getArea().getjPanelTerrain().add(carte);
						}
						controller.getArea().revalidate();
						controller.getArea().repaint();
					}
					else if (choix == 3) 
					{
						System.out.println("Je change le terrain adverse");
						CardPanel carte = (CardPanel) message.getObj();
						if (((Serviteur)(carte.getCard())).getNbVie()>0){
							carte.addMouseListener(new CardListenerTerrainAdv(carte, controller));
							controller.getArea().getjPanelTerrainAdversaire().add(carte);
						}
						carte.addMouseListener(new CardListenerTerrainAdv(carte, controller));
						controller.getArea().getjPanelTerrainAdversaire().remove(message.getIndex());
						controller.getArea().getjPanelTerrainAdversaire().add(carte);
						controller.getArea().revalidate();
						controller.getArea().repaint();
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
					//e.printStackTrace();
				}
			}
		}
	}
}



