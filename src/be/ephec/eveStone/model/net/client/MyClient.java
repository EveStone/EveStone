package be.ephec.eveStone.model.net.client;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class MyClient {

	public static Socket socket = null;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	

	public MyClient(String ip) {


		try {

			System.out.println("Tentative de connexion");
			socket = new Socket(ip,2013);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			JOptionPane.showMessageDialog(null, "Connexion établie avec le serveur"); // Si le message s'affiche c'est que je suis connect�



		} catch (UnknownHostException e) {
			System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
		} catch (IOException e) {
			System.err.println("Aucun serveur sur le port"+socket.getLocalPort());
		}
	}

	public Socket getSocket() {
		return socket;
	}
	public ObjectInputStream getOis() {
		return ois;
	}

	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}


}