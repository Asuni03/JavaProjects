import java.util.Scanner;


public class Main {
	

	public static void main(String[] args) {
		
		
		System.out.println("This is from the macbook");
		
		
		
		//Made the scanner object
		Scanner obj = new Scanner(System.in);
		
		//Made 3 students
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		
		//This student object is used to copy to the actual student
		Student student = new Student();
		
		//Quiz one, quiz two and quiz 3
		int[] quizArray = new int[3];
		
		//Loop the array for three times to print all the questions
		for (int i = 1; i <= 3; i++) {
			System.out.printf("Enter student #%d's info \n", i);
			System.out.print("Name: ");
			//Set the student name
			student.setStudentName(obj.next());
			System.out.print("StudentID: ");
			//Set the student ID
			student.setStudentID(obj.nextInt());
			
			//Prompt about the score and put them inside of the array
			System.out.print("Quiz 1 score: ");
			quizArray[0] = obj.nextInt(); 
			System.out.print("Quiz 2 score: ");
			quizArray[1] = obj.nextInt();
			System.out.print("Quiz 3 score: ");
			quizArray[2] = obj.nextInt();
			
			//Set the quiz scores
			student.setQuiz(quizArray);
			
			
			//Here we are using the index from the for loop to distinguish student one, two and three
			//If its one then student one and so on
			if (i == 1) 
			{
				student1 = new Student(student);
				student1.CalculateSum();
			} 
			else if (i == 2)
			{
				student2 = new Student(student);
				student2.CalculateSum();
			} 
			else 
			{
				student3 = new Student(student);
				student3.CalculateSum();
			}
		}	
		
		
		//Outside of the for loop, this if-else statement will check which one of them out of three of them that manage to get the highest total scores
		if (student1.getTotalScore() > student2.getTotalScore() && student1.getTotalScore() > student3.getTotalScore()) {
			System.out.println("Student with highest total score is...");
			System.out.printf("%s(%d) with a total score of %d", student1.getStudentName(), student1.getStudentID(), student1.getTotalScore());
		}
		else if(student2.getTotalScore() > student1.getTotalScore() && student2.getTotalScore() > student3.getTotalScore())
		{
			System.out.println("Student with highest total score is...");
			System.out.printf("%s(%d) with a total score of %d", student2.getStudentName(), student2.getStudentID(), student2.getTotalScore());
		}
		else
		{
			System.out.println("Student with highest total score is...");
			System.out.printf("%s(%d) with a total score of %d", student3.getStudentName(), student3.getStudentID(), student3.getTotalScore());
		}
	}
}