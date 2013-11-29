package be.ephec.eveStone.model.repositories;

import java.util.LinkedList;

import be.ephec.eveStone.model.*;




public class Deck {
	
	private LinkedList<Carte> listCartes;
	private String nom;
	
	public Deck(String nom)
	{
		if (nom.compareTo("interceptor") == 0)
		{
			this.nom = nom;
			this.listCartes = makeListInterceptor();
		}
		else
		{ 
			if (nom.compareTo("fregate") == 0)
			{
				this.nom = nom;
				this.listCartes = makeListFregate();
				
			}
			else
			{
				System.out.println("ERROR: nom non valide");
			}
		}
		
	}

	public LinkedList<Carte> getTabCartes() {
		return listCartes;
	}

	public void setTabCartes(LinkedList<Carte> listCartes) {
		this.listCartes = listCartes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	private LinkedList<Carte> makeListInterceptor()
	{
		LinkedList<Carte> tmp = new LinkedList<Carte>();
		tmp.add(new Serviteur("Drones d'attaque", 2, "", 2, 2));
		tmp.add(new Serviteur("Drones d'attaque", 2, "", 2, 2));
		tmp.add(new Serviteur("Drones de combat Elite", 5, "", 3, 5));
		tmp.add(new Serviteur("Drones de combat Elite", 5, "", 3, 5));
		tmp.add(new Serviteur("Drones d'attaque", 2, "", 2, 2));
		tmp.add(new Serviteur("Drones d'attaque", 2, "", 2, 2));
		tmp.add(new Serviteur("Drones de combat Elite", 5, "", 3, 5));
		tmp.add(new Serviteur("Drones de combat Elite", 5, "", 3, 5));
		tmp.add(new Dommage("Interception rapide", 5, "", "Attaque directement un serviteur ou un Hï¿½ro", 4));
		tmp.add(new Dommage("Interception rapide", 5, "", "Attaque directement un serviteur ou un Hï¿½ro", 4));
		tmp.add(new Serviteur("Drone de soutien",2, "", 2, 2, 1, 1));
		tmp.add(new Serviteur("Drone de soutien",2, "", 2, 2, 1, 1));
		tmp.add(new Protection("Drone tank et de soutien",6, "", 5, 6, 1, 1, true));
		tmp.add(new Protection("Drone tank et de soutien",6, "", 5, 6, 1, 1, true));
		tmp.add(new Invisible("Drone invisible",4, "", 4, 4, 2, true));
		tmp.add(new Invisible("Drone invisible",4, "", 4, 4, 2, true));
		tmp.add(new Buff("Bouclier augmentï¿½",2, "", "Augmente de 2 la vie d'un serviteur", 2, false));
		tmp.add(new Buff("Bouclier augmentï¿½",2, "", "Augmente de 2 la vie d'un serviteur", 2, false));
		tmp.add(new Serviteur("Drone lieutenant élite de combat",8, "", 6, 8, 2, 2));
		tmp.add(new Serviteur("Drone lieutenant élite de combat",8, "", 6, 8, 2, 2));
		tmp.add(new Serviteur("Drone de combat", 3,"", 3,3));
		tmp.add(new Serviteur("Drone de combat", 3,"", 3,3));
		tmp.add(new Buff("Egide des anciens",4, "", "Augmente de 4 les Pv et de 4 les dégats d'un serviteur", 4, 4));
		tmp.add(new Buff("Egide des anciens",4, "", "Augmente de 4 les Pv et de 4 les dégats d'un serviteur", 4, 4));
		tmp.add(new Protection("Drone tank",2, "", 2, 2, true));
		tmp.add(new Protection("Drone tank",2, "", 2, 2, true));
		tmp.add(new Serviteur("Drone docteur",1, "", 1, 1, 1, false));
		tmp.add(new Serviteur("Drone docteur",1, "", 1, 1, 1, false));
		tmp.add(new Serviteur("Drone docteur",1, "", 1, 1, 1, false));
		tmp.add(new Serviteur("Drone docteur",1, "", 1, 1, 1, false));
		return tmp;
	}
	private LinkedList<Carte> makeListFregate()
	{
		LinkedList<Carte> tmp = new LinkedList<Carte>();
		tmp.add(new Serviteur("Drones d'attaque", 2, "", 2, 2));
		tmp.add(new Serviteur("Drones d'attaque", 2, "", 2, 2));
		tmp.add(new Serviteur("Drones de combat Elite", 5, "", 3, 5));
		tmp.add(new Serviteur("Drones de combat Elite", 5, "", 3, 5));
		tmp.add(new Serviteur("Drones d'attaque", 2, "", 2, 2));
		tmp.add(new Serviteur("Drones d'attaque", 2, "", 2, 2));
		tmp.add(new Serviteur("Drones de combat Elite", 5, "", 3, 5));
		tmp.add(new Serviteur("Drones de combat Elite", 5, "", 3, 5));
		tmp.add(new Serviteur("Drone de soutien",2, "", 2, 2, 1, 1));
		tmp.add(new Serviteur("Drone de soutien",2, "", 2, 2, 1, 1));
		tmp.add(new Buff("Bouclier augmentï¿½",2, "", "Augmente de 2 la vie d'un serviteur", 2, false));
		tmp.add(new Buff("Bouclier augmentï¿½",2, "", "Augmente de 2 la vie d'un serviteur", 2, false));
		tmp.add(new Protection("Drone tank et de soutien",6, "", 5, 6, 1, 1, true));
		tmp.add(new Protection("Drone tank et de soutien",6, "", 5, 6, 1, 1, true));
		tmp.add(new Invisible("Drone invisible",4, "", 4, 4, 2, true));
		tmp.add(new Invisible("Drone invisible",4, "", 4, 4, 2, true));
		tmp.add(new Dommage("Attaque des tourelles", 2, "", "Attaque directement un serviteur ou un Hï¿½ro", 2));
		tmp.add(new Dommage("Attaque des tourelles", 2, "", "Attaque directement un serviteur ou un Hï¿½ro", 2));
		tmp.add(new Serviteur("Drone lieutenant élite de combat",8, "", 6, 8, 2, 2));
		tmp.add(new Serviteur("Drone lieutenant élite de combat",8, "", 6, 8, 2, 2));
		tmp.add(new Serviteur("Drone de combat", 3,"", 3,3));
		tmp.add(new Serviteur("Drone de combat", 3,"", 3,3));
		tmp.add(new Buff("Egide des anciens",4, "", "Augmente de 4 les Pv et de 4 les dégats d'un serviteur", 4, 4));
		tmp.add(new Buff("Egide des anciens",4, "", "Augmente de 4 les Pv et de 4 les dégats d'un serviteur", 4, 4));
		tmp.add(new Protection("Drone tank",2, "", 2, 2, true));
		tmp.add(new Protection("Drone tank",2, "", 2, 2, true));
		tmp.add(new Serviteur("Drone docteur",1, "", 1, 1, 1, false));
		tmp.add(new Serviteur("Drone docteur",1, "", 1, 1, 1, false));
		tmp.add(new Serviteur("Drone docteur",1, "", 1, 1, 1, false));
		tmp.add(new Serviteur("Drone docteur",1, "", 1, 1, 1, false));
		return tmp;
	}
	

}
