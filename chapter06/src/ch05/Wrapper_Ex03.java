package ch05;

public class Wrapper_Ex03 {
	
	public static void main(String[] args) {
		String str = "10";
		String str2 = "10.5";
		String str3 = "true";
		
		byte b = Byte.parseByte(str);
		int i = Integer.parseInt(str);
		short s = Short.parseShort(str);
		long l = Long.parseLong(str);
		
		//
		float f = Float.parseFloat(str);
		double d = Double.parseDouble(str2);
		boolean bool = Boolean.parseBoolean(str3);
		System.out.println(bool);
		if(Boolean.parseBoolean(str3)) {
			System.out.println("boolean 형으로 변경완료!!!");
		}
		
		// 문제1 .
		String str10 = "1001";
		String str11 = "2001";
		int x = Integer.parseInt(str10);
		int y= Integer.parseInt(str11);
		int sum  = x + y;
		int p = x * y;
		System.out.println(sum + " " +p);
		System.out.println(f);
		
		System.out.println("문자열 byte값 변환 : " + b);
		
	}
}
