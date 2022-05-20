package p1020_file;
// C:/Temp 디렉토리에 Dir 디렉토리와 file1.txt, file2.txt, file3.txt 파일생성 후 실행 
import java.io.File;
import java.net.URI;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileExample {

	public static void main(String[] args) throws Exception {
		File dir = new File("C:/Temp/Dir");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = new File(new URI("file:///C:/Temp/file3.txt"));
							// 파일 경로를 URI 객체로 생성해서 매개값으로 제공해도 됨
		if(dir.exists() == false) { dir.mkdirs(); }
		if(file1.exists() == false) { file1.createNewFile(); }
		if(file2.exists() == false) { file2.createNewFile(); }
		if(file3.exists() == false) { file3.createNewFile(); }
		
		File temp = new File("C:/Temp");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd\ta\tHH:mm");
		File[] contents = temp.listFiles();
		System.out.println("날짜\t\t시간\t\t형태\t\t크기\t이름");
		System.out.println("-------------------------------------------------------------------");
		for(File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
			}
			System.out.println();
		}

	}

}
