package eveStone.model;

/**
 * Même principe que la classe serviteur a part le rajout du boolean invisible pour dire si la carte est invisible ou non.
 * @author nicolas
 *
 */
public class Invisible extends Serviteur {
	
	private boolean invisible;
	
	public Invisible(int ressource, String image, int nbVie, int nbDommage, boolean invisible)
	{
		super(ressource, image, nbVie, nbDommage);
		this.invisible = invisible;
	}
	public Invisible(int ressource, String image, int nbVie, int nbDommage, int dommageSort, boolean invisible)
	{
		super(ressource, image, nbVie, nbDommage, dommageSort);
		this.invisible = invisible;
	}
	public Invisible(int ressource, String image, int nbVie, int nbDommage, int servBuffPv, int servBuffDeg, boolean invisible)
	{
		super(ressource, image, nbVie, nbDommage, servBuffPv,servBuffDeg);
		this.invisible = invisible;
	}
	public Invisible(int ressource, String image, int nbVie, int nbDommage, int servBuffPvOuDeg, boolean check, boolean invisible)
	{
		super(ressource, image, nbVie, nbDommage, servBuffPvOuDeg,check);
		this.invisible = invisible;
	}

	public boolean isInvisible() {
		return invisible;
	}

	public void setInvisible(boolean invisible) {
		this.invisible = invisible;
	}

}
