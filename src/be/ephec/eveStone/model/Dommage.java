package be.ephec.eveStone.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Dommage.
 */
public class Dommage extends Sort implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3634239282069928393L;
	
	/** The degats. */
	private int degats;
	
	/**
	 * Instantiates a new dommage.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 * @param degats the degats
	 */
	public Dommage(String nom,int ressource, String image, String description, int degats)
	{
		super(nom,ressource, image, description);
		this.degats = degats;
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
	
	

}
