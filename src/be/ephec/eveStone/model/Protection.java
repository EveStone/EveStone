package be.ephec.eveStone.model;

/**
 * Même principe que la classe serviteur a part le rajout du boolean proctection pour dire si la carte est protection ou non.
 * @author nicolas
 *
 */
public class Protection extends Serviteur {
	
	private boolean protection;
	
	public Protection(int ressource, String image, int nbVie, int nbDommage, boolean protection)
	{
		super(ressource, image, nbVie, nbDommage);
		this.protection = protection;
	}
	public Protection(int ressource, String image, int nbVie, int nbDommage, int dommageSort, boolean protection)
	{
		super(ressource, image, nbVie, nbDommage, dommageSort);
		this.protection = protection;
	}
	public Protection(int ressource, String image, int nbVie, int nbDommage, int servBuffPv, int servBuffDeg, boolean protection)
	{
		super(ressource, image, nbVie, nbDommage, servBuffPv,servBuffDeg);
		this.protection = protection;
	}
	public Protection(int ressource, String image, int nbVie, int nbDommage, int servBuffPvOuDeg, boolean check, boolean protection)
	{
		super(ressource, image, nbVie, nbDommage, servBuffPvOuDeg,check);
		this.protection = protection;
	}

	public boolean isProtection() {
		return protection;
	}

	public void setProtection(boolean protection) {
		this.protection = protection;
	}

}
