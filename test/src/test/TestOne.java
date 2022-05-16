package test;

public class TestOne {

	public static void main(String[] args) {
		int i = 0;
		
		while(true) {
			i++;
			
			if( i%5 != 0 ) continue; // 5의 배수만, 짝수만, 홀수만,,,
//			if( i%2 == 0 ) continue;
			if(i >= 10) break;
			
			System.out.println("i=" + i);
		}

	}

}
