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
	
	private ObjectOutputStream oos; //on inverse sinon il ecoute tout les deux en meme temps;
	private ObjectInputStream ois;
	private int num;
	

	public MyClient() throws UnknownHostException, IOException {
		super("127.0.0.1",2013);
		oos = new ObjectOutputStream(this.getOutputStream());
		ois = new ObjectInputStream(this.getInputStream());
	}


	public MyClient(String host, int port) throws UnknownHostException,
			IOException {
		super(host, port);
		oos = new ObjectOutputStream(this.getOutputStream());
		ois = new ObjectInputStream(this.getInputStream());
	}


	public static void main(String[] args) {
		MyClient mc = null;
		try {
			mc = new MyClient();
			String s = (String)mc.ois.readObject();
			System.out.println("Le client a re�u: " + s);
			
			mc.num = (int)mc.ois.readObject();
			System.out.println("Ceci est la console du num�ro " + mc.num);
			
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
				System.out.println("Le socket est ferm�");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public void run() {
		while (!this.isClosed())
		{
			String s = null;
			try {
				s = (String) this.ois.readObject();
				System.out.println("J'ai recu: " + s);
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
