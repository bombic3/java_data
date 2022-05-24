/*
 * 직원 클래스
 */



public class Member extends People{
	private double baseTui; //기본급(월급) -> 월수강비
	private double gradeTui; // 직급 별 인센티브 -> 회원등급별 포인트
	private double hourTui; // 시급 -> 시간당 수강비
	private int overTime;	//초과 근무 시간 -> 초과운동시간
	private double nightTui; // 초과근무 수당 -> 초과운동 수강비
	private int nightTime;	//초과 야간 근무 시간 -> 초과 야간 운동 시간
	
	private double totalTui;	//총급여  -> 총 수강료
	private double surtax;			//세금   -> 부가세 10%
	private double realTui; //실급여 (실제지급액) -> 실 수강료


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

	//월급을 세팅한다.
	public void setBaseTui(double month_tui) {
		this.baseTui = month_tui;
	}

	public double getBaseTui() {
		return baseTui;
	}

	// 인센티브 = 기본급*퍼센트  알바 0% 사원 15%   대리 30%    과장 40%   차장 50%   부장 60%
	public void setGradeTui() { 
		String position = super.getMembership(); //getPosition() 직책 받아오기\
		switch(position) {
		case "알바":
			this.gradeTui = (int)(this.baseTui*0.00);
			break;
		case "사원":
			this.gradeTui = (int)(this.baseTui*0.15);
			break;
		case "대리":
			this.gradeTui = (int)(this.baseTui*0.30);
			break;
		case "과장":
			this.gradeTui = (int)(this.baseTui*0.40);
			break;
		case "차장":
			this.gradeTui = (int)(this.baseTui*0.50);
			break;
		case "부장":
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

	//추가 근무 시급 설정
	public void sethourTui() {
//		String position = super.getRank(); //getPosition() 직책 받아오기\
//		switch(position) {
//		case "알바":
//			this.hourPay = 8500;
//			break;
//		case "사원":
//			this.hourPay = 8500 * 1.5;
//			break;
//		case "대리":
//			this.hourPay = 8500 * 2;
//			break;
//		case "과장":
//			this.hourPay = 8500 * 3;
//			break;
//		case "차장":
//			this.hourPay = 8500 * 5;
//			break;
//		case "부장":
//			this.hourPay = 8500 * 10;
//			break;
//		default:
//			System.out.println("잘못 입력하셨습니다.");
//			break;
//		}
	}

	public double gethourTui() {
		return hourTui;
	}

	//야간근무는 초과근무 시급의 1.5배
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
		surtax = CalTax(totalTui);
		return surtax;
	}
	
	//실질적으로 최종 급여를 계산해주는 부분
	public double getRealTui() {
		this.setBaseTui(baseTui);
		this.setGradeTui();
		this.setNightTui(hourTui);
		this.sethourTui();
		
		this.realTui = totalTui + surtax;
		return realTui;
	}

	//세금 계산할 때 중복되는 연산을 정의한 함수
	//국민연금(4.5%),건강보험(3.23),장기요양(8.51),고용보험(0.65)
	public double minusSurtax(double month_Tui) {
		month_Tui = (month_Tui*0.045) + ((month_Tui*0.0323)*1.0851)
				+ (month_Tui*0.0065);
		return month_Tui;
	}

	//월급으로 계산
	public double CalTax(double month_pay) {
		double pay = 0;
		//월급 백만원 이하는 소득세를 받지 않음
		if(month_pay<1000000) {
			pay = minusSurtax(month_pay);
		}
		//소득세 0.005
		else if (month_pay >= 1000000 && month_pay <=1500000) {
			pay = minusSurtax(month_pay) + 1.1*(month_pay*0.005); 
		}
		//소득세 0.03
		else if (month_pay >= 1500000 && month_pay <=3000000) {
			pay = minusSurtax(month_pay) + 1.1*(month_pay*0.03);
		}
		//소득세 0.06
		else if (month_pay >= 3000000 && month_pay <=5000000) {
			pay = minusSurtax(month_pay) + 1.1*(month_pay*0.06);
		}
		//소득세 0.015
		else if (month_pay >= 5000000 && month_pay <= 10000000) {
			pay = minusSurtax(month_pay) + 1.1*(month_pay*0.15);
		}
		//소득세 0.025
		else {
			pay = minusSurtax(month_pay) + 1.1*(month_pay*0.25);
		}

		return Math.round(tui);
	}

}

