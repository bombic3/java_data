package training;
import java.util.Scanner;

public class CountDown {

	public static void main(String[] args) {
	    Scanner stdln = new Scanner(System.in);
	    System.out.println("카운트다운 합니다.");
	    int x;
	    do {
	        System.out.print("양의 정숫값:");
		      x = stdln.nextInt();
	    } while (x <= 0);
	    //do문 종료 시 x는 반드시 양의 값이 된다.
			
	    // while문
	    while (x >=0)
		    System.out.println(x--);
		    System.out.println("x의 값이" + x + "이 됐습니다.");
	   }

}
