package be.ephec.eveStone.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Buff.
 */
public class Buff extends Sort implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1766582470131004337L;
	
	/** The buff pv. */
	private int buffPv;
	
	/** The buff degats. */
	private int buffDegats;
	
	
	
	/**
	 * Constructeur avec les buff de vie et de d�gats.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 * @param buffPv the buff pv
	 * @param buffDegats the buff degats
	 */
	public Buff(String nom,int ressource, String image, String description, int buffPv, int buffDegats)
	{
		super(nom,ressource, image, description);
		this.buffPv = buffPv;
		this.buffDegats = buffDegats;
		
	}
	

	/**
	 * Gets the buff pv.
	 *
	 * @return the buff pv
	 */
	public int getBuffPv() {
		return buffPv;
	}

	/**
	 * Sets the buff pv.
	 *
	 * @param buffPv the new buff pv
	 */
	public void setBuffPv(int buffPv) {
		this.buffPv = buffPv;
	}

	/**
	 * Gets the buff degats.
	 *
	 * @return the buff degats
	 */
	public int getBuffDegats() {
		return buffDegats;
	}

	/**
	 * Sets the buff degats.
	 *
	 * @param buffDegats the new buff degats
	 */
	public void setBuffDegats(int buffDegats) {
		this.buffDegats = buffDegats;
	}
	

}
