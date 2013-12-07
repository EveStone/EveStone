package be.ephec.eveStone.model.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Emission implements Runnable {

	private ObjectOutputStream oos;
	private ObjectSend message = null;

	public Emission(ObjectOutputStream oos, ObjectSend message) {
		this.oos = oos;
		this.message = message;
	}


	public void run() {


		while(true){
			if (message != null)
			{
				try {
					oos.writeObject((Object) message);
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
