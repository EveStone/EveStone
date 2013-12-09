package be.ephec.eveStone.model;

import java.io.Serializable;

public class SortHeroique implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6199168053210644430L;
	private String nom;
	private int degats;
	private int bouclier;
	private String image;
	private int ressource;
	private String description;
	
	public SortHeroique(String nom, int ressource, int degats, int bouclier, String image, String description)
	{
		this.nom=nom;
		this.ressource=ressource;
		this.bouclier = bouclier;
		this.degats = degats;
		this.image = image;
		this.description=description;
	}
	
	public String getNom(){
		return nom;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	public int getBouclier() {
		return bouclier;
	}

	public void setBouclier(int bouclier) {
		this.bouclier = bouclier;
	}
	
	public String getImage(){
		return image;
	}
	
	public int getRessource(){
		return ressource;
	}
	
	public String getDescription(){
		return description;
	}
}
