package training_array;
import java.util.Scanner;	

public class MatrixProduct {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int [][] a = new int [4][3];		// 4행 3열의 행렬
		int [][] b = new int [3][4];		// 3행 4열의 행렬
		int [][] c = new int [4][4];		// a와 b의 곱을 저장하는 행렬
			
		System.out.println("행렬 a의 요소를 입력하세요.");
		for (int i = 0; i < 4; i++) {
		    for (int j = 0; j < 3; j++) {
			System.out.printf("a[%d][%d] :", i, j);
			a[i][j] = stdIn.nextInt();
	             }
		}
		System.out.println("행렬 b의 요소를 입력하세요.");
		for (int i = 0; i < 3; i++) {
		     for (int j = 0; j < 4; j++) {
		    	 System.out.printf("b[%d][%d] :", i, j);
		    	 b[i][j] = stdIn.nextInt();
	        }
	    }
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	        	c[i][j] = 0;
	        	
	        	System.out.println(c[i][j]);
	        	// c만 넣으면 c배열이 아닌 c의 메모리 위치를 출력함
	        	
			    for (int k = 0; k < 3; k++) {
			        c[i][j] += a[i][k] * b[k][j];
				}
		    }
		}
	    System.out.println("행렬 a와 b의 곱");
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++)
	        	System.out.printf("%5d", c[i][j]); // 전체 폭은 5이려, 정렬은 기본 우측정렬
	        	System.out.println();
		}
	}

}
