package be.ephec.eveStone;

import be.ephec.eveStone.controller.Controller;


public class EveStone {

	private static Controller CONTROLLER;

	public static void main(String[] args)
	{
		CONTROLLER = new Controller();
		CONTROLLER.makeStartFrame();
		CONTROLLER.displayStartFrame();
	}
	public static Controller getController(){
		return CONTROLLER;
	}


}
