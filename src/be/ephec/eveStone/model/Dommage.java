package be.ephec.eveStone.model;

import java.io.Serializable;

public class Dommage extends Sort implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3634239282069928393L;
	private int degats;
	
	public Dommage(String nom,int ressource, String image, String description, int degats)
	{
		super(nom,ressource, image, description);
		this.degats = degats;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}
	
	

}
