package be.ephec.eveStone.model.net.client;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;


// TODO: Auto-generated Javadoc
/**
 * The Class MyClient.
 */
public class MyClient extends Socket{

	/** The socket. */
	public static Socket socket = null;
	
	/** The oos. */
	private ObjectOutputStream oos;
	
	/** The ois. */
	private ObjectInputStream ois;

	/**
	 * Instantiates a new my client.
	 *
	 * @param ip the ip
	 * @param numPort the num port
	 * @throws UnknownHostException the unknown host exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public MyClient(String ip, int numPort) throws UnknownHostException, IOException {
		super(ip, numPort);
		oos = new ObjectOutputStream(this.getOutputStream());
		ois = new ObjectInputStream(this.getInputStream());
		JOptionPane.showMessageDialog(null, "Connexion établie avec le serveur"); // Si le message s'affiche c'est que je suis connect�

	}

	/**
	 * Gets the socket.
	 *
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}
	
	/**
	 * Gets the ois.
	 *
	 * @return the ois
	 */
	public ObjectInputStream getOis() {
		return ois;
	}

	/**
	 * Sets the ois.
	 *
	 * @param ois the new ois
	 */
	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	/**
	 * Gets the oos.
	 *
	 * @return the oos
	 */
	public ObjectOutputStream getOos() {
		return oos;
	}

	/**
	 * Sets the oos.
	 *
	 * @param oos the new oos
	 */
	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
}