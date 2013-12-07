package be.ephec.eveStone.model.net.server;

import java.io.*;
import java.net.*;


public class Accept_connexion implements Runnable{

	private ServerSocket socketserver = null;
	private PrintWriter out = null;
	private Socket socket = null;

	public Thread t1;
	public Accept_connexion(ServerSocket ss){
	 socketserver = ss;
	}
	
	public void run() {
		
		try {
			while(true){
				
			socket = socketserver.accept();
			System.out.println("Un client s'ait connecté ");
			
			out = new PrintWriter(socket.getOutputStream());
			out.println("connecte");
			out.flush();
			
			t1 = new Thread(new ClientServer(socket));
			t1.start();
			
			}
		} catch (IOException e) {
			
			System.err.println("Erreur serveur");
		}
		
	}
}
