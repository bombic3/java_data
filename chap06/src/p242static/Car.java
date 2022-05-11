package p242static;

public class Car {
	int speed;
	
	void run() {
		System.out.println(speed + "으로 달립니다.");
	}

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.speed = 60;
		myCar.run();

	}

}
//메인함수는 시작부터 끝까지 유지돼야 되기 때문에 한 블럭에 있더라도 static 사용해야 함