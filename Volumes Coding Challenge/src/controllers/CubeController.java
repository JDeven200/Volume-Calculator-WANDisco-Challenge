package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import views.AppFrame;
import views.CubePanel;
import models.Cube;
/**
 * Class for handling a click of the "Calculate Cube Volume" button
 * 
 * @author James Devenport
 * 
 */
public class CubeController {

	private Cube cube;
	private CubePanel cubePanel;
	
	
	/**
	 * Retrieves the view from the application frame and attaches a listener
	 * @param appFrame Application JFrame containing all components
	 * @param cube Cube model
	 * 
	 */
	public CubeController(AppFrame appFrame, Cube cube) {
		this.cube = cube;
		this.cubePanel = appFrame.getCubePanel();
		cubePanel.calcVolumeBtnListener(new calculateVolumeListener());
		
	}
	
	/**
	 * Nested Class which implements the ActionListener Interface
	 * @author James Devenport
	 *
	 */
	class calculateVolumeListener implements ActionListener {

		/**
		 * Overrides the actionPerformed method. Checks user input is a positive number. 
		 * If it is, the cube model is updated with the user-entered width and the volume is calculated.
		 * If not, an error is shown to the user by calling the showError() method in the cubePanel view.
		 * 
		 * Catches a NumberFormatException and shows error to the user if a non-numerical character is entered.
		 * 
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			try {
				userInput = cubePanel.getUserInput();
				double inputCheck = Double.parseDouble(userInput);
				if(inputCheck >= 0) {
					BigDecimal width = new BigDecimal(userInput);
					cube.setModifier(width);
					cube.calculateVolume();
					BigDecimal volume = cube.getVolume();
					if(volume.equals(new BigDecimal("1").negate())) {
						cubePanel.showError("Numbers only!");
					} else {
						String volumeString = volume.toString();
						cubePanel.setVolume(volumeString);
					}
				} else {
					cubePanel.showError("Positive numbers only!");
				}
				
			} catch(NumberFormatException nfex) {
				cubePanel.showError("Numbers only!");
			}
			
		}
		
	}
}
