package test;

public class TestString {

	public static void main(String[] args) {
		int num[] = {1, 2, 3, 4, 5};
		String list[] = {"번호", "이름", "국어점수", "영어점수", "수학점수", "총점", "학점", "주소"};
		String name[] = {"김일번", "김이번", "김삼번", "김사번", "김오번"};
		String adr[] = {"안산", "서울", "인천", "안양", "거제도"};
		int kuk[] = {1, 2, 3, 4, 5};
		int eng[] = {1, 2, 3, 4, 5};
		int mat[] = {1, 2, 3, 4, 5};
		
		for(int i=0; i<list.length; i++) {
		System.out.print(list[i] + "\t");
		}
		System.out.println();
		
		
		
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i] + "\t" + name[i]
					+ "\t" + kuk[i] + "\t" + eng[i] + "\t" + mat[i]
							+ "\t" + adr[i]);
		}
	}

}
