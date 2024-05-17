import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner obj = new Scanner(System.in);

		// Making object for stock 1 and 2
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();

		// Setting the seed, so that it will be different everytime the program is
		// executed
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());

		// Initilizing the min and max of the boundary
		// The minimum is -30% so it will
		double min = 0.7;
		double max = 1.3;
		double fluctRate1;
		double fluctRate2;

		// User Prompt
		System.out.print("Name of stock 1: ");
		stock1.setStockName(obj.next());
		System.out.print("Current price of stock 1: ");
		stock1.setInitialPrice(obj.nextDouble());
		stock1.setCurrentPrice(stock1.getInitialPrice());
		System.out.print("Name of stock 2: ");
		stock2.setStockName(obj.next());
		System.out.print("Current price of stock 2: ");
		stock2.setInitialPrice(obj.nextDouble());
		stock2.setCurrentPrice(stock2.getInitialPrice());
		System.out.printf("\n");

		// (max-min) * random.nextDouble() will scale up the range and by adding it to
		// the min will make it [0.7,1.3]
		for (int i = 1; i < 6; i++) {
			fluctRate1 = min + ((max - min) * random.nextDouble());
			fluctRate2 = min + ((max - min) * random.nextDouble());

			System.out.printf("After day %d\n", i);
			stock1.setCurrentPrice(stock1.calculatingCurrentPrice(fluctRate1));
			stock1.updateStockInfo(fluctRate1);
			stock2.setCurrentPrice(stock2.calculatingCurrentPrice(fluctRate2));
			stock2.updateStockInfo(fluctRate2);
			System.out.printf("\n");

		}

	}

}
