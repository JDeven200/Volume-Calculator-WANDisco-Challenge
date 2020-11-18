package models;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Implementation class for a sphere object - extends the Shapes abstract class.
 * @author James Devenport
 *
 */
public class Sphere extends Shapes{
	
	/**
	 * Default constructor. Sets the default radius of a sphere to 1cm.
	 */
	public Sphere() {
		super();
		setModifier(new BigDecimal("1"));
	}
	
	/**
	 * Constructor used when the radius of a sphere is known. Used for unit test cases.
	 * @param radius Radius of the sphere
	 */
	public Sphere(BigDecimal radius) {
		super();
		setModifier(radius);
	}
	
	/**
	 * Overrides the abstract method in Shapes. Implements the formula to calculate the volume of a sphere - 4/3*pi*r^3
	 * Catches a thrown NumberFormatException if the user's input was anything other than a numerical value.
	 */
	@Override
	public void calculateVolume() {
		try {
			BigDecimal cubicVolume = getModifier();
			cubicVolume = cubicVolume.pow(3);
			BigDecimal fourOverThree =  new BigDecimal("4").divide(new BigDecimal("3"), 9, RoundingMode.HALF_UP);
			Double doublePi = (Double)getPi();
			String piString = doublePi.toString();
			BigDecimal pi = new BigDecimal(piString);
			BigDecimal sphereVolume = new BigDecimal(fourOverThree.toString()).multiply(pi).multiply(cubicVolume);
			sphereVolume =  sphereVolume.setScale(2, RoundingMode.HALF_UP);
			setVolume(sphereVolume);
		} catch(NumberFormatException e) {
			System.out.println("Input was not a number!");
			setVolume(new BigDecimal("1").negate());
		}
		
	}

}
