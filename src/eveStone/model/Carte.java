package eveStone.model;

public class Carte {
	
	private int ressource;
	private String image; //chemin d'accès de l'image de la carte
	
	
	public Carte(int ressource, String image)
	{
		this.ressource = ressource;
		this.image = image;
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
	


}
