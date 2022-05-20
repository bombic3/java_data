package p1022_fileinput;

import java.io.FileInputStream;

public class FileInputStreamExample {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\bombi\\java_data\\test\\src\\test\\PointClass.java"
					); // 해당 파일 우클릭 Properties에서 location 경로 복사하기
			int data;
			while ( (data = fis.read()) != -1) {
				System.out.write(data);
				
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
