package be.ephec.eveStone;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.*;
import be.ephec.eveStone.model.repositories.Deck;
import be.ephec.eveStone.vieuw.StartFrame;

public class EveStone {

	private static Controller CONTROLLER;




	public static void main(String[] args)
	{
		CONTROLLER = new Controller();
		
	}
	public static Controller getController(){
		return CONTROLLER;
	}


}
