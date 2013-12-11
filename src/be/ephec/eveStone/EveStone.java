package be.ephec.eveStone;

import javax.swing.SwingUtilities;

import be.ephec.eveStone.controller.Controller;


public class EveStone{

	private static Controller CONTROLLER;

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
	public static Controller getController(){
		return CONTROLLER;
	}

}
