package ch01;

import java.io.IOException;
import java.io.InputStreamReader;

public class SysteminTest012 {
	
	public static void main(String[] args) {
		
		System.out.println("���ĺ� ������ ���� Enter�� ��������");
		
		int i ;
		try {
			//����Ʈ�� ���ڷ� �������ִ� �༮
			//����Ʈ ������ ���� �༮�� ���� ������ �о��ִ� �༮
			// --> ���� ��Ʈ��
			InputStreamReader irs = new InputStreamReader(System.in);
			
			while((i = irs.read()) != '\n') {
				System.out.print((char)i);
			}
//			while( ( i = System.in.read() ) != '\n') {
//				System.out.print((char)i);
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
