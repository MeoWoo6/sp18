import java.util.Scanner;

public class NBody {

	public static double readRadius(String filename) {
		In in = new In(filename);
		in.readInt();
		return in.readDouble();
	}

	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int numOfPlanets = in.readInt();
		in.readDouble();
		Planet[] planets = new Planet[numOfPlanets];
		for (int i = 0; i < numOfPlanets; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return planets;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		int numOfPlanets = planets.length;
		double[] xForces = new double[numOfPlanets];
		double[] yForces = new double[numOfPlanets];
		
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.enableDoubleBuffering();
		
		for (double time = 0.0; time <= T; time += dt) {
			
			for (int i = 0; i < numOfPlanets; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for (int i = 0; i < numOfPlanets; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, "./images/starfield.jpg");
			
			for(Planet p : planets) {
				p.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);

		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            				planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  			planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   

		}
}