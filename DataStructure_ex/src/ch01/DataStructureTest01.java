package ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DataStructureTest01 {
	public static void main(String[] args) {

		List list0;
		// 순서가 있고 인덱스 중복이 가능하다
		ArrayList<Integer> list = new ArrayList();
		ArrayList<Integer> num = new ArrayList();
		
		//선언과 동시에 초기화
		ArrayList<Integer>list2 = new ArrayList<>(Arrays.asList(1,2,3));
		
		//값 추가방법
		list.add(3);//index 0
		list.add(null);//index 1
		list.add(1, 10);// index 1번째에 10을 삽입 (null 은 인덱스 2번으로 밀려난다)
		System.out.println("값 확인 : " + list);
		
		// 값 삭제 방법
		list.remove(2);
		System.out.println("값 삭제하기 : " + list);
		
		//한번에 다지우는거
//		list.clear();
//		System.out.println("값 삭제하기 : " + list);
		// 값 출력 방법
		
		System.out.println("값 출력 방법 : " + list.get(1));
		
		for (Integer i : list) {
			System.out.println("for 사용 방법 : " + i);
		}
		// while 사용방법
		// 요소 순회(반복자) 컬렉션 프레임 워크에 저장된 요소들을 하나씩 차례로 참조하는 것
		Iterator<Integer>iter = list.iterator();
		
		// true , false
		while(iter.hasNext()) {
			System.out.println("while 사용방법 : " + iter.next());
		}
		
		// 값 검색 방법.
		System.out.println(list.contains(1));
		System.out.println(list.contains(10));
		
		// 값이 있으면 인덱스의 번호를 반환, 없으면 -1을 반환하는 예약어
		System.out.println(list.indexOf(10));// 1번째 인덱스에 있다.
		System.out.println(list.indexOf(100));// 없으면 -1 반환
		System.out.println(list.indexOf(3));//0번째 인덱스에 있다.
		
		// 문제 1
		ArrayList<String>names = new ArrayList<String>();
		// 스캐너 사용
		Scanner sc = new Scanner(System.in);
		Iterator<Integer>iter2 = list.iterator();
		String str = sc.nextLine();
		while(iter2.hasNext()) {
			names.add(str);
			if(names.size() == 3) {
				System.out.println("이름은 "+ names);
			}
			break;
		}
		
		
		//이름 값을 입력하여서 names 리스트에 저장 while
		// 화면에 입력한 이름을 뿌려달라
		
	}

}
