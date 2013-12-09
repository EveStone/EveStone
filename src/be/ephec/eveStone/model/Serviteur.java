package be.ephec.eveStone.model;

import java.io.Serializable;

public class Serviteur extends Carte implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8584328020461044873L;
	private int nbVie;
	private int nbDommage;
	private int dommageSort;
	private int servBuffPv;
	private int servBuffDeg;
	private boolean canBuff;
	
	
	/**
	 * 
	 *Constructeur d'un serviteur classique
	 * @param ressource
	 * @param image
	 * @param nbVie
	 * @param nbDommage
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
	 * @param ressource
	 * @param image
	 * @param nbVie
	 * @param nbDommage
	 * @param dommageSort
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
	 * @param ressource
	 * @param image
	 * @param nbVie
	 * @param nbDommage
	 * @param servBuffPv
	 * @param servBuffDeg
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
	
	public int getNbVie() {
		return nbVie;
	}


	public void setNbVie(int nbVie) {
		this.nbVie = nbVie;
	}


	public int getNbDommage() {
		return nbDommage;
	}


	public void setNbDommage(int nbDommage) {
		this.nbDommage = nbDommage;
	}

	public int getDommageSort() {
		return dommageSort;
	}

	public void setDommageSort(int dommageSort) {
		this.dommageSort = dommageSort;
	}

	public int getServBuffPv() {
		return servBuffPv;
	}

	public void setServBuffPv(int servBuffPv) {
		this.servBuffPv = servBuffPv;
	}

	public int getServBuffDeg() {
		return servBuffDeg;
	}

	public void setServBuffDeg(int servBuffDeg) {
		this.servBuffDeg = servBuffDeg;
	}
	
	public boolean isBuffing(){
		return canBuff;
	}
}
