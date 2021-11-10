package ch01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//�ݹ� �޼��� : ���� ���̽��� �����Ѵ�.
interface CallbackBtnAction {
	public abstract void clickedAddBtn();
	public void clickedMinusBtn();
	public void clickedMultipleBtn();
	public void clickedDivisionBtn();
	public void passValue(int value);
}

// �ݹ�޴� ��ü : CallbackBtnAction �������̽��� �����ؼ� �޼��带 �����Ѵ�
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
		// �ݹ� �Ǿ����� �޼��� :
		System.out.println(this.getClass().getName() + " �� �ݹ� �޾ҽ��ϴ�.");
		count++;
		label.setText(count + "");
	}

	@Override
	public void clickedMinusBtn() {
		System.out.println( "���̳ʽ�  �ݹ� �޾ҽ��ϴ�.");
		count--;
		label.setText(count + "");
		
	}

	@Override
	public void clickedMultipleBtn() {
		System.out.println("���ϱ� �ݹ� �޾ҽ��ϴ�");
		count *= 2;
		label.setText(count +"");
		
	}

	@Override
	public void clickedDivisionBtn() {
		System.out.println("������ �ݹ� �޾ҽ��ϴ�");
		count /= 3;
		label.setText(count +"");
		
	}

	@Override
	public void passValue(int value) {
		System.out.println("value ���� ���޹��� : " + value);
		label.setText(value + "");
		
	}

}

// �ݸ� (ȣ����) : �ݹ� �޴� ��ü�� �ּҰ��� �˰� �־�� �޼��尡 ȣ�� �Ǿ��ٰ� �˸����ִ�.
class SubActivity extends JFrame implements ActionListener {
	JButton btnAdd;
	JButton btnMinus;
	JButton btnMultiple;
	JButton btnDivision;
	JButton btnPassValue;
	
	// ��� ������ �������ش�.
	CallbackBtnAction callbackBtnAction;

	//
	public SubActivity(CallbackBtnAction callbackBtnAction) {
		// �߿�!!
		
		this.callbackBtnAction = callbackBtnAction;

		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnAdd = new JButton("���ϱ� ��ư");
		btnMinus = new JButton("���� ��ư");
		btnMultiple = new JButton("���ϱ� ��ư");
		btnDivision = new JButton("������ ��ư");
		btnPassValue = new JButton("�� ���� ��ư");
		
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
		
		//��ư ����
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
