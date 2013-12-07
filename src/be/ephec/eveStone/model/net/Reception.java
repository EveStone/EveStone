package be.ephec.eveStone.model.net;


import java.io.IOException;
import java.io.ObjectInputStream;


public class Reception implements Runnable {

	private ObjectInputStream ois;
	private ObjectSend message = null;

	public Reception(ObjectInputStream ois){

		this.ois = ois;
	}

	public void run() {

		while(true){

				try {
					message = (ObjectSend) ois.readObject();
					System.out.println("Le serveur vous dit :" +message);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			
		}
	}
}


