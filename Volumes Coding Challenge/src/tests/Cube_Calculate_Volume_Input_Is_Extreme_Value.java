package tests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Cube;

public class Cube_Calculate_Volume_Input_Is_Extreme_Value {

	@Test
	public void testExtremePositiveValue() {
		Cube testCube = new Cube(new BigDecimal("52550318"));
		testCube.calculateVolume();
		BigDecimal volume = testCube.getVolume();
		System.out.println(volume.toString());
		BigDecimal actualAnswer = new BigDecimal(volume.toString());
		BigDecimal expectedAnswer = new BigDecimal("145119590864327230757432.00");
		System.out.println("Expected = " + expectedAnswer + " Actual = " + actualAnswer);
		assertTrue(expectedAnswer.equals(actualAnswer));
	}
}
