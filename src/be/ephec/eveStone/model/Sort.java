package be.ephec.eveStone.model;

import java.io.Serializable;


/**
 * The Class Sort.
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 */
public class Sort extends Carte implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8489829912432739224L;

	/**
	 * Instantiates a new sort.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 */
	public Sort(String nom,int ressource, String image, String description){
		super(nom,ressource, image, description);
	}
}
