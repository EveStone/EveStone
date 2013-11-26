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
	public Serviteur(int ressource, String image, int nbVie, int nbDommage)
	{
		super(ressource,image);
		this.nbVie = nbVie;
		this.nbDommage = nbDommage;
	}
	
	/**
	 * Constructeur d'un serviteur qui fait des dommages dès qu'il est posé.
	 * @param ressource
	 * @param image
	 * @param nbVie
	 * @param nbDommage
	 * @param dommageSort
	 */
	public Serviteur(int ressource, String image, int nbVie, int nbDommage, int dommageSort)
	{
		super(ressource,image);
		this.nbVie = nbVie;
		this.nbDommage = nbDommage;
		this.dommageSort = dommageSort;
		
	}
	
	/**
	 * Constructeur d'un serviteur qui buff un autre serviteur d'un nombre de pv et de dégats.
	 * @param ressource
	 * @param image
	 * @param nbVie
	 * @param nbDommage
	 * @param servBuffPv
	 * @param servBuffDeg
	 */
	public Serviteur(int ressource, String image, int nbVie, int nbDommage, int servBuffPv, int servBuffDeg)
	{
		super(ressource,image);
		this.nbVie = nbVie;
		this.nbDommage = nbDommage;
		this.servBuffDeg = servBuffDeg;
		this.servBuffPv = servBuffPv;	
	}
	
	/**
	 * Ce constructeur permet de créé un serviteur qui soit buffera les pv ou les degats d'un autre en fonction du boolean check
	 * vrai ==> degats
	 * faux ==> pv
	 * @param ressource
	 * @param image
	 * @param nbVie
	 * @param nbDommage
	 * @param servBuffPvOuDeg
	 * @param check
	 */
	public Serviteur(int ressource, String image, int nbVie, int nbDommage, int servBuffPvOuDeg, boolean check)
	{
		super(ressource,image);
		this.nbVie = nbVie;
		this.nbDommage = nbDommage;
		if (check == true) this.servBuffDeg = servBuffPvOuDeg;
		else this.servBuffPv = servBuffPvOuDeg;
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
