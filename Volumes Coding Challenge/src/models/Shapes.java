package models;

import java.math.BigDecimal;

/**
 * Abstract model class containing common fields and methods shared amongst the Cube, Sphere and Tetrahedron models
 * @author James Devenport
 *
 */
public abstract class Shapes {
	
	private BigDecimal volume;
	private BigDecimal modifier; //modifier can either be width, radius, or edge length depending on the shape
	private final double pi = Math.PI;
	
	/**
	 * returns the value of the shape's volume.
	 * @return Returns volume as a BigDecimal
	 */
	public BigDecimal getVolume() {
		return this.volume;
	}
	
	/**
	 * sets the value of the shape's volume.
	 * @param volume Volume of the shape
	 */
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	
	/**
	 * Returns the shape's modifier value (width, radius, or edge).
	 * @return Returns the shape's modifier as a BigDecimal
	 */
	public BigDecimal getModifier() {
		return this.modifier;
	}
	
	/**
	 * Sets the shape's modifier value (width, radius, or edge).
	 * @param modifier User-defined modifier as a BigDecimal
	 */
	public void setModifier(BigDecimal modifier) {
		this.modifier = modifier;
	}
	
	/**
	 * Returns the value of Pi for convenience.
	 * @return Returns the value of pi as a double
	 */
	public double getPi() {
		return this.pi;
	}
	
	/**
	 * Abstract method definition for calculating the volume of a shape. Implementation varies depending on the shape.
	 */
	public abstract void calculateVolume();
}
