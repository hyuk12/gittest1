package ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest05 {

	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("assets/input1.txt")){
			byte[] bs = new byte[10];
			fis.read(bs, 0, 5);
			for(byte b : bs) {
				System.out.print((char)b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
