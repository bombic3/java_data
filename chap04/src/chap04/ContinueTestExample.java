package chap04;

public class ContinueTestExample {

	public static void main(String[] args) {
		for(int i=0; i<=50; i++) {
			if(i%5 != 0) {
				continue;
			}
			
		if(i != 0) {
			System.out.println(i);
			}
		
		}
		

	}

}
