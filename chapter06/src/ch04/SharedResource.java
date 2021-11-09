package ch04;

class BankAccount {
	private int money = 100_000;

	// getter
	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		if (money <= 0) {
			System.out.println("잘못된 입력 입니다.");
		} else {
			this.money = money;
		}
	}

	// 입금기능
	public  void saveMoney(int money) {
		// 10만원 선택
		synchronized (this) {
			int currentMoney = getMoney();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setMoney(currentMoney + money);
			System.out.println("입금 후 계좌 잔액" + getMoney());
		}
	}

	// 출금기능
	public synchronized void withdrawMoney(int money) {
		int currentMoney = getMoney();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 방어적 코드
		// Todo
		// 현재 금액보다 출금하려는 금액 크면 출금안되게 변경
		setMoney(currentMoney - money);
		System.out.println("출금 후 계좌 잔액" + getMoney());
	}
}

class Father extends Thread {
	BankAccount account;

	public Father(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		// 입금 하기
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
		
		// 현재 10만원 저금 되어 있는 상태로 객체 생성
		BankAccount account = new BankAccount();
		Father father = new Father(account);
		Mather mather = new Mather(account);
		
		// 아버지가 입금하는 동작
		father.start();
		// 어머니가 출금하는 동작
		mather.start();
		// 정상처리 금액은 10만오천원
		// 실제 결과값 110_000원
		//동기화
		// 임계영역이 발생 될 때는 (작업자 간에 자원을 공유하는 상태가 되었을때)
		// 현재 자원(데이터) 을 사용하고 있기 때문에 보호 처리를 해주어야 한다.
		// 다른 작업자가 사용하지 못 하도록 lock를 걸어준다.
		// 순서를 지켜서 작업을 하게 한다.
		
		// 선언방법 -
		// 1. synchronized 메서드 전체적으로 할때 구간을 정할 필요가 없을때 이용
		// 2. synchronized 블럭 구체적으로 구간을 정해서 하려고할때

	}
}
