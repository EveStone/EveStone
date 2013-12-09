package be.ephec.eveStone.model.net;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JPanel;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Hero;
import be.ephec.eveStone.vieuw.Area;


public class Reception implements Runnable {

	private ObjectInputStream ois;
	private ObjectSend message = null;
	private Area area = null;
	private boolean check = false;

	public Reception(Area area,ObjectInputStream ois){
		this.ois = ois;
		this.area = area;
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
						System.out.println("Coucou ca passe");
						area.getjPanelTerrainAdversaire().add((JLabel) message.getObj());
						area.revalidate();
						area.repaint();
					}
					else if (choix == 2) //pour les changements de JpanelTerrain
					{
						
					}
					else if (choix == 3) //Pour les changements de point de vie du hero adverse
					{
					
					}
					else if (choix == 4) //
					{
						
					}
					else if (choix == 5)//Pour les fin de tour
					{
						check = true;
					}
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		this.area.getFinTourButton().setEnabled(true);
	}
}



