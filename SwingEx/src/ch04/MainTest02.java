package ch04;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame01 extends JFrame {

	public MyFrame01() {

		setTitle("gif����غ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel textLabel = new JLabel("���� ~ �Դϴ�.");
		ImageIcon img = new ImageIcon("img.gif");
		JLabel imgLabel = new JLabel(img);
		JLabel bottomTextLabel = new JLabel("�����ϼ���");
		
		c.add(textLabel);
		c.add(imgLabel);
		c.add(bottomTextLabel);
		
		setSize(500, 500);
		setVisible(true);
	}
}

public class MainTest02 {

	public static void main(String[] args) {
		new MyFrame01();
	}
}
