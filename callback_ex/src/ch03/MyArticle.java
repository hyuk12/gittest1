package ch03;

import java.util.Scanner;

//�ݸ� ȣ����
public class MyArticle {
	
	String article;
	WriteArticle hackerArticle ;
	WriteArticle sbsArticle ;
	WriteArticle mbcArticle ;
	// �ּҰ� ����
	public MyArticle(WriteArticle hackerArticle, WriteArticle sbsArticle, WriteArticle mbcArticle) {
		
		this.hackerArticle = hackerArticle;
		this.sbsArticle = sbsArticle;
		this.mbcArticle = mbcArticle;
	}
	public void complete() {
		Scanner sc = new Scanner(System.in);
		article = sc.nextLine();
		sc.close();
		hackerArticle.printArticle(article);
		System.out.println("+++++++++++");
		sbsArticle.printArticle(article);
		System.out.println("+++++++++++");
		mbcArticle.printArticle(article);
	}
}
