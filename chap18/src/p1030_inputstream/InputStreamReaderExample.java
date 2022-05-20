package p1030_inputstream;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
// 콘솔에서 입력한 한글을 Reader를 이용해서 읽고, 다시 콘솔로 출력
public class InputStreamReaderExample {

	public static void main(String[] args) throws Exception {
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		
		int readCharNo;
		char[] cbuf = new char[100];
		while ((readCharNo=reader.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.println(data);
		}
		reader.close();
		is.close();
	}

}
