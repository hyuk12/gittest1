package ch02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TelMangement {

	// ���Ա��
	public static void insert(HashMap<String, Phone> map) {
		Phone phone;

		String name, address, telephone;
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸� : >>>");
		name = sc.next();
		System.out.println("�ּ� : >>>");
		address = sc.next();
		System.out.println("��ȭ��ȣ : >>>");
		telephone = sc.next();

		phone = new Phone(name, address, telephone);

	}

	// �������
	public static void delete(HashMap<String, Phone> map) {
		String delName;
		Scanner sc = new Scanner(System.in);

		System.out.println("������ �̸� : >>>");
		delName = sc.next();
		if (map.containsKey(delName)) {
			map.remove(delName);
		} else {
			System.out.println("��� ���� ���� ����Դϴ�.");
		}

	}

	// ã��
	public static void search(HashMap<String, Phone> map) {
		// key �̸��� �Է� �޾Ƽ� ã�Ƽ� �����ּ���
		String searchName;
		Scanner sc = new Scanner(System.in);

		System.out.println("�̸� : >>>");
		searchName = sc.next();
		if (map.containsKey(searchName)) {
			System.out.println(searchName + " " + map.get(searchName).telePhone);
		} else {
			System.out.println("��ϵ��� ���� ����Դϴ�.");
		}

	}

	// ��ü����
	public static void showInfo(HashMap<String, Phone> map) {
		// ȭ�鿡 ��ü ������ �ѷ��ִ� ����� ������ּ���.

		Set<String> names = map.keySet();
		Iterator<String> it = names.iterator();

		while (it.hasNext()) {
			String name = it.next();
			Phone person = map.get(name);
			System.out.println(name + " " + person.telePhone);
		}

	}

	public static void main(String[] args) {

		HashMap<String, Phone> map = new HashMap<String, Phone>();
		// �ӽ� ������ ����� ����
//		map.put("ȫ�浿", new Phone("ȫ�浿","�λ��","010-1234-5678"));
		// �޼��� �̿��غ���
//		insert(map);

//		insert(map);
//		delete(map);
//		search(map);
//		showInfo(map);

		// ������ �帧 ����� ����

		int menu;
		System.out.println("---------------------");
		System.out.println("��ȭ��ȣ ���� ���α׷�");
		System.out.println("---------------------");

		

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("�߰� 0, ���� 1 , ã�� 2, ��ü���� 3, ���� 4");
			menu = sc.nextInt();
			switch (menu) {
			case 0:
				insert(map);
				
				break;
			case 1:
				delete(map);
				
				break;
			case 2:
				search(map);
				
				break;
			case 3:
				showInfo(map);
				break;
			case 4 :
				System.out.println("���� �Ǿ����ϴ�.");
				return;
			}
		}
	}
}
