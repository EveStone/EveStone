package be.ephec.eveStone.model.net.client;


import java.io.*;
import java.net.*;
import java.util.Scanner;

import be.ephec.eveStone.model.net.Emission;
import be.ephec.eveStone.model.net.Reception;


public class Send_Client implements Runnable {

	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Thread t3, t4;
	
	public Send_Client(Socket s){
		socket = s;
	}
	
	public void run() {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			
			//Thread t4 = new Thread(new Emission(oos));
			//t4.start();
			//Thread t3 = new Thread(new Reception(ois));
			//t3.start();
		
		   
		    
		} catch (IOException e) {
			System.err.println("Le serveur distant s'est déconnecté !");
		}
	}

}
