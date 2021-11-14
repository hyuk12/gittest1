package ex01;

import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01 {

	public static void main(String[] args) {
		
		System.out.println("문자를 여러개 쓰고 Enter 누르세요");
		
		int i ;
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			while((i = isr.read()) != '\n') {
				System.out.println("입력 받은 문자 값 : " + i );
				System.out.print((char)i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
