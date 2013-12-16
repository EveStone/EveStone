package be.ephec.eveStone.model.net.server;

import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JOptionPane;

import be.ephec.eveStone.controller.Controller;



/**
 * The Class MyServer.
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 */
public class MyServer {

	/** The num port. */
	private static int numPort=2013;

	/** The t. */
	private Thread t;

	/** The s. */
	private ServerSocket s;

	/**
	 * Instantiates a new my server.
	 *
	 * @param controller the controller
	 * @throws InterruptedException the interrupted exception
	 */
	public MyServer(Controller controller) throws InterruptedException {
		while (this.s == null)
		{
			try {
				this.s = new ServerSocket(numPort);
			} catch (IOException  e) {
				numPort++;
			}
		}
		JOptionPane.showMessageDialog(null, "Le serveur est à l'écoute du port "+s.getLocalPort());
		t = new Thread(new Accept_connexion(s, controller));
		t.setDaemon(true);
		t.start();
	}

	/**
	 * Gets the s.
	 *
	 * @return the s
	 */
	public ServerSocket getS() {
		return s;
	}

	/**
	 * Gets the num port.
	 *
	 * @return the num port
	 */
	public int getNumPort()
	{
		return numPort;
	}
}
