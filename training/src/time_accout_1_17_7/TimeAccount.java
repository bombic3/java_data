package time_accout_1_17_7;

public class TimeAccount extends Account {
	private long timeBalance;				// 예금 잔액(정기예금)

	// 생성자
	public TimeAccount(String name, String no, long balance, long timeBalance) {
		super(name, no, balance);			// Account 클래스 생성자 호출
		this.timeBalance = timeBalance;		// 예금 잔액(정기예금)
	}
	
	// 정기예금 잔액 확인
	long getTimeBalance() {
		return timeBalance;
	}
	// 정기예금을 해약하고 전액을 보통예금으로 이체
	void cancel() {
		deposit(timeBalance);
		timeBalance = 0;
	}
}
