package ch04;

class BankAccount {
	private int money = 100_000;

	// getter
	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		if (money <= 0) {
			System.out.println("�߸��� �Է� �Դϴ�.");
		} else {
			this.money = money;
		}
	}

	// �Աݱ��
	public  void saveMoney(int money) {
		// 10���� ����
		synchronized (this) {
			int currentMoney = getMoney();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setMoney(currentMoney + money);
			System.out.println("�Ա� �� ���� �ܾ�" + getMoney());
		}
	}

	// ��ݱ��
	public synchronized void withdrawMoney(int money) {
		int currentMoney = getMoney();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ����� �ڵ�
		// Todo
		// ���� �ݾ׺��� ����Ϸ��� �ݾ� ũ�� ��ݾȵǰ� ����
		setMoney(currentMoney - money);
		System.out.println("��� �� ���� �ܾ�" + getMoney());
	}
}

class Father extends Thread {
	BankAccount account;

	public Father(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		// �Ա� �ϱ�
		account.saveMoney(10_000);
	}
}

class Mather extends Thread {
	BankAccount account;

	public Mather(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.withdrawMoney(5_000);
	}
}

public class SharedResource {

	public static void main(String[] args) {
		
		// ���� 10���� ���� �Ǿ� �ִ� ���·� ��ü ����
		BankAccount account = new BankAccount();
		Father father = new Father(account);
		Mather mather = new Mather(account);
		
		// �ƹ����� �Ա��ϴ� ����
		father.start();
		// ��Ӵϰ� ����ϴ� ����
		mather.start();
		// ����ó�� �ݾ��� 10����õ��
		// ���� ����� 110_000��
		//����ȭ
		// �Ӱ迵���� �߻� �� ���� (�۾��� ���� �ڿ��� �����ϴ� ���°� �Ǿ�����)
		// ���� �ڿ�(������) �� ����ϰ� �ֱ� ������ ��ȣ ó���� ���־�� �Ѵ�.
		// �ٸ� �۾��ڰ� ������� �� �ϵ��� lock�� �ɾ��ش�.
		// ������ ���Ѽ� �۾��� �ϰ� �Ѵ�.
		
		// ������ -
		// 1. synchronized �޼��� ��ü������ �Ҷ� ������ ���� �ʿ䰡 ������ �̿�
		// 2. synchronized �� ��ü������ ������ ���ؼ� �Ϸ����Ҷ�

	}
}
