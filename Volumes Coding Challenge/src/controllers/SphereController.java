package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import models.Sphere;
import views.AppFrame;
import views.SpherePanel;

/**
 * Class for handling a click of the "Calculate Sphere Volume" button
 * 
 * @author James Devenport
 * 
 */

public class SphereController {

	private Sphere sphere;
	private SpherePanel spherePanel;
	
	/**
	 * Retrieves the view from the application frame and attaches a listener
	 * @param appFrame Application JFrame containing all components
	 * @param sphere Sphere model
	 * 
	 */
	public SphereController(AppFrame appFrame, Sphere sphere) {
		this.sphere = sphere;
		this.spherePanel = appFrame.getSpherePanel();
		spherePanel.calcVolumeBtnListener(new calculateVolumeListener());
		
	}
	
	
	/**
	 * Nested Class which implements the ActionListener Interface
	 * @author James Devenport
	 *
	 */
	class calculateVolumeListener implements ActionListener {

		/**
		 * Overrides the actionPerformed method. Checks user input is a positive number. 
		 * If it is, the sphere model is updated with the user-entered width and the volume is calculated.
		 * If not, an error is shown to the user by calling the showError() method in the spherePanel view.
		 * 
		 * Catches a NumberFormatException and shows error to the user if a non-numerical character is entered.
		 * 
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			try {
				userInput = spherePanel.getUserInput();
				double inputCheck = Double.parseDouble(userInput);
				if(inputCheck >= 0) {
					BigDecimal width = new BigDecimal(userInput);
					sphere.setModifier(width);
					sphere.calculateVolume();
					BigDecimal volume = sphere.getVolume();
					if(volume.equals(new BigDecimal("1").negate())) {
						spherePanel.showError("Numbers only!");
					} else {
						String volumeString = volume.toString();
						spherePanel.setVolume(volumeString);
					}
				} else {
					spherePanel.showError("Positive numbers only!");
				}
				
			} catch(NumberFormatException nfex) {
				spherePanel.showError("Numbers only!");
			}
			
		}
		
	}
}
