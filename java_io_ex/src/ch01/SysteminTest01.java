package ch01;

import java.io.IOException;

public class SysteminTest01 {

		
	public static void main(String[] args) {
		
		System.out.println("알파벳 하나를 쓰고 Enter 를 누르세요");
		
		int i;
		
		try {
			i = System.in.read(); //여러분의 입력을 기다리는 명령어
			// 출력
			System.out.println("입력 받은 값 : " +  i);
			System.out.println("입력 받은 값 : " +  (char)i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
