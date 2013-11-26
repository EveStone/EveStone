package be.ephec.eveStone.model;

public class Carte {
	
	private int ressource;
	private String image; //chemin d'accès de l'image de la carte
	private String nom;
	
	
	public Carte( String nom,int ressource, String image)
	{
		this.ressource = ressource;
		this.image = image;
		this.nom = nom;
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
	


}
