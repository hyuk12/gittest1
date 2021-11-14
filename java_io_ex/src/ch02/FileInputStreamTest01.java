package ch02;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest01 {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("assets/input.txt");
//			int first = fis.read();
//			System.out.println(first);
			for (int i = 0; i < 6; i++) {
				System.out.println((char)fis.read());
			}
			
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("프로그램이 종료되지 않았습니다.");
	}
}
