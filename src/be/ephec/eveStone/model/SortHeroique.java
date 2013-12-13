package be.ephec.eveStone.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class SortHeroique.
 */
public class SortHeroique implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6199168053210644430L;
	
	/** The nom. */
	private String nom;
	
	/** The degats. */
	private int degats;
	
	/** The bouclier. */
	private int bouclier;
	
	/** The image. */
	private String image;
	
	/** The ressource. */
	private int ressource;
	
	/** The description. */
	private String description;
	
	/**
	 * Instantiates a new sort heroique.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param degats the degats
	 * @param bouclier the bouclier
	 * @param image the image
	 * @param description the description
	 */
	public SortHeroique(String nom, int ressource, int degats, int bouclier, String image, String description)
	{
		this.nom=nom;
		this.ressource=ressource;
		this.bouclier = bouclier;
		this.degats = degats;
		this.image = image;
		this.description=description;
	}
	
	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom(){
		return nom;
	}

	/**
	 * Gets the degats.
	 *
	 * @return the degats
	 */
	public int getDegats() {
		return degats;
	}

	/**
	 * Sets the degats.
	 *
	 * @param degats the new degats
	 */
	public void setDegats(int degats) {
		this.degats = degats;
	}

	/**
	 * Gets the bouclier.
	 *
	 * @return the bouclier
	 */
	public int getBouclier() {
		return bouclier;
	}

	/**
	 * Sets the bouclier.
	 *
	 * @param bouclier the new bouclier
	 */
	public void setBouclier(int bouclier) {
		this.bouclier = bouclier;
	}
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage(){
		return image;
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
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription(){
		return description;
	}
}
