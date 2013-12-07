package be.ephec.eveStone.model.net.client;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Client {

	public static Socket socket = null;
	public static Thread t1;
	
	public Client(String ip) {
	
		
	try {
		
		System.out.println("Tentative de connexion");
		socket = new Socket(ip,2013);
		JOptionPane.showMessageDialog(null, "Connexion établie avec le serveur"); // Si le message s'affiche c'est que je suis connect�
		
		t1 = new Thread(new Connexion(socket));
		t1.start();
		
		
		
	} catch (UnknownHostException e) {
	  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
	} catch (IOException e) {
	  System.err.println("Aucun serveur sur le port"+socket.getLocalPort());
	}
	
	

	}

}