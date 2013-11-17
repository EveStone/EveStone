package eveStone.model;

public class Hero {
	
	private int nbStructure;
	private int nbCoque;
	private Deck deck;
	private SortHeroique sortHero;

	public Hero(Deck deck, SortHeroique sortHero)
	{
		this.nbCoque = 20;
		this.nbStructure = 10;
		this.deck = deck;
		this.sortHero = sortHero;
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
