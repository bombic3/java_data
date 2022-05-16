package test;

public class TestAverage {

	public static void main(String[] args) {
		int h[] = {98, 70, 45, 60, 83};
		int sum = 0;
		double avg = 0;
		int max = 0;
		int min = 999;
		for(int i=0; i<h.length; i++) {
			sum += h[i];
			
			if(h[i] > max) max = h[i];
			if(h[i] < min) min = h[i];
		}
		
		avg = (double)sum / h.length;
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("최고점수 : " + max);
		System.out.println("최저점수 : " + min);
	}
}
