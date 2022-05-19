package p1008_write_string;

import java.io.FileWriter;
import java.io.Writer;

public class WriterExample3 {

	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("c:/Temp/test.txt");
		char[] data = "안녕 자바 프로그램".toCharArray();
		writer.write(data, 3, 2);
		writer.flush();
		writer.close();

	}

}
