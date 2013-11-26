package be.ephec.eveStone.model;

public class Sort extends Carte{
	
	private String description;
	
	public Sort(String nom,int ressource, String image, String description)
	{
		super(nom,ressource, image);
		this.description = description;
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}
