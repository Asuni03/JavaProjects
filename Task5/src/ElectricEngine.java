
public class ElectricEngine extends Engine {

	private double batteryCapacity;
	private int batteryNum;

	// Default Constructor
	public ElectricEngine() {

	}

	// Constructor initializing all the variables
	public ElectricEngine(double batteryCapacity, int batteryNum) {
		this.batteryCapacity = batteryCapacity;
		this.batteryNum = batteryNum;
	}

	// Getters
	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	public int getBatteryNum() {
		return batteryNum;
	}

	// Setters
	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public void setBatteryNum(int batteryNum) {
		this.batteryNum = batteryNum;
	}

	@Override
	public void calculateCost() {
		super.setCost(batteryCapacity * 20 * batteryNum);
	}

}
