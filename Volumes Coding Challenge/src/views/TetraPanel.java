package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.Tetrahedron;

/**
 * Class which defines a Panel view for a Tetrahedron object. 
 * Extends the JPanel abstract class and implements the Panel interface's methods.
 * @author James Devenport
 *
 */
public class TetraPanel extends JPanel implements Panel{

	private static final long serialVersionUID = -2860543431359255117L;
	private JTextField textField;
	private JButton btnCalculateVolume;
	private JTextArea resultField;
	private Tetrahedron tetra;
	
	/**
	 * Default constructor which builds the TetraPanel view. 
	 * Calculates the initial volume of a tetrahedron model passed as a parameter, and uses that object to initialise the TetraPanel view.
	 * @param tetra Tetra model
	 */
	public TetraPanel(Tetrahedron tetra) {
		super();
		this.tetra = tetra;
		tetra.calculateVolume();
		createTetraPanel(this.tetra);
	}
	
	/**
	 * Method used to build and initialise the TetraPanel view using a tetrahedron model passed as a parameter.
	 * @param tetra Tetrahedron model
	 */
	public void createTetraPanel(Tetrahedron tetra) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TetraPanel.class.getResource("/resources/Volume Calculator.png")));
		lblNewLabel.setBounds(10, 10, 221, 32);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 52, 490, 382);
		add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 452, 34);
		panel.add(separator);
		
		JLabel lblTetra = new JLabel("Tetrahedron Volume");
		lblTetra.setBounds(10, 10, 168, 24);
		panel.add(lblTetra);
		
		JLabel lblEnterCubeWidth = new JLabel("Enter Edge Length: ");
		lblEnterCubeWidth.setBounds(46, 89, 132, 24);
		panel.add(lblEnterCubeWidth);
		
		textField = new JTextField();
		textField.setBounds(199, 91, 132, 21);
		BigDecimal edge = tetra.getModifier();
		textField.setText(edge.toString());
		panel.add(textField);
		textField.setColumns(10);
		
		btnCalculateVolume = new JButton("<html>Calculate Tetrahedron<br>Volume</html>");
		btnCalculateVolume.setBounds(199, 122, 132, 55);
		panel.add(btnCalculateVolume);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(87, 216, 46, 13);
		panel.add(lblResult);
		
		resultField = new JTextArea();
		resultField.setFont(new Font("Monospaced", Font.PLAIN, 16));
		resultField.setEditable(false);
		resultField.setBounds(87, 249, 244, 34);
		BigDecimal volume = tetra.getVolume();
		resultField.setText(volume.toString());
		panel.add(resultField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 293, 331, 2);
		panel.add(separator_1);
		
		JLabel lblresultsAreDisplayed = new JLabel("*Results are displayed in cm\u00B3");
		lblresultsAreDisplayed.setBounds(46, 305, 229, 13);
		panel.add(lblresultsAreDisplayed);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TetraPanel.class.getResource("/resources/tetrahedron_small.jpg")));
		label.setBounds(87, 110, 102, 96);
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
     * Sets the newly calculated volume of the tetrahedron model in the TetraPanel view.
     * @param newVolume Volume of tetrahedron model.
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
	 * Listener method which triggers the actionPerformed method in the TetrahedronController upon click.
	 * @param calcVolListener Listener object which triggers upon the btnCalculateVolume button being clicked
	 */
    public void calcVolumeBtnListener(ActionListener calcVolListener) {
        this.btnCalculateVolume.addActionListener(calcVolListener);
    }

	
}
