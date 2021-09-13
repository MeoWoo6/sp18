public class Planet {

	private static final double G = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;


	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		return Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos) + (yyPos-p.yyPos)*(yyPos-p.yyPos));
	}

	public double calcForceExertedBy(Planet p){
		double r = calcDistance(p);
		return G * mass * p.mass / (r * r);
	}

	public double calcForceExertedByX(Planet p){
		double r = calcDistance(p);
		double force = calcForceExertedBy(p);
		return force * (p.xxPos - xxPos) / r;
	}

	public double calcForceExertedByY(Planet p){
		double r = calcDistance(p);
		double force = calcForceExertedBy(p);
		return force * (p.yyPos - yyPos) / r;
	}

	public double calcNetForceExertedByX(Planet[] planets){
		double netfByX = 0;
		for(Planet p : planets){
			if(this.equals(p)){
				continue;
			}else{
				netfByX += calcForceExertedByX(p);
			}
		}
		return netfByX;
	}

	public double calcNetForceExertedByY(Planet[] planets){
		double netfByY = 0;
		for(Planet p : planets){
			if(this.equals(p)){
				continue;
			}else{
				netfByY += calcForceExertedByY(p);
			}
		}
		return netfByY;
	}

	public void update(double dt, double xForce, double yForce){
		double xAccel = xForce / mass;
		double yAccel = yForce/ mass;
		xxVel= xxVel + dt * xAccel;
		yyVel = yyVel + dt * yAccel;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "./images/" +imgFileName);
	}

}