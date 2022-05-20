package p1026_filereader;

import java.io.FileReader;

public class FileReaderExample {

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader(
				"D:\\bombi\\java_data\\chap18\\src\\p1020_file\\FileExample.java"
				);
		
		int readCharNo;
		char[] cbuf = new char[100];
		while ((readCharNo=fr.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.print(data);
		}
		fr.close();

	}

}
