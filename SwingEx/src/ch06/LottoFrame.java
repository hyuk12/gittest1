package ch06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoFrame extends JFrame implements ActionListener{

	JButton button;
	LottoPanel panel;
	LottoNumber lottoNumber;
	int[] lotto = new int[LottoNumber.LOTTO_NUM_SIZE];
	
	public LottoFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	private void initData() {
		setTitle("로또 번호 생성기");
		setSize(600, 400);
		button = new JButton("++ 로또번호 생성하기 ++");
		panel = new LottoPanel();
		lottoNumber = new LottoNumber();
	}
	private void setInitLayout() {
		setVisible(true);
		setBackground(Color.gray);
		add(button, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
	}
	private void addEventListener() {
		button.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//6자리 랜덤 숫자가 배열로 넘어온다.
		lotto = lottoNumber.getLottoNumber();
		repaint();
	}
	
	class LottoPanel extends JPanel{
		
		@Override
		public void paint(Graphics g) {
			Font font = new Font("궁서체", Font.BOLD, 20);
			g.setFont(font);
			
			if(lotto[0] == 0) {
				g.drawString("로또 버튼을 클릭하세요.",180, 180);
				return;
			}
			int xPoint = 150;
			for(int i = 0; i < lotto.length; i++) {
				g.drawString(lotto[i] + "", xPoint, 150);
				xPoint += 50;
			}
		}
	}
public static void main(String[] args) {
	new LottoFrame();
}
}
