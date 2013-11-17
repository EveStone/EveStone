package eveStone.model;

public class Sort extends Carte{
	
	private String description;
	
	public Sort(int ressource, String image, String description)
	{
		super(ressource, image);
		this.description = description;
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}
