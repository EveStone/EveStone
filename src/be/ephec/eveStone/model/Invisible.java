package be.ephec.eveStone.model;

/**
 * M�me principe que la classe serviteur a part le rajout du boolean invisible pour dire si la carte est invisible ou non.
 * @author nicolas
 *
 */
public class Invisible extends Serviteur {
	
	private boolean invisible;
	
	public Invisible(String nom,int ressource, String image, int nbVie, int nbDommage, boolean invisible)
	{
		super(nom,ressource, image, nbVie, nbDommage);
		this.invisible = invisible;
	}
	public Invisible(String nom,int ressource, String image, int nbVie, int nbDommage, int dommageSort, boolean invisible)
	{
		super(nom,ressource, image, nbVie, nbDommage, dommageSort);
		this.invisible = invisible;
	}
	public Invisible(String nom,int ressource, String image, int nbVie, int nbDommage, int servBuffPv, int servBuffDeg, boolean invisible)
	{
		super(nom,ressource, image, nbVie, nbDommage, servBuffPv,servBuffDeg);
		this.invisible = invisible;
	}

	public boolean isInvisible() {
		return invisible;
	}

	public void setInvisible(boolean invisible) {
		this.invisible = invisible;
	}

}
