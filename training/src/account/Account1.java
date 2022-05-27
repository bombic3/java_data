package account;

public class Account1 {
	private String name;     //계좌 명의
	private String no;       //계좌 번호
	private long balance;    //예금 잔고
	
	//---생성자---//
	Account1(String n, String num, long z){
	name = n;               //계좌 명의
	no = num;               //계좌 번호
	balance = z;            //예금 잔고
	}
	
	
	//---계좌 명의 확인---//
	String getName() {
		return name;
	}
	//---계좌 번호 확인---//
	String getNo() {
		return name;
	}
	//---예금 잔고 확인---//
	String getBalance() {
		return name;
	}
	//---k원 입금---//
	void deposit(long k) {
		balance += k;
	}
	//---k원 출금---//
	void withdraw(long k) {
		balance += k;
	
	}
}
