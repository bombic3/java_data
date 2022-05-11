package p240static;

public class ClassName {
	//인스턴스 필드와 메소드
	int field1;
	void method1() {}
	
	//정적 필드와 메소드
	static int field2;
	static void method2() {}
	
	//정적 블록
	static {
//		field1 = 10;
//		method1();
		// 컴파일 에러 -> 
		field2 = 10;
		method2();
	}
	
	//정적 메소드
	static void Method3() {
//		this.field1 = 10;
//		this.method1();
		// 컴파일 에러
		field2 = 10;
		method2();
	}
}
// 정적 메소드, 정적 블록 선언 시 주의!
// 객체 없어도 실행되기 때문에 내부에 인스턴스 필드, 인스턴스 메소드 사용 불가!!
// 객체 자신을 참조하는 this 키워드 사용 불가!!