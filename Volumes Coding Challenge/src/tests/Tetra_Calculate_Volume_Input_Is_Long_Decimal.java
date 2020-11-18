package tests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Tetrahedron;

class Tetra_Calculate_Volume_Input_Is_Long_Decimal {

	@Test
	public void testLongDecimal() {
		Tetrahedron testTetra = new Tetrahedron(new BigDecimal("43.4532452134323"));
		testTetra.calculateVolume();
		BigDecimal volume = testTetra.getVolume();
		System.out.println(volume.toString());
		BigDecimal actualAnswer = new BigDecimal(volume.toString());
		BigDecimal expectedAnswer = new BigDecimal("9669.42");
		System.out.println("Expected = " + expectedAnswer + " Actual = " + actualAnswer);
		assertTrue(expectedAnswer.equals(actualAnswer));
	}

}
