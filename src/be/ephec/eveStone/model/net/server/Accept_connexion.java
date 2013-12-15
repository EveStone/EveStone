package be.ephec.eveStone.model.net.server;

import java.io.*;
import java.net.*;

import be.ephec.eveStone.controller.Controller;



/**
 * The Class Accept_connexion.
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 */
public class Accept_connexion implements Runnable{

	/** The socketserver. */
	private ServerSocket socketserver = null;
	
	/** The controller. */
	private Controller controller;

	/**
	 * Instantiates a new accept_connexion.
	 *
	 * @param ss the ss
	 * @param controller the controller
	 */
	public Accept_connexion(ServerSocket ss, Controller controller){
	 socketserver = ss;
	 this.controller = controller;
	 
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		
		try {
			while(true){
				
			Socket s = socketserver.accept();
			controller.setMyClientServer(new ClientServer(s));
			System.out.println("Un client s'ait connecté ");
			
	
			
			}
		} catch (IOException e) {
			
			System.err.println("Erreur serveur");
		}
		
	}
}
