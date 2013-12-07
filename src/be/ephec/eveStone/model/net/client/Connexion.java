package be.ephec.eveStone.model.net.client;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Connexion implements Runnable {

	private Socket socket = null;
	public static Thread t2;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private boolean connect = false;

	public Connexion(Socket s){

		socket = s;
	}

	public void run() {

		try {

			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	


			while(!connect )
			{
				if(in.readLine().equals("connecte")){
					System.out.println("Je suis connecté "); 
					connect = true;
				}
				else 
				{
					System.err.println("Erreur de connection"); 
				}
			}
			t2 = new Thread(new Send_Client(socket));
			t2.start();

		} catch (IOException e) {

			System.err.println("Le serveur ne r�pond plus ");
		}
	}

}