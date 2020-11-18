package tests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Tetrahedron;

class Tetra_Calculate_Volume_Input_Is_Extreme_Value {

	@Test
	public void testExtremePositiveValue() {
		Tetrahedron testTetra = new Tetrahedron(new BigDecimal("52550318"));
		testTetra.calculateVolume();
		BigDecimal volume = testTetra.getVolume();
		System.out.println(volume.toString());
		BigDecimal actualAnswer = new BigDecimal(volume.toString());
		BigDecimal expectedAnswer = new BigDecimal("17102508203857413427515.81");
		System.out.println("Expected = " + expectedAnswer + " Actual = " + actualAnswer);
		assertTrue(expectedAnswer.equals(actualAnswer));
	}
}
