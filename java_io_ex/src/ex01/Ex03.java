package ex01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try (FileOutputStream fos = new FileOutputStream("ex1.txt")) {
			System.out.println("숫자를 입력해주세요 : (65~)");
			int num = sc.nextInt();
			byte[] bs = new byte[26];
			byte data =(byte) num;// 'A'
			for (int i = 0; i < bs.length; i++) {
				bs[i] = data;
				data++;
			}
			fos.write(bs, 1, 5);// 배열 첫번째부터 10개 바이트 출력하기

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
