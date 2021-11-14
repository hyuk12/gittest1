package ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest03 {

	public static void main(String[] args) {
		
//		try {
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		// 자바 jdk 9버전 이후부터 사용가능
		try(FileInputStream fis = new FileInputStream("assets/input1.txt")){
			int i;
			while((i = fis.read()) != -1) {
				System.out.print((char)i);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이없어요");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
