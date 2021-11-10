package ch04;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Activity01 extends JFrame {

	String name;
	JPanel panel;
	// 인터페이스를 ..--> 익명 구현 객체 문법으로 사용할 수 있다.
	CallbackCheckPosition callbackCheckPosition = new CallbackCheckPosition() {

		@Override
		public void checkPosition(int x, int y) {
			System.out.println(name + " 콜백 받은 값 x : " + x);
			System.out.println(name + " 콜백 받은 값 y : " + y);
		}
	};
	public Activity01(String name) {
		this.name = name;
		setTitle(name);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		setVisible(true);
		add(panel);
		panel.setBackground(Color.blue);
	}
}
