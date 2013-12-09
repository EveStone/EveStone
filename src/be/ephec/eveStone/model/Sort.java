package be.ephec.eveStone.model;

import java.io.Serializable;

public class Sort extends Carte implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8489829912432739224L;

	public Sort(String nom,int ressource, String image, String description){
		super(nom,ressource, image, description);
	}
}
