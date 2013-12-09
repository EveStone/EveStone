package be.ephec.eveStone.model.net.client;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;


public class MyClient extends Socket{

	public static Socket socket = null;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public MyClient(String ip) throws UnknownHostException, IOException {
		super(ip,2013);
		oos = new ObjectOutputStream(this.getOutputStream());
		ois = new ObjectInputStream(this.getInputStream());
		JOptionPane.showMessageDialog(null, "Connexion établie avec le serveur"); // Si le message s'affiche c'est que je suis connect�

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