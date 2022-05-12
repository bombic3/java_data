package test;

public class Static_ex {
	 public static void main(String[] args) { 
        Number number1 = new Number(); //첫번째 
        Number number2 = new Number(); //두번쨰 

        number1.num++; //클래스 필드 num을 1증가시킴(static) = 1, static이라 new 선언 안해도 됨
        number1.num2++; //인스턴스 필드 num2을 1증가시키려 했지만 값 못 넘어옴 불가

        //두번째 number의 클래스 필드 출력 (static) //출력값 1 
        System.out.println(number2.num); 
       //두번째 number의 인스턴스 필드 출력 //출력값 0 
       System.out.println(number2.num2);
	     } 
}
// static 출력 값은 1 static으로 선언되지 않은 인스턴스의 출력 값은 0이 나왔습니다.
// static은 메모리에 선언이 되어 있지만,
// 그렇지 않은 인스턴스는 객체를 생성할 때마다 메모리를 할당하기 때문에 그렇습니다.

// static 메소드를 생성하면 인스턴스 생성 없이 바로 호출이 가능합니다.