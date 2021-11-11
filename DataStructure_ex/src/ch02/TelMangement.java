package ch02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TelMangement {

	// 삽입기능
	public static void insert(HashMap<String, Phone> map) {
		Phone phone;

		String name, address, telephone;
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 : >>>");
		name = sc.next();
		System.out.println("주소 : >>>");
		address = sc.next();
		System.out.println("전화번호 : >>>");
		telephone = sc.next();

		phone = new Phone(name, address, telephone);

	}

	// 삭제기능
	public static void delete(HashMap<String, Phone> map) {
		String delName;
		Scanner sc = new Scanner(System.in);

		System.out.println("삭제할 이름 : >>>");
		delName = sc.next();
		if (map.containsKey(delName)) {
			map.remove(delName);
		} else {
			System.out.println("등록 되지 않은 사람입니다.");
		}

	}

	// 찾기
	public static void search(HashMap<String, Phone> map) {
		// key 이름을 입력 받아서 찾아서 보여주세요
		String searchName;
		Scanner sc = new Scanner(System.in);

		System.out.println("이름 : >>>");
		searchName = sc.next();
		if (map.containsKey(searchName)) {
			System.out.println(searchName + " " + map.get(searchName).telePhone);
		} else {
			System.out.println("등록되지 않은 사람입니다.");
		}

	}

	// 전체보기
	public static void showInfo(HashMap<String, Phone> map) {
		// 화면에 전체 정보를 뿌려주는 기능을 만들어주세요.

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
		// 임시 데이터 만들어 놓기
//		map.put("홍길동", new Phone("홍길동","부산시","010-1234-5678"));
		// 메서드 이용해보기
//		insert(map);

//		insert(map);
//		delete(map);
//		search(map);
//		showInfo(map);

		// 실행의 흐름 만들어 보기

		int menu;
		System.out.println("---------------------");
		System.out.println("전화번호 관리 프로그램");
		System.out.println("---------------------");

		

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("추가 0, 삭제 1 , 찾기 2, 전체보기 3, 종료 4");
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
				System.out.println("종료 되었습니다.");
				return;
			}
		}
	}
}
