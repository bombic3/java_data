package chap04;

public class Test {

	public static void main(String[] args) {
		int num = 5;
		int sum = ++num + num++;

//		++num;
//		num++;
		// 다른 줄이면 상관없음 값 똑같음
		
		System.out.println("num="+num);
		System.out.println("sum="+sum);

	}

}
