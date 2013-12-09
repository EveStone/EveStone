package be.ephec.eveStone.model.net;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import be.ephec.eveStone.model.Hero;


public class Reception implements Runnable {

	private ObjectInputStream ois;
	private String message = null;

	public Reception(ObjectInputStream ois){
		this.ois = ois;
	}

	public void run() {

		while(true){
			if(ois != null)
			{
				try {
					message = (String) ois.readObject();
					System.out.println("EUREKA" + message);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}



