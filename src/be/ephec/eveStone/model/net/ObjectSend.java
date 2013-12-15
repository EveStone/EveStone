package be.ephec.eveStone.model.net;

import java.io.Serializable;


/**
 * Cette classe permet de cr�er les objet qui seront envoyé.
 * @author nicolas, andy
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 *
 */
public class ObjectSend implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7529348765750425977L;
	
	/** The action. */
	private int action;//Permet de dire quelle action l'adversaire � effectuer et ainsi facilit� les casting
	
	/** The obj. */
	private Object obj;
	
	/** The indice. */
	private int indice;
	
	/** The terrain adv. */
	private Object terrainAdv;
	
	/** The terrain. */
	private Object terrain;
	
	/** The nb vie terrain. */
	private int[] nbVieTerrain;
	
	/** The nb degats terrain. */
	private int[] nbDegatsTerrain;
	
	/** The nb vie adv. */
	private int[] nbVieAdv;
	
	/** The nb degats adv. */
	private int[] nbDegatsAdv;
	
	/** The visible terrain. */
	private Boolean[] visibleTerrain;
	
	/** The visible terrain adv. */
	private Boolean[] visibleTerrainAdv;
	
	/** The nb coque. */
	private int nbCoque;
	
	/** The nb struct. */
	private int nbStruct;
	
	/** The nb carte main. */
	private int nbCarteMain;
	
	/**
	 * Constructeur de la classe ObjectSend.
	 *
	 * @param action the action
	 * @param obj the obj
	 */
	public ObjectSend(int action, Object obj) {
		this.action = action;
		this.obj = obj;
	}
	
	
	
	/**
	 * Instantiates a new object send.
	 *
	 * @param action the action
	 * @param nbCoque the nb coque
	 * @param nbStruct the nb struct
	 * @param visibleTerrainAdv the visible terrain adv
	 */
	public ObjectSend(int action, int nbCoque, int nbStruct, Boolean[] visibleTerrainAdv) {
		super();
		this.action = action;
		this.nbCoque = nbCoque;
		this.nbStruct = nbStruct;
		this.visibleTerrainAdv = visibleTerrainAdv;
	}



	/**
	 * Instantiates a new object send.
	 *
	 * @param action the action
	 * @param terrainAdv the terrain adv
	 * @param terrain the terrain
	 * @param nbVieTerrain the nb vie terrain
	 * @param nbDegatsTerrain the nb degats terrain
	 * @param nbVieAdv the nb vie adv
	 * @param nbDegatsAdv the nb degats adv
	 * @param visibleTerrain the visible terrain
	 * @param visibleTerrainAdv the visible terrain adv
	 */
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
	
	/**
	 * Instantiates a new object send.
	 *
	 * @param action the action
	 * @param obj the obj
	 * @param nbCarteMain the nb carte main
	 */
	public ObjectSend(int action, Object obj, int nbCarteMain)
	{
		this.action = action;
		this.obj = obj;
		this.nbCarteMain = nbCarteMain;
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public int getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(int action) {
		this.action = action;
	}

	/**
	 * Gets the obj.
	 *
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * Sets the obj.
	 *
	 * @param obj the new obj
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	public int getIndex(){
		return indice;
	}

	/**
	 * Gets the terrain adv.
	 *
	 * @return the terrain adv
	 */
	public Object getTerrainAdv() {
		return terrainAdv;
	}

	/**
	 * Gets the terrain.
	 *
	 * @return the terrain
	 */
	public Object getTerrain() {
		return terrain;
	}


	/**
	 * Gets the nb vie terrain.
	 *
	 * @return the nb vie terrain
	 */
	public int[] getNbVieTerrain() {
		return nbVieTerrain;
	}


	/**
	 * Gets the nb degats terrain.
	 *
	 * @return the nb degats terrain
	 */
	public int[] getNbDegatsTerrain() {
		return nbDegatsTerrain;
	}


	/**
	 * Gets the nb vie adv.
	 *
	 * @return the nb vie adv
	 */
	public int[] getNbVieAdv() {
		return nbVieAdv;
	}


	/**
	 * Gets the nb degats adv.
	 *
	 * @return the nb degats adv
	 */
	public int[] getNbDegatsAdv() {
		return nbDegatsAdv;
	}


	/**
	 * Gets the visible terrain.
	 *
	 * @return the visible terrain
	 */
	public Boolean[] getVisibleTerrain() {
		return visibleTerrain;
	}


	/**
	 * Gets the visible terrain adv.
	 *
	 * @return the visible terrain adv
	 */
	public Boolean[] getVisibleTerrainAdv() {
		return visibleTerrainAdv;
	}



	/**
	 * Gets the nb coque.
	 *
	 * @return the nb coque
	 */
	public int getNbCoque() {
		return nbCoque;
	}



	/**
	 * Gets the nb struct.
	 *
	 * @return the nb struct
	 */
	public int getNbStruct() {
		return nbStruct;
	}



	/**
	 * Gets the nb carte main.
	 *
	 * @return the nb carte main
	 */
	public int getNbCarteMain() {
		return nbCarteMain;
	}
	
	

	
}
