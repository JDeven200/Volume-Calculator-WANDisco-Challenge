package tests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Tetrahedron;

class Tetra_Calculate_Volume_Input_Is_Negative_Number {

	@Test
	public void testNegativeNumber() {
		Tetrahedron testTetra = new Tetrahedron(new BigDecimal("34").negate());
		testTetra.calculateVolume();
		BigDecimal volume = testTetra.getVolume();
		System.out.println(volume.toString());
		BigDecimal actualAnswer = new BigDecimal(volume.toString());
		BigDecimal expectedAnswer = new BigDecimal("4632.02").negate();
		System.out.println("Expected = " + expectedAnswer + " Actual = " + actualAnswer);
		assertTrue(expectedAnswer.equals(actualAnswer));
	}

}
