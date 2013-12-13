package be.ephec.eveStone.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * M�me principe que la classe serviteur a part le rajout du boolean proctection pour dire si la carte est protection ou non.
 * @author nicolas
 *
 */
public class Protection extends Serviteur implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7333398283518708890L;
	
	/** The protection. */
	private boolean protection;
	
	/**
	 * Instantiates a new protection.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 * @param nbVie the nb vie
	 * @param nbDommage the nb dommage
	 * @param protection the protection
	 */
	public Protection(String nom,int ressource, String image, String description, int nbVie, int nbDommage, boolean protection)
	{
		super(nom,ressource, image, description, nbVie, nbDommage);
		this.protection = protection;
	}
	
	/**
	 * Instantiates a new protection.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 * @param nbVie the nb vie
	 * @param nbDommage the nb dommage
	 * @param dommageSort the dommage sort
	 * @param protection the protection
	 */
	public Protection(String nom,int ressource, String image, String description, int nbVie, int nbDommage, int dommageSort, boolean protection)
	{
		super(nom,ressource, image, description, nbVie, nbDommage, dommageSort);
		this.protection = protection;
	}
	
	/**
	 * Instantiates a new protection.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 * @param nbVie the nb vie
	 * @param nbDommage the nb dommage
	 * @param servBuffPv the serv buff pv
	 * @param servBuffDeg the serv buff deg
	 * @param protection the protection
	 */
	public Protection(String nom,int ressource, String image, String description, int nbVie, int nbDommage, int servBuffPv, int servBuffDeg, boolean protection)
	{
		super(nom,ressource, image, description, nbVie, nbDommage, servBuffPv,servBuffDeg);
		this.protection = protection;
	}

	/**
	 * Checks if is protection.
	 *
	 * @return true, if is protection
	 */
	public boolean isProtection() {
		return protection;
	}

	/**
	 * Sets the protection.
	 *
	 * @param protection the new protection
	 */
	public void setProtection(boolean protection) {
		this.protection = protection;
	}

}
