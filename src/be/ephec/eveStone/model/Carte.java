package be.ephec.eveStone.model;

public class Carte {
	
	private int ressource;
	private String image; //chemin d'acc�s de l'image de la carte
	private String nom;
	private String description;
	
	
	public Carte( String nom,int ressource, String image, String description)
	{
		this.ressource = ressource;
		this.image = image;
		this.nom = nom;
		this.description = description;
	}
	public int getRessource() {
		return ressource;
	}

	public void setRessource(int ressource) {
		this.ressource = ressource;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription(){
		return description;
	}

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
