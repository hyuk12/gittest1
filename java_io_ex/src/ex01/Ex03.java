package ex01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try (FileOutputStream fos = new FileOutputStream("ex1.txt")) {
			System.out.println("���ڸ� �Է����ּ��� : (65~)");
			int num = sc.nextInt();
			byte[] bs = new byte[26];
			byte data =(byte) num;// 'A'
			for (int i = 0; i < bs.length; i++) {
				bs[i] = data;
				data++;
			}
			fos.write(bs, 1, 5);// �迭 ù��°���� 10�� ����Ʈ ����ϱ�

		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("����� �Ϸ� �Ǿ����ϴ�.");
	}
}
