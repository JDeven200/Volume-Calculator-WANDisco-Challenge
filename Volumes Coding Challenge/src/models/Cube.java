package models;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Implementation class for a cube object - extends the Shapes abstract class.
 * @author James Devenport
 *
 */
public class Cube extends Shapes{

	/**
	 * Default constructor. Sets the default width of a cube object as 1cm.
	 */
	public Cube() {
		super();
		setModifier(new BigDecimal("1"));
	}
	
	/**
	 * Constructor which can be used if creating a cube where the width is defined. Used for Unit test cases.
	 * @param width Width of the edge of a cube object (since all edges are identical in size, only one value is needed).
	 */
	public Cube(BigDecimal width) {
		super();
		setModifier(width);
	}
	
	/**
	 * Overrides the abstract method in Shapes. Implements the formula to calculate the volume of a cube - cube width^3
	 * Catches a thrown NumberFormatException if the user's input was anything other than a numerical value.
	 */
	@Override
	public void calculateVolume() {
		try {
			BigDecimal volume = getModifier();
			volume = volume.pow(3).setScale(2, RoundingMode.HALF_UP);
			setVolume(volume);
		} catch(NumberFormatException e) {
			System.out.println("Input was not a number!");
			setVolume(new BigDecimal("1").negate());
		}
		
	}

}
