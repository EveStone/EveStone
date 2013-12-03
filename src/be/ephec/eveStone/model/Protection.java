package be.ephec.eveStone.model;

/**
 * M�me principe que la classe serviteur a part le rajout du boolean proctection pour dire si la carte est protection ou non.
 * @author nicolas
 *
 */
public class Protection extends Serviteur {
	
	private boolean protection;
	
	public Protection(String nom,int ressource, String image, int nbVie, int nbDommage, boolean protection)
	{
		super(nom,ressource, image, nbVie, nbDommage);
		this.protection = protection;
	}
	public Protection(String nom,int ressource, String image, int nbVie, int nbDommage, int dommageSort, boolean protection)
	{
		super(nom,ressource, image, nbVie, nbDommage, dommageSort);
		this.protection = protection;
	}
	public Protection(String nom,int ressource, String image, int nbVie, int nbDommage, int servBuffPv, int servBuffDeg, boolean protection)
	{
		super(nom,ressource, image, nbVie, nbDommage, servBuffPv,servBuffDeg);
		this.protection = protection;
	}

	public boolean isProtection() {
		return protection;
	}

	public void setProtection(boolean protection) {
		this.protection = protection;
	}

}
