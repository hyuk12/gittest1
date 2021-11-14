package ch03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest03 {
	public static void main(String[] args) {
		try (FileOutputStream fos = new FileOutputStream("output3.txt")) {

			byte[] bs = new byte[26];
			byte data = 65;// 'A'
			for (int i = 0; i < bs.length; i++) {
				bs[i] = data;
				data++;
			}
			fos.write(bs, 2, 10);// 배열 두번째부터 10개 바이트 출력하기

		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("출력이 완료 되었습니다.");
	}
}
