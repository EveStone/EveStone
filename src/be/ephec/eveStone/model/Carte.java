package be.ephec.eveStone.model;

import java.io.Serializable;

/**
 * La Classe Carte.
 */
public class Carte implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2278480827902288826L;
	
	/** les ressources. */
	private int ressource;
	
	/** l'image. */
	private String image; //chemin d'acc�s de l'image de la carte
	
	/** le nom. */
	private String nom;
	
	/** la description. */
	private String description;
	
	
	/**
	 * Constructeur de la classe carte.
	 *
	 * @param nom : String
	 * @param ressource : int
	 * @param image : String
	 * @param description : String
	 */
	public Carte( String nom,int ressource, String image, String description)
	{
		this.ressource = ressource;
		this.image = image;
		this.nom = nom;
		this.description = description;
	}
	
	/**
	 * rtourne les ressources.
	 *
	 * @return ressource
	 */
	public int getRessource() {
		return ressource;
	}

	/**
	 * Sets les ressources.
	 *
	 * @param ressource les nouvelles ressource
	 */
	public void setRessource(int ressource) {
		this.ressource = ressource;
	}
	
	/**
	 * Retourne l'image.
	 *
	 * @return l'image
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * Sets l'image.
	 *
	 * @param image la nouvelle image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * Retourne le nom.
	 *
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Sets le nom.
	 *
	 * @param nom le nouveau nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * retourne la description.
	 *
	 * @return la description
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
