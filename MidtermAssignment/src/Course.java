
public class Course {
	private double caloriePerDistance;
	private double distance;

	// Default constructor
	public Course() {
	}

	// Overloaded constructor
	public Course(double caloriePerDistance, double distance) {
		this.caloriePerDistance = caloriePerDistance;
		this.distance = distance;
	}

	public double getCaloriePerDistance() {
		return caloriePerDistance;
	}

	public double getDistance() {
		return distance;
	}

	public void setCaloriePerDistance(double caloriePerDistance) {
		this.caloriePerDistance = caloriePerDistance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
