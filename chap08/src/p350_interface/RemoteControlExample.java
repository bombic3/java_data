package p350_interface;

public class RemoteControlExample {
	// 익명구현 클래스
	/*
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl() {
		
			public void turnOn() {
				// 실행문
			}
			public void turnOff() {
				// 실행문
			}
			public void setVolume(int volume) {
				// 실행문
			}
		};

	}
	*/
	public static void main(String[] args) {
		RemoteControl rc = null; // 인터페이스 변수 선언
		
		// 인터페이스는 이름이 없어서 익명객체
		rc = new Television(); // Television 객체를 인터페이스타입에 대입
		rc.turnOn();
		rc.turnOff();
		// 인터페이스의 turnOn(),turnOff() 호출
		
		rc = new Audio(); // Audio 객체를 인터페이스타입에 대입
		rc.turnOn();
		rc.turnOff();
		// 인터페이스의 turnOn(),turnOff() 호출
	}
}
