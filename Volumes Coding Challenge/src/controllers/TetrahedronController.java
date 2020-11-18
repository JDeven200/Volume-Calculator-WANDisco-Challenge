package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import models.Tetrahedron;
import views.AppFrame;
import views.TetraPanel;

/**
 * Class for handling a click of the "Calculate Sphere Volume" button
 * 
 * @author James Devenport
 * 
 */

public class TetrahedronController {

	private Tetrahedron tetra;
	private TetraPanel tetraPanel;
	
	/**
	 * Retrieves the view from the application frame and attaches a listener
	 * @param appFrame Application JFrame containing all components
	 * @param sphere Tetrahedron model
	 * 
	 */
	public TetrahedronController(AppFrame appFrame, Tetrahedron tetra) {
		this.tetra = tetra;
		this.tetraPanel = appFrame.getTetraPanel();
		tetraPanel.calcVolumeBtnListener(new calculateVolumeListener());
		
	}
	
	/**
	 * Nested Class which implements the ActionListener Interface
	 * @author James Devenport
	 *
	 */
	class calculateVolumeListener implements ActionListener {

		/**
		 * Overrides the actionPerformed method. Checks user input is a positive number. 
		 * If it is, the tetrahedron model is updated with the user-entered width and the volume is calculated.
		 * If not, an error is shown to the user by calling the showError() method in the tetraPanel view.
		 * 
		 * Catches a NumberFormatException and shows error to the user if a non-numerical character is entered.
		 * 
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			try {
				userInput = tetraPanel.getUserInput();
				double inputCheck = Double.parseDouble(userInput);
				if(inputCheck >= 0) {
					BigDecimal width = new BigDecimal(userInput);
					tetra.setModifier(width);
					tetra.calculateVolume();
					BigDecimal volume = tetra.getVolume();
					if(volume.equals(new BigDecimal("1").negate())) {
						tetraPanel.showError("Numbers only!");
					} else {
						String volumeString = volume.toString();
						tetraPanel.setVolume(volumeString);
					}
				}else {
					tetraPanel.showError("Positive numbers only!");
				}
				
			} catch(NumberFormatException nfex) {
				tetraPanel.showError("Numbers only!");
			}
			
		}
		
	}
}
