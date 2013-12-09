package be.ephec.eveStone.model.net.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import be.ephec.eveStone.model.net.Emission;
import be.ephec.eveStone.model.net.Reception;


public class ClientServer implements Runnable {

	private Socket socket;
	private Thread t3, t4;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public ClientServer(Socket s) {
		this.socket = s;
	}
	@Override
	public void run() {
		
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			
			System.out.println("Client serveur connecté");
			
			//Thread t3 = new Thread(new Reception(ois));
			//t3.start();
			//Thread t4 = new Thread(new Emission(oos));
			//t4.start();
			
			} catch (IOException e) {
				System.err.println(" Le client s'est déconnecté ");
			}
		
	}
	public Socket getSocket() {
		return socket;
	}
	

}
