package ex05;



public class AnonymouseTest1 {

	public static void main(String[] args) {
		Car fooCar = new Car() {
			
			
			public void run() {
				System.out.println("달려라!");
				
			}
			
			public void stop() {
				System.out.println("멈.. 멈춰..!");
				// TODO Auto-generated method stub
				
			}
			
		};
		
	
		fooCar.run();
		fooCar.stop();

	}

}
