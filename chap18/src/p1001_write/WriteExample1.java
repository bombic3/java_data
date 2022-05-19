package p1001_write;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample1 {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("c:/Temp/test.txt");
		byte[] data = "ABC".getBytes();
		for(int i=0; i<data.length; i++) {
			os.write(data[i]); // 1. os.write(); 쓰고 그 다음에 flush 필수
		}
		os.flush(); // 2. os.flush();
		os.close(); // 3. os.close();

	}

}
