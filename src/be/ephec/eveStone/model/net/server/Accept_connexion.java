package be.ephec.eveStone.model.net.server;

import java.io.*;
import java.net.*;

import be.ephec.eveStone.controller.Controller;


public class Accept_connexion implements Runnable{

	private ServerSocket socketserver = null;
	private Controller controller;

	public Accept_connexion(ServerSocket ss, Controller controller){
	 socketserver = ss;
	 this.controller = controller;
	 
	}
	
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
