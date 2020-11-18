package views;

import java.awt.event.ActionListener;

/**
 * Interface class which defines methods to be implemented within the CubePanel, SpherePanel and TetraPanel Classes.
 * @author James Devenport
 *
 */
public interface Panel {

	
    public String getUserInput();

    public void setVolume(String newVolume);
    
    public void showError(String errMessage);
	
    public void calcVolumeBtnListener(ActionListener calcVolListener);
}
