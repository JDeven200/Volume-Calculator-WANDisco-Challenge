package tests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Cube;

class Cube_Calculate_Volume_Input_Is_Negative_Number {

	@Test
	public void testNegativeNumber() {
		Cube testCube = new Cube(new BigDecimal("243").negate());
		testCube.calculateVolume();
		BigDecimal volume = testCube.getVolume();
		System.out.println(volume.toString());
		BigDecimal actualAnswer = new BigDecimal(volume.toString());
		BigDecimal expectedAnswer = new BigDecimal("14348907.00").negate();
		System.out.println("Expected = " + expectedAnswer + " Actual = " + actualAnswer);
		assertTrue(expectedAnswer.equals(actualAnswer));
	}
}
