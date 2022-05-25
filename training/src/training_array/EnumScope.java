package training_array;
import java.util.Scanner;

class EnumScope {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("정수 A:"); int a = stdIn.nextInt();
		System.out.print("정수 B:"); int b = stdIn.nextInt();
		if(a > b) {
			int t = a; // t 또는 temp (temporarily) - 임시로 쓰는 변수명)
			a = b;
			b = t;
		}			//  a가 b보다 크면 두 수를 교환
		do {
			System.out.print(a + " ");
			a = a +1;
		} while (a <= b);
		System.out.println();
	}
}