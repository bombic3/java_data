package p434_trycatchfinally;

public class CatchByExceptionKindExample {

	public static void main(String[] args) {
//		try {
//			String data1 = args[0];
//			String data2 = args[1];
//			int value1 = Integer.parseInt(data1);
//			int value2 = Integer.parseInt(data2);
//			int result = value1 + value2;
//			System.out.println(data1 + "+" + data2 + "=" + result);
//		} catch ( ArrayIndexOutOfBoundsException e) {
//			System.out.println("실행 매개값의 수가 부족합니다.");
//			System.out.println("[실행 방법]");
//			System.out.println("java CatchByExceptionKindExample  num1  num2");
//		} catch ( NumberFormatException e) {
//			System.out.println("숫자로 변환할 수 없습니다.");
//		} catch ( Exception e) { // Exception은 최상위 가장 넓은 경우이므로 맨 마지막에 적기
//			System.out.println("황당~ 숫자 두 개 넣으라니까요");
//		} finally {
//			System.out.println("다시 실행하세요.");
//		}

		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "=" + result);
			
			// 멀티 catch
		} catch ( ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("실행 매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
			System.out.println("[실행 방법]");
			System.out.println("java CatchByExceptionKindExample  num1  num2");
		} catch ( Exception e) { // Exception은 최상위 가장 넓은 경우이므로 맨 마지막에 적기
			System.out.println("황당~ 숫자 두 개 넣으라니까요");
		} finally {
			System.out.println("다시 실행하세요.");
		}
	}

}
