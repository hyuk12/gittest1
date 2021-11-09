package ch04;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MiniAmongUs extends JFrame implements ActionListener{
	BufferedImage backgroundImage;
	BufferedImage amongImage1;
	BufferedImage amongImage2;
	CustomJpanel customJpanel;
	
	BorderLayout borderLayout;
	JPanel bottomPanel;
	JButton btnStart;
	JButton btnStop;
	

	// thread 사용할 이미지
	int among1Xpoint = 0;
	int among1Ypoint = 370;

	int among2Xpoint = 200;
	int among2Ypoint = 200;
	
	boolean isOn = true;

	public MiniAmongUs() {
		initData();
		setInitLayout();
		addEventListener();
		
		Thread thread = new Thread(customJpanel);
		thread.start();
		
	}

	private void initData() {
		setTitle("어몽어스");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			backgroundImage = ImageIO.read(new File("background1.jpg"));
			amongImage1 = ImageIO.read(new File("among1.png"));
			amongImage2 = ImageIO.read(new File("among2.png"));

		} catch (IOException e) {
			System.err.println("파일이 없습니다.");
			System.exit(0);
			e.printStackTrace();
		}
		customJpanel = new CustomJpanel();
		borderLayout = new BorderLayout();
		bottomPanel = new JPanel();
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");
	}

	private void setInitLayout() {
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(borderLayout);
		
		this.add(customJpanel, borderLayout.CENTER);
		this.add(bottomPanel, borderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		bottomPanel.add(btnStart);
		bottomPanel.add(btnStop);

	}

	private void addEventListener() {
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();

				switch (code) {
				case KeyEvent.VK_UP:
					among2Ypoint -= 10;
					break;
				case KeyEvent.VK_DOWN:
					among2Ypoint += 10;
					break;
				case KeyEvent.VK_LEFT:
					among2Xpoint -= 10;
					break;
				case KeyEvent.VK_RIGHT:
					among2Xpoint += 10;
					break;
				}
				repaint();
			}// end of keyPressed
		});// end of addKeyListener
	}

	// 내부 클래스 만들기
	private class CustomJpanel extends JPanel implements Runnable {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, 600, 600, null);
			g.drawImage(amongImage1, among1Xpoint, among1Ypoint, 100, 100, null);
			g.drawImage(amongImage2, among2Xpoint, among2Ypoint, 100, 100, null);
			
		}

		@Override
		public void run() {
			boolean isRight = true;
			
			while (true) {
				if (isOn) {
					if (isRight) {
						among1Xpoint += 10;
					}else {
						among1Xpoint -= 10;
					}
					if(among1Xpoint == 400) {
						isRight = false;
					}
					if(among1Xpoint == 0) {
						isRight = true;
					}
					
					// 이미지 1과 이미지 2와 좌표값이 x, y 일치한다면 이미지 2를 없애라
					if((among1Xpoint == among2Xpoint) && (among1Ypoint == among2Ypoint)) {
						amongImage2 = null;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
				repaint();
			}// end of while
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼이 start, stop 구분
		JButton button = (JButton)e.getSource();
		if(button == btnStart) {
			System.out.println("시작버튼");
			isOn = true;
		}else {
			System.out.println("종료버튼");
			isOn = false;
		}
		
		
		// 변수를 새롭게 활용해서 while 멈추거나 다시 시작할 수 있게 코드 수정
		
	}
}

public class MainTest {
	// main start
	public static void main(String[] args) {
		new MiniAmongUs();
	}// end of main

}// end of class
