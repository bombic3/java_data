/*
 * 비회원 클래스
 */



public class NonMember extends People{
	private int hourTui;		//시급 -> 시간당 수강비
	private int workoutTime;		//근무시간 -> 운동시간
	private int overTime;		//초과 근무시간 -> 초과 운동시간
	private int nightTime;		//야간 초과 근무시간 -> 야간 초과 운동시간
	
	private int holidayTui;		//주휴수당 -> 주휴수당몰라
	private double totalTui;	//총 급여 -> 총 수강비
	private double surtax;			//세금 -> 부가세 10%
	private double realTui;		//실수령액 -> 실 수강비
	
	public NonMember() {
		
	}
	
	public NonMember(int hourTui, int workoutTime, int overTime, int nightTime) {
		this.hourTui = hourTui;
		this.workoutTime = workoutTime;
		this.overTime = overTime;
		this.nightTime = nightTime;
	}
	
	public void setHourTui(int hourTui) {
		this.hourTui = hourTui;
	}
	
	public void setWorkoutTime(int workoutTime) {
		this.workoutTime = workoutTime;
	}
	
	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}
	
	public void setNightTime(int nightTime) {
		this.nightTime = nightTime;
	}

	public void setHolidayTui() {
		holidayTui = workoutTime / -(40 * 8 * hourTui); 
	}
	
	public void setTotalTui() {
		totalTui = hourTui * (workoutTime + overTime) + hourTui * 1.1 * nightTime + holidayTui;
	}
	
	public double getTotalTui() {
		setTotalTui();
		return Math.round(totalTui);
	}
	
	public void setSurtax() {
		surtax = PartTax(totalTui);
	}
	
	public double getSurtax() {
		setSurtax();
		return Math.round(surtax);
	}
	
	public void setRealTui() {
		realTui = totalTui + surtax;
	}
	
	public double getRealTui() {
		setRealTui();
		return realTui;
	}
	
	//세금 계산
	public double PartTax(double partTotal) {
	      double pay = partTotal*0.1;
	      return pay;
	}
}