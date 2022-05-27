package id2;

public class IdTester {
	public static void main(String[] args) {
		Id a = new Id();		// 식별 번호 1번
		Id b = new Id();		// 식별 번호 2번
		
		System.out.println("a의 식별번호:" + a.getId());
		System.out.println("b의 식별번호:" + b.getId());

		System.out.println("마지막으로 부여한 식별 번호 = " + Id.getMaxId());
		System.out.println("마지막으로 부여한 식별 번호 = " + a.getMaxId());
		System.out.println("마지막으로 부여한 식별 번호 = " + b.getMaxId());

	}

}
