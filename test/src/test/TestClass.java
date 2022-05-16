package test;

public class TestClass {

	public static void main(String[] args) {
		int h[] = {98, 70, 45, 60, 83};

		int myRank[] = new int[5]; 
		
		for (int i=0; i<h.length; i++) {
			myRank[i] = 1;
			for(int j=0; j<h.length; j++)
				if(h[i] < h[j])
					myRank[i] += 1;
		}
		
		for(int i=0; i<h.length; i++) {			
			System.out.println("점수 : " + h[i] + "\t" + "등수 : " + myRank[i]);
		}
		
	}

}
