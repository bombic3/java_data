package car2_1_17_4;

import day.Day;

public class ExCarTester2 {
	public static void main(String[] args) {
		Car car1 = new ExCar("W221", 1845, 1490, 5205, 90.0,
								new Day(2015,12,24));
		car1.putSpec();	// 사양 표시

	}

}
