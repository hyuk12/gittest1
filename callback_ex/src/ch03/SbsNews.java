package ch03;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SbsNews implements  WriteArticle{

	private String printDate() {
		DateFormat formater = new SimpleDateFormat("yyyy.MM.dd");
		return formater.format(Calendar.getInstance().getTime());
	}

	@Override
	public void printArticle(String article) {
		System.out.println("☆☆☆정직한 SBS 뉴스입니다☆☆☆");
		System.out.println();
		System.out.println("오늘의 뉴스입니다.");
		System.out.println();
		System.out.println(article);
		System.out.println(printDate() + " 일 뉴스입니다.");
		
		
	}
}
