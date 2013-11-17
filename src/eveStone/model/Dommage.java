package eveStone.model;

public class Dommage extends Sort{
	
	private int degats;
	
	public Dommage(int ressource, String image, String description, int degats)
	{
		super(ressource, image, description);
		this.degats = degats;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}
	
	

}
