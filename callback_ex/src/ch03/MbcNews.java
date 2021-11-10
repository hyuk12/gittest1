package ch03;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MbcNews implements WriteArticle {
	private String printDate() {
		DateFormat formater = new SimpleDateFormat("yyyy.MM.dd");
		return formater.format(Calendar.getInstance().getTime());
	}

	@Override
	public void printArticle(String article) {
		System.out.println("☆☆☆ MBC  뉴스입니다 ☆☆☆");
		System.out.println();
		System.out.println("오늘의 날씨입니다.");
		System.out.println();
		System.out.println(article);
		System.out.println(printDate() + " 일 날씨 정보입니다.");
		
	}

}
