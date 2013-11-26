package be.ephec.eveStone.model;

import be.ephec.eveStone.model.repositories.Deck;

public class Hero {
	
	private String image;
	private int nbStructure;
	private int nbCoque;
	private Deck deck;
	private SortHeroique sortHero;

	public Hero(String image, Deck deck, SortHeroique sortHero)
	{
		this.image = image;
		this.nbCoque = 20;
		this.nbStructure = 10;
		this.deck = deck;
		this.sortHero = sortHero;
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
	
	


	

}
