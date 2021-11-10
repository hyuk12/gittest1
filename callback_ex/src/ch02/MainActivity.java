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
		System.out.println("���ϱ� ��ư ���� �����ϴ�.");
		cnt++;
		label.setText(cnt + "");
	}

	@Override
	public void clickedMinusbutton() {
		System.out.println("���� ��ư�� ���� �����ϴ�.");
		cnt--;
		label.setText(cnt + "");

	}

	@Override
	public void passValue(int value) {

		System.out.println("value ���� ���޹��� : " + value);
		label.setText(value + "");
	}

}
