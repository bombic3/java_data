/*
 * 회원 관리 (정회원, 비회원)
 * 이름
 * 수강시간 및 강사레벨
 * 생년월일
 * 등등..
 */



public class People {

	private String name;					           //이름
	private String membership;				       //회원등급
	private int birthday;					           //생일
	private int people_id;					         //회원번호
	private int start;						           //등록날짜
	private People_Department department;	   //수강반 이름
	
	//사용자가 수정 가능한 정보
	private int phone_number;				         //전화번호
	private String email;					           //email
	private String address;					         //주소
	private People_Account account;			     //계좌
	
	float tui;								               //수강비
	
	public People() {
		department = new People_Department();
		account = new People_Account();
	}
	
	public void setPeople(String name, String membership, int birthday, int start, int department_code, String department_name, 
			int phone_number, int people_id, String email, String address, String account_name, String account_number, String account_owner) {
		this.setName(name);
		this.setMembership(membership);
		this.setBirthday(birthday);
		this.setStart(start);
		department = new People_Department(department_code, department_name);
		this.setPhone_number(phone_number);
		this.setPeople_id(people_id);
		this.setEmail(email);
		this.setAddress(address);
		account = new People_Account(account_name, account_number, account_owner);
	}

	public String getName() {                       //이름
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMembership() {                 //회원등급
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public String getEmail() {                      //email
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {                    //주소
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartmentName() {             //수강반 이름
		return department.getName();
	}

	public void setDepartmentName(String departmentName) {
		this.department.setName(departmentName);
	}
	
	public int getDepartmentCode() {                //수강반 번호
		return department.getCode();
	}
	
	public void setDepartmentCode(int code) {       
		department.setCode(code);
	}

	public int getPhone_number() {                  //번호
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public int getPeople_id() {                     //회원번호
		return people_id;
	}

	public void setPeople_id(int people_id) {
		this.people_id = people_id;
	}

	public int getBirthday() {                      //생일
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public int getStart() {                         //등록날짜
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	public String getAccountName() {                //은행명
		return account.getBank_name();
	}
	
	public void SetAccountName(String name) {
		account.setBank_name(name);
	}
	
	public String getAccountOwner() {              //예금주 
		return account.getAccount_owner();
	}
	
	public void SetAccountOwner(String owner) {
		account.setAccount_owner(owner);
	}
	
	public String getAccountNumber() {             //계좌번호
		return account.getAccount_number();
	}
	
	public void SetAccountNumber(String number) {
		account.setAccount_number(number);
	}
	
	public int getYear() {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int year = cal.get ( cal.YEAR );
		return year-start;
	}
	   
}