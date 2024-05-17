
public class Badminton extends Exercise {
	private Match match;
	private int numMatches;

	public Badminton() {
	}

	public Badminton(Match match) {
		this.match = match;
	}

	public Badminton(Match match, int numMatches) {
		this.match = match;
		this.numMatches = numMatches;
	}

	public Match getMatch() {
		return match;
	}

	public int getNumMatches() {
		return numMatches;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public void setNumMatches(int numMatches) {
		this.numMatches = numMatches;
	}

	@Override
	public void calculateCalories() {
		this.setConsumedCalories(this.numMatches * this.match.getCaloriePerSet() * this.match.getNumSets());

	}

	@Override
	public String toString() {
		String output = "Badminton\n" + "Consumed Calories: " + this.getConsumedCalories() + "kcal\n";
		return output;
	}

}
