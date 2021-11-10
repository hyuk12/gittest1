package ch04;

public class MainTest {

	public static void main(String[] args) {
		Activity01 activity01 = new Activity01("메인화면");
		Activity02 activity02 = new Activity02("서브화면");
		
		activity02.setCallbackCheckPosition(activity01.callbackCheckPosition);
	}
}
