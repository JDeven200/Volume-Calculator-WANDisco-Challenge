package models;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Implementation class for a tetrahedron object - extends the Shapes abstract class.
 * @author James Devenport
 *
 */
public class Tetrahedron extends Shapes{

	/**
	 * Default constructor. Sets the default size of a regular tetrahedron's edge to 1cm.
	 */
	public Tetrahedron() {
		super();
		setModifier(new BigDecimal("1"));
	}
	
	/**
	 * Constructor used if the edge of a tetrahedron is known. Used for unit test cases.
	 * @param edge Edge of a tetrahedron as a BigDecimal (all edges are equal in a regular tetrahedron, so only one edge is needed).
	 */
	public Tetrahedron(BigDecimal edge) {
		super();
		setModifier(edge);
	}
	
	/**
	 * Overrides the abstract method in Shapes. Implements the formula to calculate the volume of a tetrahedron - edge^3 * sqrt(2)/12.
	 * Catches a thrown NumberFormatException if the user's input was anything other than a numerical value.
	 */
	@Override
	public void calculateVolume() {
		try {
			BigDecimal volume = getModifier().pow(3).multiply(new BigDecimal("2").sqrt((new MathContext(8))).divide(new BigDecimal("12"), 9, RoundingMode.HALF_UP));
			volume = volume.setScale(2, RoundingMode.HALF_UP);
			setVolume(volume);
		} catch(NumberFormatException e) {
			System.out.println("Input was not a number!");
			setVolume(new BigDecimal("1").negate());
		}
		
	}
}
