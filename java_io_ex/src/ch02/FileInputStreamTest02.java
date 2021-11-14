package ch02;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest02 {

	public static void main(String[] args) {
		
		FileInputStream fileInputStream = null;
		
		try {
			fileInputStream = new FileInputStream("input1.txt");
			int i;
		 // fis.read()  ---> -1 
			while( (i = fileInputStream.read() )!= -1) {
				System.out.println((char)i);
			}
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
			e.printStackTrace();
		}finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
