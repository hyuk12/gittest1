package ch01;

import java.util.Scanner;

public class Main01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		while (0 < a && b < 0) {
			System.out.println(a + b);
			a = sc.nextInt();
			b = sc.nextInt();
		}
		
	}
}
