package be.ephec.eveStone.model.net.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * The Class ClientServer.
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 */
public class ClientServer {

	/** The socket. */
	private Socket socket;
	
	/** The ois. */
	private ObjectInputStream ois;
	
	/** The oos. */
	private ObjectOutputStream oos;
	
	/**
	 * Instantiates a new client server.
	 *
	 * @param s the s
	 */
	public ClientServer(Socket s) {
		try {
			this.socket = s;
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
