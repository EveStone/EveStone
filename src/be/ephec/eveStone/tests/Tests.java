package be.ephec.eveStone.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Carte;
import be.ephec.eveStone.model.Dommage;
import be.ephec.eveStone.model.Invisible;
import be.ephec.eveStone.model.Protection;
import be.ephec.eveStone.model.Serviteur;
import be.ephec.eveStone.model.net.client.MyClient;
import be.ephec.eveStone.model.net.server.MyServer;
import be.ephec.eveStone.model.repositories.Deck;


/**
 * The Class Tests.
 * @author Dasseler Nicolas & Vanbutsele Andy
 */
public class Tests {

	/** The controller. */
	Controller controller = new Controller();
	private MyClient myClient;
	
	/**
	 * Test get dommage.
	 */
	@Test
	public void  testGetDommage(){
		//test de getDommage et check si elle va bien chercher les degats de tout les type de carte
		assertEquals(2, controller.getDommage(new Serviteur("",2,"","",2,2)));
		assertEquals(4, controller.getDommage(new Invisible("",2,"","",5,4,true)));
		assertEquals(6, controller.getDommage(new Protection("",6,"","",2,6,true)));
		assertEquals(5, controller.getDommage(new Dommage("",5,"","",5)));
		
	}
	@Test
	public void  testMakeDeck(){
		//test de la création de Deck
		Deck fregate = new Deck("fregate");
		String nom = "fregate";
		assertTrue(nom.equals(fregate.getNom()));
		LinkedList<Carte> tabCarte = fregate.getTabCartes();
		assertEquals(30, tabCarte.size());
		assert(tabCarte.contains(new Serviteur("Light Maintenance",1, "img/CommonCard/lightMaintenance.png", "Augmente les points de vie d'un serviteur engagé sur le terrain de 1", 1, 1, 1, 0))==true);
	}
	
	@Test
	public void testSocket()
	{
		//permet de tester la liaison serveur <=> client
		try {
			MyServer serv = new MyServer(controller);
			myClient = new MyClient("127.0.0.1", serv.getNumPort());
			myClient.getOos().writeObject("Test");
			assertTrue(("Test").equals((String)controller.getMyClientServer().getOis().readObject()));
		} catch (InterruptedException | IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
