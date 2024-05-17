
public class Wheel {

	private double cost;
	private double radius;

	// Default constructor
	public Wheel() {
	}

	// Constructor to initialize the variables
	public Wheel(double radius) {
		this.radius = radius;
	}

	// Getters
	public double getCost() {
		return cost;
	}

	public double getRadius() {
		return radius;
	}

	// Setters
	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// method to calculate the cost
	public void calculateCost() {
		cost = 5 * radius * radius;
	}

}
