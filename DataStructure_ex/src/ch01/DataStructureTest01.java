package ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DataStructureTest01 {
	public static void main(String[] args) {

		List list0;
		// ������ �ְ� �ε��� �ߺ��� �����ϴ�
		ArrayList<Integer> list = new ArrayList();
		ArrayList<Integer> num = new ArrayList();
		
		//����� ���ÿ� �ʱ�ȭ
		ArrayList<Integer>list2 = new ArrayList<>(Arrays.asList(1,2,3));
		
		//�� �߰����
		list.add(3);//index 0
		list.add(null);//index 1
		list.add(1, 10);// index 1��°�� 10�� ���� (null �� �ε��� 2������ �з�����)
		System.out.println("�� Ȯ�� : " + list);
		
		// �� ���� ���
		list.remove(2);
		System.out.println("�� �����ϱ� : " + list);
		
		//�ѹ��� ������°�
//		list.clear();
//		System.out.println("�� �����ϱ� : " + list);
		// �� ��� ���
		
		System.out.println("�� ��� ��� : " + list.get(1));
		
		for (Integer i : list) {
			System.out.println("for ��� ��� : " + i);
		}
		// while �����
		// ��� ��ȸ(�ݺ���) �÷��� ������ ��ũ�� ����� ��ҵ��� �ϳ��� ���ʷ� �����ϴ� ��
		Iterator<Integer>iter = list.iterator();
		
		// true , false
		while(iter.hasNext()) {
			System.out.println("while ����� : " + iter.next());
		}
		
		// �� �˻� ���.
		System.out.println(list.contains(1));
		System.out.println(list.contains(10));
		
		// ���� ������ �ε����� ��ȣ�� ��ȯ, ������ -1�� ��ȯ�ϴ� �����
		System.out.println(list.indexOf(10));// 1��° �ε����� �ִ�.
		System.out.println(list.indexOf(100));// ������ -1 ��ȯ
		System.out.println(list.indexOf(3));//0��° �ε����� �ִ�.
		
		// ���� 1
		ArrayList<String>names = new ArrayList<String>();
		// ��ĳ�� ���
		Scanner sc = new Scanner(System.in);
		Iterator<Integer>iter2 = list.iterator();
		String str = sc.nextLine();
		while(iter2.hasNext()) {
			names.add(str);
			if(names.size() == 3) {
				System.out.println("�̸��� "+ names);
			}
			break;
		}
		
		
		//�̸� ���� �Է��Ͽ��� names ����Ʈ�� ���� while
		// ȭ�鿡 �Է��� �̸��� �ѷ��޶�
		
	}

}
