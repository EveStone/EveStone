package be.ephec.eveStone.model;

import java.io.Serializable;

/**
 * M�me principe que la classe serviteur a part le rajout du boolean invisible pour dire si la carte est invisible ou non.
 * @author nicolas
 *
 */
public class Invisible extends Serviteur implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6826062827631564174L;
	private boolean invisible;
	
	public Invisible(String nom,int ressource, String image, String description, int nbVie, int nbDommage, boolean invisible)
	{
		super(nom,ressource, image, description, nbVie, nbDommage);
		this.invisible = invisible;
	}
	public Invisible(String nom,int ressource, String image, String description, int nbVie, int nbDommage, int dommageSort, boolean invisible)
	{
		super(nom,ressource, image, description, nbVie, nbDommage, dommageSort);
		this.invisible = invisible;
	}
	public Invisible(String nom,int ressource, String image, String description, int nbVie, int nbDommage, int servBuffPv, int servBuffDeg, boolean invisible)
	{
		super(nom,ressource, image, description, nbVie, nbDommage, servBuffPv,servBuffDeg);
		this.invisible = invisible;
	}

	public boolean isInvisible() {
		return invisible;
	}

	public void setInvisible(boolean invisible) {
		this.invisible = invisible;
	}

}
