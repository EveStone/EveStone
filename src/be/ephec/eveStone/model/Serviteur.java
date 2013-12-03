package be.ephec.eveStone.model;

public class Serviteur extends Carte {
	
	private int nbVie;
	private int nbDommage;
	private int dommageSort;
	private int servBuffPv;
	private int servBuffDeg;
	
	
	/**
	 * 
	 *Constructeur d'un serviteur classique
	 * @param ressource
	 * @param image
	 * @param nbVie
	 * @param nbDommage
	 */
	public Serviteur(String nom, int ressource, String image, int nbVie, int nbDommage)
	{
		super(nom,ressource,image);
		this.nbVie = nbVie;
		this.nbDommage = nbDommage;
	}
	
	/**
	 * Constructeur d'un serviteur qui fait des dommages d�s qu'il est pos�.
	 * @param ressource
	 * @param image
	 * @param nbVie
	 * @param nbDommage
	 * @param dommageSort
	 */
	public Serviteur(String nom, int ressource, String image, int nbVie, int nbDommage, int dommageSort)
	{
		super(nom,ressource,image);
		this.nbVie = nbVie;
		this.nbDommage = nbDommage;
		this.dommageSort = dommageSort;
		
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
	public Serviteur(String nom,int ressource, String image, int nbVie, int nbDommage, int servBuffPv, int servBuffDeg)
	{
		super(nom,ressource,image);
		this.nbVie = nbVie;
		this.nbDommage = nbDommage;
		this.servBuffDeg = servBuffDeg;
		this.servBuffPv = servBuffPv;	
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
	

}
