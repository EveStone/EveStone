package be.ephec.eveStone;

import javax.swing.SwingUtilities;

import be.ephec.eveStone.controller.Controller;


/**
 * La Classe EveStone.
 * 
 * @author Dasseler Nicolas & Vanbutsele Andy
 */
public class EveStone{

	/** le controller. */
	private static Controller CONTROLLER;

	/**
	 * La méthode main du programme.
	 *
	 * @param args non utilisé
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				CONTROLLER = new Controller();
				CONTROLLER.makeStartFrame();
				CONTROLLER.displayStartFrame();
			}
		});
	}
	
	/**
	 * Retourne le controller.
	 *
	 * @return controller
	 */
	public static Controller getController(){
		return CONTROLLER;
	}

}
