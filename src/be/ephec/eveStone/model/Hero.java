package be.ephec.eveStone.model;

import be.ephec.eveStone.model.repositories.Deck;

public class Hero {
	
	private String nom;
	private String image;
	private int nbStructure;
	private int nbCoque;
	private Deck deck;
	private SortHeroique sortHero;
	private int ressource;

	public Hero(String nom,String image, Deck deck, SortHeroique sortHero)
	{
		this.nom = nom;
		this.image = image;
		this.nbCoque = 20;
		this.nbStructure = 10;
		this.deck = deck;
		this.sortHero = sortHero;
		ressource = 1;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNbStructure() {
		return nbStructure;
	}

	public void setNbStructure(int nbStructure) {
		this.nbStructure = nbStructure;
	}

	public int getNbCoque() {
		return nbCoque;
	}

	public void setNbCoque(int nbCoque) {
		this.nbCoque = nbCoque;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public SortHeroique getSortHero() {
		return sortHero;
	}

	public void setSortHero(SortHeroique sortHero) {
		this.sortHero = sortHero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getRessource(){
		return ressource;
	}
	
	public void setRessource(int ressource){
		this.ressource = ressource;
	}
}
