package p997_read;
// 배열로 read - 반복횟수가 적어서 이게 더 좋은 것
import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample2 {

	public static void main(String[] args) throws Exception { // IOException
		InputStream is = new FileInputStream("c:/Temp/test.txt");
		int readByteNo;
		byte[]readBytes = new byte[3];
		String data = "";
		while (true) {
			readByteNo = is.read(readBytes);
			if (readByteNo == -1) break; 
				data += new String(readBytes, 0, readByteNo);
		}
		System.out.println(data);
		is.close();
		
	}

}
