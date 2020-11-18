package tests;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Sphere;

class Sphere_Calculate_Volume_Input_Is_Extreme_Value {

	@Test
	public void testExtremePositiveValue() {
		Sphere testSphere = new Sphere(new BigDecimal("52550318"));
		testSphere.calculateVolume();
		BigDecimal volume = testSphere.getVolume();
		System.out.println(volume.toString());
		BigDecimal actualAnswer = new BigDecimal(volume.toString());
		BigDecimal expectedAnswer = new BigDecimal("607875520583133608869595.24");
		System.out.println("Expected = " + expectedAnswer + " Actual = " + actualAnswer);
		assertTrue(expectedAnswer.equals(actualAnswer));
	}

}
