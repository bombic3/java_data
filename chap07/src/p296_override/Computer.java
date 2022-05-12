package p296_override;

public class Computer extends Calculator {
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
		// Math.PI : 원주율
	}
}
//원 면적을 구하는 함수 
//r : 반지름