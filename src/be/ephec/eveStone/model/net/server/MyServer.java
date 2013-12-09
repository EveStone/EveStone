package be.ephec.eveStone.model.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class MyServer {

	private static int numPort=2013;
	private Thread t;
	private ServerSocket s;

	public MyServer() throws IOException {
		this.s = new ServerSocket(numPort);
		System.out.println("Le serveur est à l'écoute du port "+s.getLocalPort());
		
		t = new Thread(new Accept_connexion(s));
		t.start();
		

	}

	public ServerSocket getS() {
		return s;
	}
	
	
	

}
