
public class PetrolEngine extends Engine {

	private double fuelCapacity;

	// Default constructor
	public PetrolEngine() {

	}

	// Constructor initializing the variables
	public PetrolEngine(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	// Getters
	public double getFuelCapacity() {
		return fuelCapacity;
	}

	// Setters
	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	@Override
	public void calculateCost() {
		super.setCost(100 * fuelCapacity);
	}

}
