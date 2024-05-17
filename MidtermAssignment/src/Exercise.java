
public abstract class Exercise implements CalorieInterface {
	private double consumedCalories;

	public double getConsumedCalories() {
		return consumedCalories;
	}

	public void setConsumedCalories(double consumedCalories) {
		this.consumedCalories = consumedCalories;
	}

	@Override
	public abstract void calculateCalories();
}
