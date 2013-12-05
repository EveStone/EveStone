package be.ephec.eveStone.model.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MySocketSideServer implements Runnable {

	private Socket s;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int num;

	public MySocketSideServer(Socket s, int num) {
		try {
			this.s = s;
			this.num = num;
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public void run() {
		while (!s.isClosed())
		{
			ObjectSend obj = null;
			try {
				obj = (ObjectSend) this.ois.readObject();
				int action = obj.getAction();
				Object o = obj.getObj();
				System.out.println("Numéro de l'action" + action);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					s.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}//lecture bloquante
			
		}
	}
	
}
