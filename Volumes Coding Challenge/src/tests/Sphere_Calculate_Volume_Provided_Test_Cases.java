package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Sphere;

public class Sphere_Calculate_Volume_Provided_Test_Cases {
	
	@Test
	public void testTestCase1() {
		Sphere testSphere = new Sphere();
		testSphere.calculateVolume();
		BigDecimal expectedAnswer = new BigDecimal("4.19");
		BigDecimal actualAnswer = testSphere.getVolume();
		System.out.println("Expected: " + expectedAnswer.toString() + " Actual: " + actualAnswer.toString());
		assertTrue(expectedAnswer.equals(actualAnswer));
	}
	
	@Test
	public void testTestCase2() {
		Sphere testSphere = new Sphere(new BigDecimal("5"));
		testSphere.calculateVolume();
		BigDecimal expectedAnswer = new BigDecimal("523.60");
		BigDecimal actualAnswer = testSphere.getVolume();
		System.out.println("Expected: " + expectedAnswer.toString() + " Actual: " + actualAnswer.toString());
		assertTrue(expectedAnswer.equals(actualAnswer));
	}
	
	

}
