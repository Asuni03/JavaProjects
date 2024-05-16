
public class Student {

	//Making the variables
	private String studentName;
	private int studentID;
	private int[] quiz;
	private int totalScore;
	
	//This is a default constructor
	public Student() {}

	//This constructor accept an instance of its class
	public Student(Student student) {
		this.studentName = student.getStudentName();
		this.studentID = student.getStudentID();
		this.quiz = student.getQuiz();
	}

	//Getter
	public String getStudentName() {
		return studentName;
	}
	
	//Getter
	public int getStudentID() {
		return studentID;
	}
	
	//Getter
	public int[] getQuiz() {
		return quiz;
	}
	
	//Setter
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	//Setter
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	//Getter
	public int getTotalScore() {
		return totalScore;
	}

	//Setter
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	//Setter
	public void setQuiz(int[] quiz) {
		this.quiz = quiz;
	}
	
	//Function to calculate the sum of the quiz score
	void CalculateSum()
	{
		this.totalScore = this.quiz[0] + this.quiz[1] + this.quiz[2];
	}
}
