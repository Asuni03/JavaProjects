
public class Match {
	private double caloriePerSet;
	private int numSets;

	public Match() {

	}

	public Match(double caloriePerSet, int numSets) {
		this.caloriePerSet = caloriePerSet;
		this.numSets = numSets;
	}

	public double getCaloriePerSet() {
		return caloriePerSet;
	}

	public int getNumSets() {
		return numSets;
	}

	public void setCaloriePerSet(double caloriePerSet) {
		this.caloriePerSet = caloriePerSet;
	}

	public void setNumSets(int numSets) {
		this.numSets = numSets;
	}

}
