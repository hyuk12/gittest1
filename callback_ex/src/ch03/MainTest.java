package ch03;

public class MainTest {

	public static void main(String[] args) {
		HackerNews hackerNews = new HackerNews();
		
//		//��� �ۼ�
//		MyArticle article = new MyArticle(hackerNews);
//		article.complete();
		SbsNews sbsNews = new SbsNews();
		MbcNews mbcNews = new MbcNews();
		MyArticle article = new MyArticle(hackerNews,sbsNews,mbcNews);
		
		article.complete();
	}
}
