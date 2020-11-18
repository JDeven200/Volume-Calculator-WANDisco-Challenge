package controllers;

import models.Cube;
import models.Sphere;
import models.Tetrahedron;
import views.AppFrame;

/**
 * Entry point for the Volume Calculator Program
 * 
 * @author James Devenport
 * 
 */
public class Main {

	/**
	 * Declares and instantiates all model class objects and controller class objects.
	 * Also sets up the views within the application's JFrame (appFrame).
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Cube cube = new Cube();
		Sphere sphere = new Sphere();
		Tetrahedron tetra = new Tetrahedron();
		AppFrame appFrame = new AppFrame(cube, sphere, tetra);
		CubeController cubeController = new CubeController(appFrame, cube);
		SphereController sphereController = new SphereController(appFrame, sphere);
		TetrahedronController tetrahedronController = new TetrahedronController(appFrame, tetra);
		
	}
}
