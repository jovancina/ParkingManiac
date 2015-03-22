package gui;

public class Car {
	private double x, y, heading, steeringAngle;

	private double wheelBase, width, length;
	
	public Car() {
		this(0, 0);
	}
	
	public Car(double startX, double startY) {
		this(0, 0, 0);
	}
	
	public Car(double startX, double startY, double heading) {
		// I guess I will need the complex shape for this...
		this.x = startX;
		this.y = startY;
		this.heading = heading;
		this.wheelBase = 2.6;
		this.length = 4.2;
		this.width = 1.74;
	}
	
}
