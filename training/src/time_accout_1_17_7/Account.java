package time_accout_1_17_7;

public class Account {
	  private String name;
	  private String no;
	  private long balance;
	  private Day openDay;
	  
	  public Account(String n, String num, long z, Day d) {
		name = n;
		no = num;
		balance = z;
		openDay = new Day(d);
	  }
	  
	  public String getName() {
		  return name;
	  }
	  
	  public String getNo() {
		  return no;
	  }
	  
	  public long getBalance() {
		  return balance;
	  }
	  
	  public Day getOpenDay() {
		  return new Day(openDay);
	  }
	  
	  void deposit(long k) {
		  balance += k;
	  }
	  
	  void wirhdraw(long k) {
		  balance -= k;
	  }
	  
	  public String toString() {
		  return "{" + name + ", " + no + ", " + balance + "}";
	  }
	}

