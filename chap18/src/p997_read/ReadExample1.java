package p997_read;
// int로 read
import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample1 {

	public static void main(String[] args) throws Exception{ // 열기

		InputStream is = new FileInputStream("c:/temp/test.txt"); // 경로
		
		int readByte;
		
		while(true) {
			readByte = is.read();
			
			if(readByte == -1) break;
			System.out.print((char)readByte);
		}
		is.close(); // 닫기 - 꼭 닫아주기
	}

}