package ch02;

public class MainTest {

	public static void main(String[] args) {
		MainActivity mainActivity = new MainActivity();
		new SubActivity(mainActivity);
	}
}
