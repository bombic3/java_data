package test;

public class Seongjuk {

	public static void main(String[] args) {
		int num[] = {1, 2, 3, 4, 5};
		String list[] = {"번호", "이름", "주소", "국어점수", "영어점수", "수학점수", "총점", "평균", "학점", "순위"};
		String name[] = {"김일번", "김이번", "김삼번", "김사번", "김오번"};
		String adr[] = {"안산", "서울", "인천", "군포", "거제도"};
		int kuk[] = {20, 75, 40, 60, 85};
		int eng[] = {10, 70, 50, 60, 85};
		int mat[] = {20, 78, 55, 65, 90};
		int sum[] = new int[5];
		int avg[] = new int[5];
		char Grade[] = new char[5];
		int myRank[] = new int[5];
		
		// 내용
		for(int i=0; i<num.length; i++) {
			//총점
			sum[i] = kuk[i]+eng[i]+mat[i];
			//평균
			avg[i] = sum[i]/3;
			//학점
			char myGrade = 'F';
			if (sum[i] >= 250 )
				myGrade = 'A';
			else if (sum[i] >= 200 )
				myGrade = 'B';
			else if (sum[i] >= 150)
				myGrade = 'C';
			else if (sum[i] >= 80)
				myGrade = 'D';
			else
				myGrade = 'F';
			Grade[i] = myGrade;
		}
		//순위
		for (int i=0; i<sum.length; i++) {
			myRank[i] = 1;
			for(int j=0; j<sum.length; j++)
				if(sum[i] < sum[j])
					myRank[i] += 1;
		}
		
		// 목차
		for(int i=0; i<list.length; i++) {
			System.out.print(list[i] + "\t");
		}
		System.out.println();
		//출력
		for(int i=0; i<num.length; i++) {
			System.out.println
			(num[i] + "\t" + name[i] + "\t" + adr[i] + "\t" + kuk[i]
					+ "\t" + eng[i] + "\t" + mat[i] + "\t" + sum[i]
					+ "\t" + avg[i] + "\t"  + Grade[i] + "\t" + myRank[i]);
		}
	
	}

}