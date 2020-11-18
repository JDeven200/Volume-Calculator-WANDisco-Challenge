package tests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Sphere;

class Sphere_Calculate_Volume_Input_Is_Negative_Number {

	@Test
	public void testNegativeNumber() {
		Sphere testSphere = new Sphere(new BigDecimal("23422").negate());
		testSphere.calculateVolume();
		BigDecimal volume = testSphere.getVolume();
		System.out.println(volume.toString());
		BigDecimal actualAnswer = new BigDecimal(volume.toString());
		BigDecimal expectedAnswer = new BigDecimal("53822087644561.28").negate();
		System.out.println("Expected = " + expectedAnswer + " Actual = " + actualAnswer);
		assertTrue(expectedAnswer.equals(actualAnswer));
	}

}
