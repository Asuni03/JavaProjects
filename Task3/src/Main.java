import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Making the scanner object
		Scanner obj = new Scanner(System.in);
		
		//Initializing the variable
		long climbUp;
		long climbDown;
		long treeHeight;
		
		
		System.out.print("Enter the climb up height: ");
		climbUp = obj.nextLong();
		
		System.out.print("Enter the slide down height: ");
		climbDown =  obj.nextLong();
		
		System.out.print("Enter the tree height: ");
		treeHeight = obj.nextLong();
		
		//calling the function
		calculateDays(climbUp, climbDown, treeHeight);
	}
	
	static void calculateDays(long climbUp, long climbDown, long treeHeight){
		//The minimum day must be day 1
		int days = 1;
		//Calculating the net climb
		long netClimb = climbUp - climbDown;
		
		//while the climb up is lower than the tree height, the program will continue to run and add the climb up value with the net climb
		while (climbUp < treeHeight) {
				climbUp += netClimb; 
				days++;
		}
		//Just printing all the function
		System.out.printf("It takes %d days for the snail to climb %d meters tree",days,treeHeight);	
	}

}


