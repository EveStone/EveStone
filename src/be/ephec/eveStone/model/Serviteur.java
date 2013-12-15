package be.ephec.eveStone.model;

import java.io.Serializable;


/**
 * The Class Serviteur.
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 */
public class Serviteur extends Carte implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8584328020461044873L;
	
	/** The nb vie. */
	private int nbVie;
	
	/** The nb dommage. */
	private int nbDommage;
	
	/** The dommage sort. */
	private int dommageSort;
	
	/** The serv buff pv. */
	private int servBuffPv;
	
	/** The serv buff deg. */
	private int servBuffDeg;
	
	/** The can buff. */
	private boolean canBuff;
	
	
	/**
	 * Constructeur d'un serviteur classique.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 * @param nbVie the nb vie
	 * @param nbDommage the nb dommage
	 */
	public Serviteur(String nom, int ressource, String image, String description, int nbVie, int nbDommage)
	{
		super(nom,ressource,image, description);
		this.nbVie = nbVie;
		this.nbDommage = nbDommage;
		this.canBuff=false;
	}
	
	/**
	 * Constructeur d'un serviteur qui fait des dommages d�s qu'il est pos�.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 * @param nbVie the nb vie
	 * @param nbDommage the nb dommage
	 * @param dommageSort the dommage sort
	 */
	public Serviteur(String nom, int ressource, String image, String description, int nbVie, int nbDommage, int dommageSort)
	{
		super(nom,ressource,image, description);
		this.nbVie = nbVie;
		this.nbDommage = nbDommage;
		this.dommageSort = dommageSort;
		this.canBuff=false;
	}
	
	/**
	 * Constructeur d'un serviteur qui buff un autre serviteur d'un nombre de pv et de d�gats.
	 *
	 * @param nom the nom
	 * @param ressource the ressource
	 * @param image the image
	 * @param description the description
	 * @param nbVie the nb vie
	 * @param nbDommage the nb dommage
	 * @param servBuffPv the serv buff pv
	 * @param servBuffDeg the serv buff deg
	 */
	public Serviteur(String nom,int ressource, String image, String description, int nbVie, int nbDommage, int servBuffPv, int servBuffDeg)
	{
		super(nom,ressource,image, description);
		this.nbVie = nbVie;
		this.nbDommage = nbDommage;
		this.servBuffDeg = servBuffDeg;
		this.servBuffPv = servBuffPv;	
		this.canBuff=true;
	}
	
	/**
	 * Gets the nb vie.
	 *
	 * @return the nb vie
	 */
	public int getNbVie() {
		return nbVie;
	}


	/**
	 * Sets the nb vie.
	 *
	 * @param nbVie the new nb vie
	 */
	public void setNbVie(int nbVie) {
		this.nbVie = nbVie;
	}


	/**
	 * Gets the nb dommage.
	 *
	 * @return the nb dommage
	 */
	public int getNbDommage() {
		return nbDommage;
	}


	/**
	 * Sets the nb dommage.
	 *
	 * @param nbDommage the new nb dommage
	 */
	public void setNbDommage(int nbDommage) {
		this.nbDommage = nbDommage;
	}

	/**
	 * Gets the dommage sort.
	 *
	 * @return the dommage sort
	 */
	public int getDommageSort() {
		return dommageSort;
	}

	/**
	 * Sets the dommage sort.
	 *
	 * @param dommageSort the new dommage sort
	 */
	public void setDommageSort(int dommageSort) {
		this.dommageSort = dommageSort;
	}

	/**
	 * Gets the serv buff pv.
	 *
	 * @return the serv buff pv
	 */
	public int getServBuffPv() {
		return servBuffPv;
	}

	/**
	 * Sets the serv buff pv.
	 *
	 * @param servBuffPv the new serv buff pv
	 */
	public void setServBuffPv(int servBuffPv) {
		this.servBuffPv = servBuffPv;
	}

	/**
	 * Gets the serv buff deg.
	 *
	 * @return the serv buff deg
	 */
	public int getServBuffDeg() {
		return servBuffDeg;
	}

	/**
	 * Sets the serv buff deg.
	 *
	 * @param servBuffDeg the new serv buff deg
	 */
	public void setServBuffDeg(int servBuffDeg) {
		this.servBuffDeg = servBuffDeg;
	}
	
	/**
	 * Checks if is buffing.
	 *
	 * @return true, if is buffing
	 */
	public boolean isBuffing(){
		return canBuff;
	}
}
