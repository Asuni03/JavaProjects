import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Making scanner object
		Scanner obj = new Scanner(System.in);

		// Declaring the vehicles present
		Motorcycle motorcycle;
		SUV suv;
		Truck truck;

		// Declaring the engine instances
		ElectricEngine electricEngine;
		PetrolEngine petrolEngine;

		// Declaring the wheel instance
		Wheel wheel;

		// Declaring variables to be used
		int vehicleChoice;
		int engineChoice;
		double batteryCapacity;
		int batteryNum;

		// User prompt
		System.out.print("Choose vehicle type:\n"
				+ "1: Motorcycle\n"
				+ "2: SUV\n"
				+ "3: Truck\n" 
				+ "Vehicle type > ");
		vehicleChoice = obj.nextInt();

		System.out.print("Choose engine type:\n"
				+ "1: Electric Engine\n"
				+ "2: Petrol Engine\n"
				+ "Engine type > ");
		engineChoice = obj.nextInt();

		if (engineChoice == 1) {
			// making an electric engine
			System.out.print("You choosed electric engine\n"
			+ "Battery capacity: ");
			batteryCapacity = obj.nextDouble();
			System.out.print("Number of battery: ");
			batteryNum = obj.nextInt();
			electricEngine = new ElectricEngine(batteryCapacity, batteryNum);
			
			//Set the cost of an electric enginne
			electricEngine.calculateCost();

			// Making the wheels
			System.out.print("Wheel radius: ");
			wheel = new Wheel(obj.nextDouble());
			// Set the cost of wheel
			wheel.calculateCost();

			switch (vehicleChoice) {
			case 1:
				// making the motorcycle with electric engine and wheel
				motorcycle = new Motorcycle(electricEngine, wheel);
				// Set the cost for the motorcycle
				motorcycle.calculateCost();
				System.out.printf("Total cost is %.2f", motorcycle.getCost());
				break;

			case 2:
				// Making the suv with electric engine and wheel
				suv = new SUV(electricEngine, wheel);
				// Set the cost for the suv
				suv.calculateCost();
				System.out.printf("Total cost is %.2f", suv.getCost());
				break;

			case 3:
				// Making the truck with electric engine and wheel
				truck = new Truck(electricEngine, wheel);
				// Set the cost for the truck
				truck.calculateCost();
				System.out.printf("Total cost is %.2f", truck.getCost());
				break;
			}

		} else {
			// Making a petrol engine
			System.out.print("You choosed petrol engine\n" + "Fuel capacity: ");
			petrolEngine = new PetrolEngine(obj.nextDouble());
			petrolEngine.calculateCost();
			// Making the wheels
			System.out.print("Wheel radius: ");
			wheel = new Wheel(obj.nextDouble());
			wheel.calculateCost();

			switch (vehicleChoice) {
			case 1:
				motorcycle = new Motorcycle(petrolEngine, wheel);
				motorcycle.calculateCost();
				System.out.printf("Total cost is %.2f", motorcycle.getCost());
				break;

			case 2:
				suv = new SUV(petrolEngine, wheel);
				suv.calculateCost();
				System.out.printf("Total cost is %.2f", suv.getCost());
				break;

			case 3:
				truck = new Truck(petrolEngine, wheel);
				truck.calculateCost();
				System.out.printf("Total cost is %.2f", truck.getCost());
				break;
			}
		}

	}
}
