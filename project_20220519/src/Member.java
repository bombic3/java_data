public class Member extends People{
	private double baseTui; 	// 월수강비
	private double gradeTui;	// 강사레벨별 추가 수강료
	private double hourTui; 	// 시간당 수강비
	private int overTime;		// 초과운동시간
	private double nightTui; 	// 초과운동 수강비
	private int nightTime;		// 개인운동실 이용시간
	
	private double totalTui;	// 총 수강료
	private double surtax;		// 부가세 10%
	private double realTui; 	// 실 수강료


	public Member() {
		
	}
	
	public Member(String name, String membership, int birthday, int start, int department_code, String department_name, 
			int phone_number, int people_id, String email, String address, String account_name, String account_number, String account_owner,
			int tui, int hourTui, int overTime, int nightTime) {
		super.setPeople(name, membership, birthday, start, department_code, department_name, 
				phone_number, people_id, email, address, account_name, account_number, account_owner);
		gradeTui = baseTui = realTui = 0;
		this.hourTui = hourTui;
		this.nightTime = nightTime;
		this.overTime = overTime;
		setBaseTui(tui);
	}

	// 수강료를 세팅한다.
	public void setBaseTui(double month_tui) {
		this.baseTui = month_tui;
	}

	public double getBaseTui() {
		return baseTui;
	}

	// 회원등급별 추가 수강료 = 기본수강비*퍼센트  비회원 0% 초급강사 평일오전 15%   중급강사 평일오전 30%    중급강사 평일오후 40%   고급강사 평일오후 50%   고급강사 주말반 60%
	public void setGradeTui() { 
		String position = super.getMembership(); // getMembership() 회원등급 받아오기
		switch(position) {
		case "비회원":
			this.gradeTui = (int)(this.baseTui*0.00);
			break;
		case "초급강사 평일오전":
			this.gradeTui = (int)(this.baseTui*0.15);
			break;
		case "중급강사 평일오전":
			this.gradeTui = (int)(this.baseTui*0.30);
			break;
		case "중급강사 평일오후":
			this.gradeTui = (int)(this.baseTui*0.40);
			break;
		case "고급강사 평일오후":
			this.gradeTui = (int)(this.baseTui*0.50);
			break;
		case "고급강사 주말반":
			this.gradeTui = (int)(this.baseTui*0.60);
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");   
			break;
		}
	}

	public double getGradeTui() {
		return gradeTui;
	}

	// 초과 수강료 설정
	public void sethourTui() {
		String position = super.getMembership(); //getMembership() 강사등급 받아오기
		switch(position) {
		case "비회원":
			this.hourTui = 8500;
			break;
		case "초급강사 평일오전":
			this.hourTui = 8500 * 1.5;
			break;
		case "중급강사 평일오전":
			this.hourTui = 8500 * 2;
			break;
		case "중급강사 평일오후":
			this.hourTui = 8500 * 3;
			break;
		case "고급강사 평일오후":
			this.hourTui = 8500 * 5;
			break;
		case "고급강사 주말반":
			this.hourTui = 8500 * 10;
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}

	public double gethourTui() {
		return hourTui;
	}

	//개인운동실 이용은 초과운동 수강료의 1.5배
	public void setNightTui(double hourTui) {
		this.nightTui = hourTui * 1.5;
	}

	public double getNightTui() {
		return nightTui;
	}

	public double getTotal() {
		totalTui = Math.round(this.baseTui + this.gradeTui + this.nightTui * nightTime + this.hourTui * overTime);
		return totalTui;
	}
	
	public double getSurtax() {
		surtax = totalTui*0.1;
		return surtax;
	}
	
	//실질적으로 최종 급여를 계산해주는 부분
	public double getRealTui() {
		this.setBaseTui(baseTui);
//		this.setGradeTui();
		this.setNightTui(hourTui);
//		this.sethourTui();
		
		this.realTui = totalTui + surtax;
		return realTui;
	}

	


}