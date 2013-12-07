package be.ephec.eveStone.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Serviteur;

public class Tests {

	Controller controller = new Controller();
	
	@Test
	public void  testGetDommage(){
		assertEquals(2, controller.getDommage(new Serviteur("",2,"","",2,2)));
	}

}
