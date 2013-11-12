package eveStone.model;

public class Serviteur extends Carte {
	
	private int nbVie;
	private int nbDommage;
	
	
	public Serviteur()
	{
		super();
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

}
