package ex01;

import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01 {

	public static void main(String[] args) {
		
		System.out.println("���ڸ� ������ ���� Enter ��������");
		
		int i ;
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			while((i = isr.read()) != '\n') {
				System.out.println("�Է� ���� ���� �� : " + i );
				System.out.print((char)i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
