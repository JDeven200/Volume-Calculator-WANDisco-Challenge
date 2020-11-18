package views;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import models.Cube;
import models.Sphere;
import models.Tetrahedron;

/**
 * Class which builds the application's JFrame. Also used to initialise the tabs and panels which are contained within the JFrame.
 * @author James Devenport
 *
 */
public class AppFrame extends JFrame {

	private static final long serialVersionUID = 4750063844141427448L;
	private JTabbedPane tabbedPane;
	private CubePanel cubePanel;
	private SpherePanel spherePanel;
	private TetraPanel tetraPanel;

	/**
	 * Constructor which takes the cube, sphere and tetrahedron objects to be used in the application.
	 * The tabs are created and initialised in a JTabbedPane using the cube, sphere and tetrahedron as content.
	 * The createFrame method is then called to initialise the application JFrame.
	 * @param cube Cube model
	 * @param sphere Sphere model
	 * @param tetra Tetrahedron model
	 */
	public AppFrame(Cube cube, Sphere sphere, Tetrahedron tetra) {
		super();
		tabbedPane =  new JTabbedPane();
		buildTabs(tabbedPane, cube, sphere, tetra);
		createFrame();
	}
	
	/**
	 * Constructor used to build the application JFrame using a specified frame width and height.
	 * The tabs are created and initialised in a JTabbedPane using the cube, sphere and tetrahedron as content.
	 * The createFrame method is then called taking the width and height as parameters to initialise the application JFrame.
	 * @param cube Cube model
	 * @param sphere Sphere model
	 * @param tetra Tetrahedron model
	 * @param width Width of the frame
	 * @param height Height of the frame
	 */
	public AppFrame(Cube cube, Sphere sphere, Tetrahedron tetra, int width, int height) {
		super();
		tabbedPane =  new JTabbedPane();
		buildTabs(tabbedPane, cube, sphere, tetra);
		createFrame(width, height);
	}
	
	
	/**
	 * Method used to create and initialise the tabs which contain each panel, which in turn contains shape object data.
	 * The cubePanel, spherePanel, and tetraPanel views are instantiated as new CubePanel, SpherePanel and TetraPanel objects
	 * taking a cube, sphere and tetrahedron model as parameters respectively. 
	 * @param tabbedPane JTabbedPane object
	 * @param cube Cube model
	 * @param sphere Sphere model
	 * @param tetra Tetrahedron model
	 */
	public void buildTabs(JTabbedPane tabbedPane, Cube cube, Sphere sphere, Tetrahedron tetra) {
	    this.cubePanel = new CubePanel(cube);
	    this.spherePanel = new SpherePanel(sphere);
	    this.tetraPanel = new TetraPanel(tetra);

	    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	    cubePanel.setLayout(null);
	    tabbedPane.addTab("Cube", cubePanel);

	    spherePanel.setLayout(null);
	    tabbedPane.addTab("Sphere", spherePanel);

	    tetraPanel.setLayout(null);
	    tabbedPane.addTab("Tetrahedron", tetraPanel);
	    
	    this.pack();
	}
	
	/**
	 * Method used to create the application frame. A default size of 500x500 is used when no parameters are specified.
	 */
	public void createFrame() {
		JFrame frame = new JFrame();
		frame.setContentPane(tabbedPane);
		frame.setSize(500, 500);
		frame.setTitle("Volume Calculator");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon.png")));
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	
	/**
	 * Method used to create the application frame. Takes the specified width and height parameters for the size of the frame.
	 * @param width Width of the frame
	 * @param height Height of the frame
	 */
	public void createFrame(int width, int height) {
		JFrame frame = new JFrame();
		frame.setContentPane(tabbedPane);
		frame.setSize(width, height);
		frame.setTitle("Volume Calculator");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	
	/**
	 * Returns the CubePanel view object
	 * @return Returns cubePanel
	 */
	public CubePanel getCubePanel() {
		return this.cubePanel;
	}
	
	/**
	 * Returns the SpherePanel view object
	 * @return Returns spherePanel
	 */
	public SpherePanel getSpherePanel() {
		return this.spherePanel;
	}
	
	/**
	 * Returns the TetraPanel view object
	 * @return Returns tetraPanel
	 */
	public TetraPanel getTetraPanel() {
		return this.tetraPanel;
	}
}
