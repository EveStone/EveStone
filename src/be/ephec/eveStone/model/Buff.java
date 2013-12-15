package be.ephec.eveStone.model;

import java.io.Serializable;

/**
 * la Classe Buff.
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 */
public class Buff extends Sort implements Serializable{
	
	/** la Constante serialVersionUID. */
	private static final long serialVersionUID = -1766582470131004337L;
	
	/** le buff pv. */
	private int buffPv;
	
	/** le beug degats. */
	private int buffDegats;
	
	
	
	/**
	 * Constructeur avec les buff de vie et de d�gats.
	 *
	 * @param nom : String 
	 * @param ressource : int
	 * @param image : String
	 * @param description : String
	 * @param buffPv : int
	 * @param buffDegats : int
	 */
	public Buff(String nom,int ressource, String image, String description, int buffPv, int buffDegats)
	{
		super(nom,ressource, image, description);
		this.buffPv = buffPv;
		this.buffDegats = buffDegats;
		
	}
	

	/**
	 *Retourne le buiff pv
	 *
	 * @return buff pv : int
	 */
	public int getBuffPv() {
		return buffPv;
	}

	/**
	 * Sets le buff pv
	 *
	 * @param buffPv : int
	 */
	public void setBuffPv(int buffPv) {
		this.buffPv = buffPv;
	}

	/**
	 * Retourne le buff degats.
	 *
	 * @return the buff degats
	 */
	public int getBuffDegats() {
		return buffDegats;
	}

	/**
	 * Sets le buff degats.
	 *
	 * @param buffDegats the new buff degats
	 */
	public void setBuffDegats(int buffDegats) {
		this.buffDegats = buffDegats;
	}
	

}
