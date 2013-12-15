package be.ephec.eveStone.model;

import java.io.Serializable;


/**
 * M�me principe que la classe serviteur a part le rajout du boolean invisible pour dire si la carte est invisible ou non.
 * @author Dasseler Nicolas & Vanbutsele Andy
 *
 */
public class Invisible extends Serviteur implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6826062827631564174L;
	
	/** The invisible. */
	private boolean invisible;
	
	/**
	 * Instantiates a new invisible.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 * @param nbVie the nb vie
	 * @param nbDommage the nb dommage
	 * @param invisible the invisible
	 */
	public Invisible(String nom,int ressource, String image, String description, int nbVie, int nbDommage, boolean invisible)
	{
		super(nom,ressource, image, description, nbVie, nbDommage);
		this.invisible = invisible;
	}
	
	/**
	 * Instantiates a new invisible.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 * @param nbVie the nb vie
	 * @param nbDommage the nb dommage
	 * @param dommageSort the dommage sort
	 * @param invisible the invisible
	 */
	public Invisible(String nom,int ressource, String image, String description, int nbVie, int nbDommage, int dommageSort, boolean invisible)
	{
		super(nom,ressource, image, description, nbVie, nbDommage, dommageSort);
		this.invisible = invisible;
	}
	
	/**
	 * Instantiates a new invisible.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 * @param nbVie the nb vie
	 * @param nbDommage the nb dommage
	 * @param servBuffPv the serv buff pv
	 * @param servBuffDeg the serv buff deg
	 * @param invisible the invisible
	 */
	public Invisible(String nom,int ressource, String image, String description, int nbVie, int nbDommage, int servBuffPv, int servBuffDeg, boolean invisible)
	{
		super(nom,ressource, image, description, nbVie, nbDommage, servBuffPv,servBuffDeg);
		this.invisible = invisible;
	}

	/**
	 * Checks if is invisible.
	 *
	 * @return true, if is invisible
	 */
	public boolean isInvisible() {
		return invisible;
	}

	/**
	 * Sets the invisible.
	 *
	 * @param invisible the new invisible
	 */
	public void setInvisible(boolean invisible) {
		this.invisible = invisible;
	}

}
