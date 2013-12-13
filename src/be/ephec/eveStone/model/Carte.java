package be.ephec.eveStone.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Carte.
 */
public class Carte implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2278480827902288826L;
	
	/** The ressource. */
	private int ressource;
	
	/** The image. */
	private String image; //chemin d'acc�s de l'image de la carte
	
	/** The nom. */
	private String nom;
	
	/** The description. */
	private String description;
	
	
	/**
	 * Instantiates a new carte.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 */
	public Carte( String nom,int ressource, String image, String description)
	{
		this.ressource = ressource;
		this.image = image;
		this.nom = nom;
		this.description = description;
	}
	
	/**
	 * Gets the ressource.
	 *
	 * @return the ressource
	 */
	public int getRessource() {
		return ressource;
	}

	/**
	 * Sets the ressource.
	 *
	 * @param ressource the new ressource
	 */
	public void setRessource(int ressource) {
		this.ressource = ressource;
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
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription(){
		return description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		if (this instanceof Serviteur)
			return "Serviteur";
		else
			if (this instanceof Dommage)
				return "Dommage";
			else
				return "Buff";
	}
}
