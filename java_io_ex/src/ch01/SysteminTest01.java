package ch01;

import java.io.IOException;

public class SysteminTest01 {

		
	public static void main(String[] args) {
		
		System.out.println("���ĺ� �ϳ��� ���� Enter �� ��������");
		
		int i;
		
		try {
			i = System.in.read(); //�������� �Է��� ��ٸ��� ��ɾ�
			// ���
			System.out.println("�Է� ���� �� : " +  i);
			System.out.println("�Է� ���� �� : " +  (char)i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
