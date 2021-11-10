package ch01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//콜백 메서드 : 인터 페이스를 선언한다.
interface CallbackBtnAction {
	public abstract void clickedAddBtn();
	public void clickedMinusBtn();
	public void clickedMultipleBtn();
	public void clickedDivisionBtn();
	public void passValue(int value);
}

// 콜백받는 객체 : CallbackBtnAction 인터페이스를 구현해서 메서드를 정의한다
class MainActivity extends JFrame implements CallbackBtnAction {

	int count;
	JLabel label;

	public MainActivity() {
		count = 0;
		label = new JLabel(count + "");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		setLayout(new FlowLayout());
		add(label);
	}

	@Override
	public void clickedAddBtn() {
		// 콜백 되어지는 메서드 :
		System.out.println(this.getClass().getName() + " 이 콜백 받았습니다.");
		count++;
		label.setText(count + "");
	}

	@Override
	public void clickedMinusBtn() {
		System.out.println( "마이너스  콜백 받았습니다.");
		count--;
		label.setText(count + "");
		
	}

	@Override
	public void clickedMultipleBtn() {
		System.out.println("곱하기 콜백 받았습니다");
		count *= 2;
		label.setText(count +"");
		
	}

	@Override
	public void clickedDivisionBtn() {
		System.out.println("나누기 콜백 받았습니다");
		count /= 3;
		label.setText(count +"");
		
	}

	@Override
	public void passValue(int value) {
		System.out.println("value 값을 전달받음 : " + value);
		label.setText(value + "");
		
	}

}

// 콜리 (호출자) : 콜백 받는 객체에 주소값을 알고 있어야 메서드가 호출 되었다고 알릴수있다.
class SubActivity extends JFrame implements ActionListener {
	JButton btnAdd;
	JButton btnMinus;
	JButton btnMultiple;
	JButton btnDivision;
	JButton btnPassValue;
	
	// 멤버 변수로 선언해준다.
	CallbackBtnAction callbackBtnAction;

	//
	public SubActivity(CallbackBtnAction callbackBtnAction) {
		// 중요!!
		
		this.callbackBtnAction = callbackBtnAction;

		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnAdd = new JButton("더하기 버튼");
		btnMinus = new JButton("빼기 버튼");
		btnMultiple = new JButton("곱하기 버튼");
		btnDivision = new JButton("나누기 버튼");
		btnPassValue = new JButton("값 전달 버튼");
		
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		
		add(btnAdd);
		add(btnMinus);
		add(btnMultiple);
		add(btnDivision);
		add(btnPassValue);
		
		btnAdd.addActionListener(this);
		btnMinus.addActionListener(this);
		btnMultiple.addActionListener(this);
		btnDivision.addActionListener(this);
		btnPassValue.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//버튼 구분
		JButton targetBtn = (JButton)e.getSource();
		if(targetBtn == btnAdd) {
			callbackBtnAction.clickedAddBtn();
		}else if(targetBtn == btnMinus){
			callbackBtnAction.clickedMinusBtn();
		}else if(targetBtn == btnMultiple){
			callbackBtnAction.clickedMultipleBtn();
		}else if(targetBtn == btnDivision){
			callbackBtnAction.clickedDivisionBtn();
		}else {
			callbackBtnAction.passValue(10);
		}
		
		
	}
}

public class CallbackTest {

	public static void main(String[] args) {
		MainActivity mainActivity = new MainActivity();
		new SubActivity(mainActivity);
	}
}
