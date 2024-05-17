
public class Swimming extends Exercise {

	private Course course;

	// Default constructor
	public Swimming() {
	}

	// Overloaded constructor
	public Swimming(Course course) {
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public void calculateCalories() {
		this.setConsumedCalories(this.course.getCaloriePerDistance() * this.course.getDistance());
	}

	@Override
	public String toString() {
		String output = "Swimming\n" + "Consumed Calories: " + this.getConsumedCalories() + "kcal\n";
		return output;
	}

}
