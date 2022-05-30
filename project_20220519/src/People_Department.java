/*
 * 
 */



public class People_Department {
	private int code;		//수강실 번호
	private String name;	//수강반 이름
	
	public People_Department() {
		
	}
	
	public People_Department(int code, String name) {
		this.setCode(code);
		this.setName(name); 
	}

	public int getCode() {                //수강실 번호
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {             //수강반 이름
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}