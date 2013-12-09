package be.ephec.eveStone.model;

import java.io.Serializable;

public class Buff extends Sort implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1766582470131004337L;
	private int buffPv;
	private int buffDegats;
	
	
	
	/**
	 * 
	 *Constructeur avec les buff de vie et de d�gats
	 * @param ressource
	 * @param image
	 * @param description
	 * @param buffPv
	 * @param buffDegats
	 */
	public Buff(String nom,int ressource, String image, String description, int buffPv, int buffDegats)
	{
		super(nom,ressource, image, description);
		this.buffPv = buffPv;
		this.buffDegats = buffDegats;
		
	}
	

	public int getBuffPv() {
		return buffPv;
	}

	public void setBuffPv(int buffPv) {
		this.buffPv = buffPv;
	}

	public int getBuffDegats() {
		return buffDegats;
	}

	public void setBuffDegats(int buffDegats) {
		this.buffDegats = buffDegats;
	}
	

}
