package be.ephec.eveStone.model.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer extends ServerSocket {

	private static int numPort=2013;
	private ArrayList<MySocketSideServer> listeClient = new ArrayList<MySocketSideServer>();

	public MyServer() throws IOException {
		super(numPort);

	}
	public static void main(String[] args) {
		do {
			try {
				MyServer ms = new MyServer();
				System.out.println("Le serveur tourne sur le port: " + numPort);
				do{
					Socket s = ms.accept();
					ms.listeClient.add(new MySocketSideServer(s,ms.listeClient.size() +1));
					ms.listeClient.get(ms.listeClient.size()-1).getOos().writeObject("Connection établie..........");
					ms.listeClient.get(ms.listeClient.size()-1).getOos().writeObject(ms.listeClient.size());
					for (MySocketSideServer mscs : ms.listeClient) 
					{
						mscs.getOos().writeObject("Bienvenue sur EveStone (nom = " + ms.listeClient.size()+") sur le serveur");
					}
				}while(!ms.isClosed());



			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				numPort++;
			}
			break;
		}while (true);

	}

}
