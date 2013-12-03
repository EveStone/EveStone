package be.ephec.eveStone.model.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.UnknownHostException;

public class MyClient extends Socket implements Runnable {
	
	private ObjectOutputStream oos; 
	private ObjectInputStream ois;
	private int num;
	
	public MyClient(String host, int port) throws UnknownHostException,
			IOException {
		super(host, port);
		oos = new ObjectOutputStream(this.getOutputStream());
		ois = new ObjectInputStream(this.getInputStream());
	}
	
	public static void main(String[] args) {
		MyClient mc = null;
		try {
			mc = new MyClient("127.0.0.1",2013);
			String s = (String)mc.ois.readObject();
			System.out.println("Le client a reçu: " + s);
			
			mc.num = (int)mc.ois.readObject();
			System.out.println("Ceci est la console du numéro " + mc.num);
			
			Thread t = new Thread(mc);
			t.start();
			Thread.sleep(100);
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				mc.close();
				System.out.println("Le socket est fermé");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void ecrire(ObjectSend objS)
	{
		
	}

	@Override
	public void run() {
		while (!this.isClosed())
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
					this.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}//lecture bloquante
			
		}
		
	}

}
