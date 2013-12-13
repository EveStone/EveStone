package be.ephec.eveStone;

import javax.swing.SwingUtilities;

import be.ephec.eveStone.controller.Controller;


/**
 * The Class EveStone.
 */
public class EveStone{

	/** The controller. */
	private static Controller CONTROLLER;

	/**
	 * The main method.
	 *
	 * @param args the arguments
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
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	public static Controller getController(){
		return CONTROLLER;
	}

}
