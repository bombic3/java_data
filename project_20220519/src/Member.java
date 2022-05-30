public class Member extends People{
	private double baseTui; 	// ��������
	private double gradeTui;	// ���緹���� �߰� ������
	private double hourTui; 	// �ð��� ������
	private int overTime;		// �ʰ���ð�
	private double nightTui; 	// �ʰ�� ������
	private int nightTime;		// ���ο�� �̿�ð�
	
	private double totalTui;	// �� ������
	private double surtax;		// �ΰ��� 10%
	private double realTui; 	// �� ������


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

	// �����Ḧ �����Ѵ�.
	public void setBaseTui(double month_tui) {
		this.baseTui = month_tui;
	}

	public double getBaseTui() {
		return baseTui;
	}

	// ȸ����޺� �߰� ������ = �⺻������*�ۼ�Ʈ  ��ȸ�� 0% �ʱް��� ���Ͽ��� 15%   �߱ް��� ���Ͽ��� 30%    �߱ް��� ���Ͽ��� 40%   ��ް��� ���Ͽ��� 50%   ��ް��� �ָ��� 60%
	public void setGradeTui() { 
		String position = super.getMembership(); // getMembership() ȸ����� �޾ƿ���
		switch(position) {
		case "��ȸ��":
			this.gradeTui = (int)(this.baseTui*0.00);
			break;
		case "�ʱް��� ���Ͽ���":
			this.gradeTui = (int)(this.baseTui*0.15);
			break;
		case "�߱ް��� ���Ͽ���":
			this.gradeTui = (int)(this.baseTui*0.30);
			break;
		case "�߱ް��� ���Ͽ���":
			this.gradeTui = (int)(this.baseTui*0.40);
			break;
		case "��ް��� ���Ͽ���":
			this.gradeTui = (int)(this.baseTui*0.50);
			break;
		case "��ް��� �ָ���":
			this.gradeTui = (int)(this.baseTui*0.60);
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");   
			break;
		}
	}

	public double getGradeTui() {
		return gradeTui;
	}

	// �ʰ� ������ ����
	public void sethourTui() {
		String position = super.getMembership(); //getMembership() ������ �޾ƿ���
		switch(position) {
		case "��ȸ��":
			this.hourTui = 8500;
			break;
		case "�ʱް��� ���Ͽ���":
			this.hourTui = 8500 * 1.5;
			break;
		case "�߱ް��� ���Ͽ���":
			this.hourTui = 8500 * 2;
			break;
		case "�߱ް��� ���Ͽ���":
			this.hourTui = 8500 * 3;
			break;
		case "��ް��� ���Ͽ���":
			this.hourTui = 8500 * 5;
			break;
		case "��ް��� �ָ���":
			this.hourTui = 8500 * 10;
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			break;
		}
	}

	public double gethourTui() {
		return hourTui;
	}

	//���ο�� �̿��� �ʰ�� �������� 1.5��
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
	
	//���������� ���� �޿��� ������ִ� �κ�
	public double getRealTui() {
		this.setBaseTui(baseTui);
//		this.setGradeTui();
		this.setNightTui(hourTui);
//		this.sethourTui();
		
		this.realTui = totalTui + surtax;
		return realTui;
	}

	


}