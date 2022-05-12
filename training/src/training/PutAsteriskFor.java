package training;

import java.util.Scanner;

// 읽은 개수만큼 *표시
public class PutAsteriskFor {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("몇 개의 *를 표시할까요? : ");
		int n = stdIn.nextInt();
		// stdIn(Scanner클래스의) 메소드 중에 정수를 입력받고 n변수에 값을 넣는다
		if(n > 0) {
			for(int i=0; i<n; i++) 
				System.out.print('*');
//			System.out.println();
			
		}
	}

}
