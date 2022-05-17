package test;

public class TestString {

	public static void main(String[] args) {
		int num[] = {1, 2, 3, 4, 5};
		String name[] = {"김일번", "김이번", "김삼번", "김사번", "김오번"};
		String adr[] = {"안산", "서울", "인천", "안양", "거제도"};
		
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i] + "\t" + name[i] + "\t" + adr[i]);
		}
	}

}