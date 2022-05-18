package p367_interface_car;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car(); // 클래스 사용
		
		myCar.run(); // roll() 실행
		
		// 인터페이스 필드 금호타이어로 변수 선언
		myCar.frontLeftTire = new KumhoTire();
		myCar.frontRightTire = new KumhoTire();
		
		myCar.run();

	}

}
