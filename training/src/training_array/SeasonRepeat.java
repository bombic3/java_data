package training_array;
// 입력한 달의 계절 표시
import java.util.Scanner;

public class SeasonRepeat {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int retry;
		System.out.println("계절을 찾습니다.");
		do {
			int month;	// 월 저장
			do {
				System.out.print("몇 월입니까? : ");
				month = stdIn.nextInt();
			} while (month < 1 || month > 12);
			
			if (month >= 3 && month <= 5)		// 3,4,5월
				System.out.println("봄입니다.");
			else if (month >= 6 && month <= 8)	// 6,7,8월
				System.out.println("여름입니다.");
			else if (month >= 9 && month <= 11)	// 9,10,11월
				System.out.println("가을입니다.");
			else if (month == 12 || month == 1 || month == 2) // 12,1,2월
				System.out.println("겨울입니다.");
			
			System.out.print("다시 하겠습니까? 1-Yes / 0-No : ");
			retry = stdIn.nextInt();
		} while (retry == 1);

	}

}
