package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import models.Cube;

/**
 * Class which defines a Panel view for a Cube object. 
 * Extends the JPanel abstract class and implements the Panel interface's methods.
 * @author James Devenport
 *
 */
public class CubePanel extends JPanel implements Panel{
	
	private static final long serialVersionUID = 544156904263346023L;
	private JTextField textField;
	private JButton btnCalculateVolume;
	private JTextArea resultField;
	private Cube cube;


	/**
	 * Default constructor which builds the CubePanel view. 
	 * Calculates the initial volume of a cube model passed as a parameter, and uses that object to initialise the CubePanel view.
	 * @param cube Cube model
	 */
	public CubePanel(Cube cube) {
		super();
		this.cube = cube;
		cube.calculateVolume();
		createCubePanel(this.cube);
	}
	
	/**
	 * Method used to build and initialise the CubePanel view using a cube model passed as a parameter.
	 * @param cube Cube model
	 */
	public void createCubePanel(Cube cube) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CubePanel.class.getResource("/resources/Volume Calculator.png")));
		lblNewLabel.setBounds(10, 10, 221, 32);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 52, 490, 382);
		add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 452, 34);
		panel.add(separator);
		
		JLabel lblCube = new JLabel("Cube Volume");
		lblCube.setBounds(10, 10, 107, 24);
		panel.add(lblCube);
		
		JLabel lblEnterCubeWidth = new JLabel("Enter Cube Width: ");
		lblEnterCubeWidth.setBounds(46, 89, 132, 24);
		panel.add(lblEnterCubeWidth);
		
		textField = new JTextField();
		textField.setBounds(199, 91, 132, 21);
		BigDecimal width = cube.getModifier();
		textField.setText(width.toString());
		panel.add(textField);
		textField.setColumns(10);
		
		btnCalculateVolume = new JButton("<html>Calculate Cube<br>Volume</html>");
		btnCalculateVolume.setBounds(199, 122, 132, 34);
		panel.add(btnCalculateVolume);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(87, 216, 46, 13);
		panel.add(lblResult);
		
		resultField = new JTextArea();
		resultField.setFont(new Font("Monospaced", Font.PLAIN, 16));
		resultField.setEditable(false);
		BigDecimal volume = cube.getVolume();
		resultField.setText(volume.toString());
		resultField.setBounds(87, 249, 244, 34);
		panel.add(resultField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 293, 331, 2);
		panel.add(separator_1);
		
		JLabel lblresultsAreDisplayed = new JLabel("*Results are displayed in cm\u00B3");
		lblresultsAreDisplayed.setBounds(46, 305, 229, 13);
		panel.add(lblresultsAreDisplayed);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CubePanel.class.getResource("/resources/cube_small.png")));
		label.setBounds(72, 111, 107, 101);
		panel.add(label);
	}
	
	/**
	 * Returns the data entered into the textField input box.
	 * @return Returns the textField field
	 */
    public String getUserInput() {
        return textField.getText();
    }

    /**
     * Sets the newly calculated volume of the cube model in the CubePanel view.
     * @param newVolume Volume of cube model.
     */
    public void setVolume(String newVolume) {
        resultField.setText(newVolume);
    }
    
    /**
     * Displays a warning message to the user in the view when an error occurs.
     * @param errMessage Message to be displayed upon error
     */
    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
	/**
	 * Listener method which triggers the actionPerformed method in the CubeController upon click.
	 * @param calcVolListener Listener object which triggers upon the btnCalculateVolume button being clicked
	 */
    public void calcVolumeBtnListener(ActionListener calcVolListener) {
        this.btnCalculateVolume.addActionListener(calcVolListener);
    }
}
