package be.ephec.eveStone.model;

public class Buff extends Sort {
	
	private int buffPv;
	private int buffDegats;
	
	
	
	/**
	 * 
	 *Constructeur avec les buff de vie et de dégats
	 * @param ressource
	 * @param image
	 * @param description
	 * @param buffPv
	 * @param buffDegats
	 */
	public Buff(int ressource, String image, String description, int buffPv, int buffDegats)
	{
		super(ressource, image, description);
		this.buffPv = buffPv;
		this.buffDegats = buffDegats;
		
	}
	
	
	/**
	 * Constructeur avec un parametre soit pour buffer les pv ou les dégats selon le check (boolean)
	 * vrai ==> degats
	 * faux ==> pv
	 * @param ressource
	 * @param image
	 * @param description
	 * @param buffDegatsOuPv
	 * @param check
	 */
	public Buff(int ressource, String image, String description, int buffDegatsOuPv, boolean check )
	{
		super(ressource, image, description);
		if (check == true) this.buffDegats = buffDegatsOuPv;
		else this.buffPv = buffDegatsOuPv;
		
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
