package ch02;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainActivity extends JFrame implements CallBackbutton {
	int cnt;
	JLabel label;

	public MainActivity() {
		cnt = 0;
		label = new JLabel(cnt + "");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());
		add(label);
	}

	@Override
	public void clickedAddbutton() {
		System.out.println("더하기 버튼 눌려 졌습니다.");
		cnt++;
		label.setText(cnt + "");
	}

	@Override
	public void clickedMinusbutton() {
		System.out.println("빼기 버튼이 눌려 졌습니다.");
		cnt--;
		label.setText(cnt + "");

	}

	@Override
	public void passValue(int value) {

		System.out.println("value 값을 전달받음 : " + value);
		label.setText(value + "");
	}

}
