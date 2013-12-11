package be.ephec.eveStone.model.net;

import java.io.Serializable;

/**
 * Cette classe permet de cr�er les objet qui seront envoyé.
 * @author nicolas, andy
 *
 */
public class ObjectSend implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7529348765750425977L;
	/**
	 * 
	 */
	private int action;//Permet de dire quelle action l'adversaire � effectuer et ainsi facilit� les casting
	private Object obj;
	private int indice;
	
	private Object terrainAdv;
	private Object terrain;
	private int[] nbVieTerrain;
	private int[] nbDegatsTerrain;
	private int[] nbVieAdv;
	private int[] nbDegatsAdv;
	private Boolean[] visibleTerrain;
	private Boolean[] visibleTerrainAdv;
	
	private int nbCoque;
	private int nbStruct;
	
	/**
	 * Constructeur de la classe ObjectSend
	 * @param action: int ==> Donne l'action que l'adversaire a effectué
	 * @param obj: Object ==> Donne l'objet que l'on castera en fonction de l'action effectué.
	 */
	public ObjectSend(int action, Object obj) {
		this.action = action;
		this.obj = obj;
	}
	
	
	
	public ObjectSend(int action, int nbCoque, int nbStruct) {
		super();
		this.action = action;
		this.nbCoque = nbCoque;
		this.nbStruct = nbStruct;
	}



	public ObjectSend(int action, Object terrainAdv, Object terrain,
			int[] nbVieTerrain, int[] nbDegatsTerrain, int[] nbVieAdv,
			int[] nbDegatsAdv, Boolean[] visibleTerrain, Boolean[] visibleTerrainAdv) {
		super();
		this.action = action;
		this.terrainAdv = terrainAdv;
		this.terrain = terrain;
		this.nbVieTerrain = nbVieTerrain;
		this.nbDegatsTerrain = nbDegatsTerrain;
		this.nbVieAdv = nbVieAdv;
		this.nbDegatsAdv = nbDegatsAdv;
		this.visibleTerrain = visibleTerrain;
		this.visibleTerrainAdv=visibleTerrainAdv;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public int getIndex(){
		return indice;
	}

	public Object getTerrainAdv() {
		return terrainAdv;
	}

	public Object getTerrain() {
		return terrain;
	}


	public int[] getNbVieTerrain() {
		return nbVieTerrain;
	}


	public int[] getNbDegatsTerrain() {
		return nbDegatsTerrain;
	}


	public int[] getNbVieAdv() {
		return nbVieAdv;
	}


	public int[] getNbDegatsAdv() {
		return nbDegatsAdv;
	}


	public Boolean[] getVisibleTerrain() {
		return visibleTerrain;
	}


	public Boolean[] getVisibleTerrainAdv() {
		return visibleTerrainAdv;
	}



	public int getNbCoque() {
		return nbCoque;
	}



	public int getNbStruct() {
		return nbStruct;
	}
	
	

	
}
