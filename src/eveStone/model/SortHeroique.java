package eveStone.model;

public class SortHeroique {
	
	private int degats;
	private int bouclier;
	
	public SortHeroique(int degats, int bouclier)
	{
		this.bouclier = bouclier;
		this.degats = degats;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	public int getBouclier() {
		return bouclier;
	}

	public void setBouclier(int bouclier) {
		this.bouclier = bouclier;
	}
	

}
