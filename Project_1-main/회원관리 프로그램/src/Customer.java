
class Customer {
	String name;		// 이름
	String address;		// 주소
	String phone;		// 연락처
	String id;			// 회원 번호
	String program;		// 프로그램
	String instructor;	// 강사
	String start;		// 등록일자
	String friend;		// 추천인
	

	

	public Customer(String name, String address, String phone, String id, String program, String instructor, String start, String friend ) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.id = id;
		this.program = program;
		this.instructor = instructor;
		this.start = start;
		this.friend = friend;
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}
	
	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}
	
	public String getFriend() {
		return friend;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}
	
	
	
	

	@Override
	public String toString() {
		return "[ 고객이름: " + name + " , 주소: " + address + " , 연락처: " + phone + ", 회원번호: " + id + ", 프로그램: " + program + ", 강사: " + instructor + ", 등록일자: " + start + ", 추천인: " + friend + "]";
	}

}