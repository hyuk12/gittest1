package ch04;

public class MainTest {

	public static void main(String[] args) {
		Activity01 activity01 = new Activity01("����ȭ��");
		Activity02 activity02 = new Activity02("����ȭ��");
		
		activity02.setCallbackCheckPosition(activity01.callbackCheckPosition);
	}
}
