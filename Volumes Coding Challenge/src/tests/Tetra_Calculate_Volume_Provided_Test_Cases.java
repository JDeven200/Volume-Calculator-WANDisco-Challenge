package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import models.Tetrahedron;

public class Tetra_Calculate_Volume_Provided_Test_Cases {

	@Test
	public void testTestCase1() {
		Tetrahedron testTetrahedron = new Tetrahedron();
		testTetrahedron.calculateVolume();
		BigDecimal expectedAnswer = new BigDecimal("0.12");
		BigDecimal actualAnswer = testTetrahedron.getVolume();
		assertTrue(expectedAnswer == actualAnswer);
	}
	
	@Test
	public void testTestCase2() {
		Tetrahedron testTetrahedron = new Tetrahedron(new BigDecimal("5"));
		testTetrahedron.calculateVolume();
		BigDecimal expectedAnswer = new BigDecimal("14.73");
		BigDecimal actualAnswer = testTetrahedron.getVolume();
		assertTrue(expectedAnswer == actualAnswer);
	}

}
