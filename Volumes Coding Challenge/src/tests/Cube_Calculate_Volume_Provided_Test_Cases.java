package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Cube;

public class Cube_Calculate_Volume_Provided_Test_Cases {

	@Test
	public void testTestCase1() {
		Cube testCube = new Cube();
		testCube.calculateVolume();
		BigDecimal expectedAnswer = new BigDecimal("1.00");
		BigDecimal actualAnswer = testCube.getVolume();
		assertTrue(expectedAnswer.equals(actualAnswer));
	}
	
	@Test
	public void testTestCase2() {
		Cube testCube = new Cube(new BigDecimal("5"));
		testCube.calculateVolume();
		BigDecimal expectedAnswer = new BigDecimal("125.00");
		BigDecimal actualAnswer = testCube.getVolume();
		assertTrue(expectedAnswer.equals(actualAnswer));
	}

}
