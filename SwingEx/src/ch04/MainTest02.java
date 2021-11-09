package ch04;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame01 extends JFrame {

	public MyFrame01() {

		setTitle("gif사용해보기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel textLabel = new JLabel("펭하 ~ 입니다.");
		ImageIcon img = new ImageIcon("img.gif");
		JLabel imgLabel = new JLabel(img);
		JLabel bottomTextLabel = new JLabel("연락하세요");
		
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
