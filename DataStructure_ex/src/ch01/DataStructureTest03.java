package ch01;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class DataStructureTest03 {
	public static void main(String[] args) {
		
		Map map0;
		
		// key 와 value 구조로 데이터를 저장한다.
		
		HashMap<String, String> map1 = new HashMap<>();
		
		// null 값을 허용하지 않는다.
		Hashtable<String, String> map2 = new Hashtable<>();
		
		map1.put("A01", "김포공항정문");
		map1.put("A02", "김포공항후문");
		map1.put("A03", "김포공항로비");
		map1.put("B01", "인천공항정문");
		map1.put("B02", "인천공항후문");
		map1.put("B03", "인천공항로비");
		map1.put("C01", null);
		System.out.println(map1);
		
//		map2.put("D01", null);
//		System.out.println(map2);
		
		//값 출력방법
		System.out.println("------------");
		System.out.println(map1.get("A01"));
		System.out.println(map1.get("A02"));
		System.out.println(map1.get("A03"));

		//삭제방법
		System.out.println(map1.remove("C01"));
		System.out.println("------------");
		System.out.println(map1);
		
		//for 문 사용
		// java.util.Map.Entry
		for (Entry<String, String> entry : map1.entrySet()) {
			System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
			}
		System.out.println("============");
		
		for (String key : map1.keySet()) {
			System.out.println(key + " : " + map1.get(key));
		}
	}
}
