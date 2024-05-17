
public class SUV extends Vehicle {

	Engine engine;
	Wheel wheel;

	// Default constructor
	public SUV() {

	}

	// Constructor initilizing all the variables
	public SUV(Engine engine, Wheel wheel) {
		this.engine = engine;
		this.wheel = wheel;
	}

	// Getters
	public Engine getEngine() {
		return engine;
	}

	public Wheel getWheel() {
		return wheel;
	}

	// Setters
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	@Override
	public void calculateCost() {
		super.setCost(engine.getCost() + wheel.getCost() * 4);
	}

}
