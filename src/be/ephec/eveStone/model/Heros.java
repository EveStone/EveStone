package be.ephec.eveStone.model;

import java.io.Serializable;

import be.ephec.eveStone.model.repositories.Deck;

// TODO: Auto-generated Javadoc
/**
 * The Class Heros.
 */
public class Heros implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7413118141276505328L;
	
	/** The nom. */
	private String nom;
	
	/** The image. */
	private String image;
	
	/** The nb structure. */
	private int nbStructure;
	
	/** The nb coque. */
	private int nbCoque;
	
	/** The deck. */
	private Deck deck;
	
	/** The sort hero. */
	private SortHeroique sortHero;
	
	/** The ressource. */
	private int ressource;

	/**
	 * Instantiates a new heros.
	 *
	 * @param nom the nom
	 * @param image the image
	 * @param deck the deck
	 * @param sortHero the sort hero
	 */
	public Heros(String nom,String image, Deck deck, SortHeroique sortHero)
	{
		this.nom = nom;
		this.image = image;
		this.nbCoque = 20;
		this.nbStructure = 10;
		this.deck = deck;
		this.sortHero = sortHero;
		ressource = 1;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Gets the nb structure.
	 *
	 * @return the nb structure
	 */
	public int getNbStructure() {
		return nbStructure;
	}

	/**
	 * Sets the nb structure.
	 *
	 * @param nbStructure the new nb structure
	 */
	public void setNbStructure(int nbStructure) {
		this.nbStructure = nbStructure;
	}

	/**
	 * Gets the nb coque.
	 *
	 * @return the nb coque
	 */
	public int getNbCoque() {
		return nbCoque;
	}

	/**
	 * Sets the nb coque.
	 *
	 * @param nbCoque the new nb coque
	 */
	public void setNbCoque(int nbCoque) {
		this.nbCoque = nbCoque;
	}

	/**
	 * Gets the deck.
	 *
	 * @return the deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * Sets the deck.
	 *
	 * @param deck the new deck
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	/**
	 * Gets the sort hero.
	 *
	 * @return the sort hero
	 */
	public SortHeroique getSortHero() {
		return sortHero;
	}

	/**
	 * Sets the sort hero.
	 *
	 * @param sortHero the new sort hero
	 */
	public void setSortHero(SortHeroique sortHero) {
		this.sortHero = sortHero;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Gets the ressource.
	 *
	 * @return the ressource
	 */
	public int getRessource(){
		return ressource;
	}
	
	/**
	 * Sets the ressource.
	 *
	 * @param ressource the new ressource
	 */
	public void setRessource(int ressource){
		this.ressource = ressource;
	}
}
