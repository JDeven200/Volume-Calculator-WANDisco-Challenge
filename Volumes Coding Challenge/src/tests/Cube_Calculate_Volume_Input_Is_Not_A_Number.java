package tests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Cube;

class Cube_Calculate_Volume_Input_Is_Not_A_Number {

	@Test
	//Should always fail - BigDecimal cannot parse a value which is not a number
	/*
	 * Solution: 
	 * 	Well-secured code which makes it impossible for user to ever 
	 * 	construct a model using a BigDecimal with a non-number parameter.
	 */
	public void testNotANumber() {
		Cube testCube = new Cube(new BigDecimal("not a number"));
		testCube.calculateVolume();
		BigDecimal volume = testCube.getVolume();
		System.out.println(volume.toString());
		BigDecimal actualAnswer = new BigDecimal(volume.toString());
		BigDecimal expectedAnswer = new BigDecimal("1");
		System.out.println("Expected = " + expectedAnswer + " Actual = " + actualAnswer);
		assertTrue(expectedAnswer.equals(actualAnswer));
	}

}
