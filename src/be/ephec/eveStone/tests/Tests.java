package be.ephec.eveStone.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ephec.eveStone.controller.Controller;
import be.ephec.eveStone.model.Serviteur;

// TODO: Auto-generated Javadoc
/**
 * The Class Tests.
 */
public class Tests {

	/** The controller. */
	Controller controller = new Controller();
	
	/**
	 * Test get dommage.
	 */
	@Test
	public void  testGetDommage(){
		assertEquals(2, controller.getDommage(new Serviteur("",2,"","",2,2)));
	}

}
