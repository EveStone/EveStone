package be.ephec.eveStone.model.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import be.ephec.eveStone.controller.Controller;


public class MyServer {

	private static int numPort=2013;
	private Thread t;
	private ServerSocket s;

	public MyServer(Controller controller) throws IOException {
		this.s = new ServerSocket(numPort);
		System.out.println("Le serveur est à l'écoute du port "+s.getLocalPort());
		
		t = new Thread(new Accept_connexion(s, controller));
		t.setDaemon(true);
		t.start();
		

	}

	public ServerSocket getS() {
		return s;
	}
	public int getNumPort()
	{
		return numPort;
	}
	
	
	

}
