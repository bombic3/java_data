package training;

import java.util.Scanner;

public class LinearSearchTop {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요소 수 : ");
		int n = stdIn.nextInt();		// 요소 수 입력
		int[] a = new int[n];			// 배열 생성
		
		for (int j=0; j<n; j++) {
			System.out.print("a[" + j + "] = ");
			a[j] = stdIn.nextInt();
		}
		
		System.out.print("찿을 숫자 : ");
		int key = stdIn.nextInt();
		
		int i;
		for (i=0; i<n; i++)
			if (a[i] == key)
				break;
		
		if (i<n)
			System.out.println("그 값은 a[" + i + "]에 있습니다.");
		else
			System.out.println("해당 값이 존재하지 않습니다.");
	}

}