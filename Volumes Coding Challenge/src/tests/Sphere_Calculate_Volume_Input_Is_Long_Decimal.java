package tests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Sphere;

class Sphere_Calculate_Volume_Input_Is_Long_Decimal {

	@Test
	public void testLongDecimal() {
		Sphere testSphere = new Sphere(new BigDecimal("43.4532452134323"));
		testSphere.calculateVolume();
		BigDecimal volume = testSphere.getVolume();
		System.out.println(volume.toString());
		BigDecimal actualAnswer = new BigDecimal(volume.toString());
		BigDecimal expectedAnswer = new BigDecimal("343680.79");
		System.out.println("Expected = " + expectedAnswer + " Actual = " + actualAnswer);
		assertTrue(expectedAnswer.equals(actualAnswer));
	}

}
