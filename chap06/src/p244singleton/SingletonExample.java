package p244singleton;

public class SingletonExample {
	
	public static void main(String[] args) {
//		Singleton obj1 = new Singleton();
//		Singleton obj2 = new Singleton();
		// 컴파일 에러 -> static은 항상 존재하기 때문에 new 생성 필요없음

		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		// 두개 다 한 메모리 주소 참조 결국 하나인 것
		
		if(obj1 == obj2) {
			System.out.println("같은 Singleton 객체 입니다.");
		} else {
			System.out.println("다른 Singleton 객체 입니다.");
		}
	}

}
