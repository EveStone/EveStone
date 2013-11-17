package eveStone.model;

public class Deck {
	
	private Carte[] tabCartes = new Carte[30];
	private String nom;
	
	public Deck(String nom, Carte[] tabCartes)
	{
		this.nom = nom;
		this.tabCartes = tabCartes;
	}

	public Carte[] getTabCartes() {
		return tabCartes;
	}

	public void setTabCartes(Carte[] tabCartes) {
		this.tabCartes = tabCartes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
