package ch05;

class BankAccount {
	private int money = 0;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		if (money <= 0) {
			System.out.println("�߸��� �Է� �Դϴ�.");
		} else {
			this.money = money;
		}
	}

	public synchronized void saveMoney(int money) {
		int currentMoney = getMoney();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMoney(currentMoney + money);
		System.out.println("�Ա� �� �����ܾ�" + getMoney());
	}

	public synchronized void withDrawMoney(int money) {
		int currentMoney = getMoney();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMoney(currentMoney - money);
		System.out.println("��� �� �����ܾ�" + getMoney());
	}
}// end of BankAccount

class GrandParents extends Thread{
	BankAccount account;
	public GrandParents(BankAccount account) {
		this.account = account;
	}
	@Override
	public void run() {
		// �Ա� / ���
		account.saveMoney(50_000);
		account.withDrawMoney(15_000);
	}
}

class Parents extends Thread {
	BankAccount account;

	public Parents(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		// �Ա��ϱ�
		account.saveMoney(30_000);
	}
}

class Children extends Thread {

	BankAccount account;

	public Children(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.withDrawMoney(10_000);
	}
}

public class MainTest {
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		
		GrandParents grandParents = new GrandParents(account);
		Parents parents = new Parents(account);
		Children children = new Children(account);
		
		final int MONTH = 30;
		for (int i = 0; i < MONTH ; i++) {
			if(i == 30 ) {
				grandParents.start();
			}else if( i <10) {
				parents.start();
			}else if(i > 20) {
				children.start();
			}
		}
	}
	
}
