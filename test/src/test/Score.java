package test;

public class Score {

	public static void main(String[] args) {
		int score = 65;
		char myGrade;
		
		switch(score/10) {
		case 10:
		case 9:
			myGrade = 'A';
			break;
		case 8:
			myGrade = 'B';
			break;
		case 7:
			myGrade = 'C';
			break;
		case 6:
			myGrade = 'D';
			break;
		default:
			myGrade = 'F';
		}
		
		System.out.println("학생의 학점은 " + myGrade + "학점 입니다.");
		

	}

}
