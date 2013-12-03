package be.ephec.eveStone.model;

public class Buff extends Sort {
	
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
