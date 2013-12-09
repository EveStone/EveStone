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
	private static final long serialVersionUID = 1L;
	private int action;//Permet de dire quelle action l'adversaire � effectuer et ainsi facilit� les casting
	private Object obj;
	
	/**
	 * Constructeur de la classe ObjectSend
	 * @param action: int ==> Donne l'action que l'adversaire a effectué
	 * @param obj: Object ==> Donne l'objet que l'on castera en fonction de l'action effectué.
	 */
	public ObjectSend(int action, Object obj) {
		this.action = action;
		this.obj = obj;
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
	
	

}
