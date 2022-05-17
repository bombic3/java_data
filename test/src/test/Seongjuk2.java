package test;

public class Seongjuk2 {

	public static void main(String[] args) {
		
		String hakName[] = {"말자","영자","순자","공자","맹자"};
		int hakGug[] = { 40, 74, 90, 60, 83};
		int hakEng[] = { 35, 72, 95, 65, 82};
		int hakMat[] = { 50, 70, 92, 62, 81};
		int hakSum[] = new int[5];
		int hakRank[] = new int[5];
		double hakAvg[] = new double[5];
		int hakGrade;
		char myGrade[] = new char[5];
		
		
		System.out.println("                  성   적  표");
		System.out.println("======================================================");
		System.out.println(" 번호   이름   국어   영어   수학   총점   평균   학점   등수 ");
		System.out.println("------------------------------------------------------");
		
		for(int i=0 ; i<hakGug.length; i++) {
			

			hakSum[i] = hakGug[i] + hakEng[i] + +hakMat[i];
			hakAvg[i] = (double)hakSum[i]/3;
			
			hakGrade = (int)hakAvg[i]/10;
			
			switch(hakGrade)
			{
			case 10:
			case 9:
				myGrade[i] = 'A';
				break;
			case 8:
				myGrade[i] = 'B';
				break;
			case 7:
				myGrade[i] = 'C';
				break;
			case 6:
				myGrade[i] = 'D';
				break;
			default:
				myGrade[i] = 'F';
			}
		}
		
	    for(int i=0; i<hakGug.length;i++) {
        	hakRank[i] = 1;
        	for(int j=0; j<hakGug.length;j++) {
        		if(hakSum[i] < hakSum[j])      			
        			hakRank[i] += 1;
        	}	
        }
		
	    for(int i=0 ; i<hakGug.length; i++) {
	    	System.out.print(i+1 +"  "+ hakName[i] +"\t"+hakGug[i] +"\t"+hakEng[i] 
					+"\t"+hakMat[i]+"\t"+hakSum[i]+"\t");
			System.out.printf("%.1f", hakAvg[i]);
			System.out.print("\t" + myGrade[i] + "\t" + hakRank[i]);
			System.out.println();
	    }
	}

}
