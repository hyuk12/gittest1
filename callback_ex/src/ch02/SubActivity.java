package ch02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class SubActivity extends JFrame implements ActionListener {
	JButton addButton;
	JButton minusButton;
	JButton passValueButton;
	
	CallBackbutton callbackButton;
	
	public SubActivity(CallBackbutton callbackButton) {
		this.callbackButton = callbackButton;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		
		 addButton = new JButton("더하기 버튼");
		 minusButton = new JButton("빼기 버튼");
		 passValueButton = new JButton("값 넣기 버튼");
		
		add(addButton);
		add(minusButton);
		add(passValueButton);
		
		addButton.addActionListener(this);
		minusButton.addActionListener(this);
		passValueButton.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetButton = (JButton)e.getSource();
		
		if(targetButton == addButton) {
			callbackButton.clickedAddbutton();
		}else if(targetButton == minusButton) {
			callbackButton.clickedMinusbutton();
		}else {
			callbackButton.passValue(10);
		}
		
	}

	

}
