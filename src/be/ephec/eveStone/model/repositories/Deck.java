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
	public LinkedList<Carte> makeListInterceptor()
	{
		LinkedList<Carte> tmp = null;
		tmp.add(new Serviteur("Drones d'attaque", 2, "", 2, 2));
		tmp.add(new Serviteur("Drones de combat Elite", 5, "", 3, 5));
		tmp.add(new Dommage("Interception rapide", 5, "", "Attaque directement un serviteur ou un H�ro", 4));
		tmp.add(new Dommage("Interception rapide", 5, "", "Attaque directement un serviteur ou un H�ro", 4));
		tmp.add(new Serviteur("Drone de soutien",2, "", 2, 2, 1, 1));
		tmp.add(new Serviteur("Drone de soutien",2, "", 2, 2, 1, 1));
		return tmp;
	}
	public LinkedList<Carte> makeListFregate()
	{
		LinkedList<Carte> tmp = null;
		tmp.add(new Serviteur("Drones d'attaque", 2, "", 2, 2));
		tmp.add(new Serviteur("Drones de combat Elite", 5, "", 3, 5));
		tmp.add(new Serviteur("Drone de soutien",2, "", 2, 2, 1, 1));
		tmp.add(new Serviteur("Drone de soutien",2, "", 2, 2, 1, 1));
		tmp.add(new Buff("Bouclier augment�",2, "", "Augmente de 2 la vie d'un serviteur", 2, false));
		tmp.add(new Buff("Bouclier augment�",2, "", "Augmente de 2 la vie d'un serviteur", 2, false));
		return tmp;
	}
	

}
