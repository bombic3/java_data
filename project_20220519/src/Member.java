/*
 * ���� Ŭ����
 */



public class Member extends People{
	private double baseTui; //�⺻��(����) -> ��������
	private double gradeTui; // ���� �� �μ�Ƽ�� -> ȸ����޺� ����Ʈ
	private double hourTui; // �ñ� -> �ð��� ������
	private int overTime;	//�ʰ� �ٹ� �ð� -> �ʰ���ð�
	private double nightTui; // �ʰ��ٹ� ���� -> �ʰ�� ������
	private int nightTime;	//�ʰ� �߰� �ٹ� �ð� -> �ʰ� �߰� � �ð�
	
	private double totalTui;	//�ѱ޿�  -> �� ������
	private double surtax;			//����   -> �ΰ��� 10%
	private double realTui; //�Ǳ޿� (�������޾�) -> �� ������


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

	//������ �����Ѵ�.
	public void setBaseTui(double month_tui) {
		this.baseTui = month_tui;
	}

	public double getBaseTui() {
		return baseTui;
	}

	// �μ�Ƽ�� = �⺻��*�ۼ�Ʈ  �˹� 0% ��� 15%   �븮 30%    ���� 40%   ���� 50%   ���� 60%
	public void setGradeTui() { 
		String position = super.getMembership(); //getPosition() ��å �޾ƿ���\
		switch(position) {
		case "�˹�":
			this.gradeTui = (int)(this.baseTui*0.00);
			break;
		case "���":
			this.gradeTui = (int)(this.baseTui*0.15);
			break;
		case "�븮":
			this.gradeTui = (int)(this.baseTui*0.30);
			break;
		case "����":
			this.gradeTui = (int)(this.baseTui*0.40);
			break;
		case "����":
			this.gradeTui = (int)(this.baseTui*0.50);
			break;
		case "����":
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

	//�߰� �ٹ� �ñ� ����
	public void sethourTui() {
//		String position = super.getRank(); //getPosition() ��å �޾ƿ���\
//		switch(position) {
//		case "�˹�":
//			this.hourPay = 8500;
//			break;
//		case "���":
//			this.hourPay = 8500 * 1.5;
//			break;
//		case "�븮":
//			this.hourPay = 8500 * 2;
//			break;
//		case "����":
//			this.hourPay = 8500 * 3;
//			break;
//		case "����":
//			this.hourPay = 8500 * 5;
//			break;
//		case "����":
//			this.hourPay = 8500 * 10;
//			break;
//		default:
//			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
//			break;
//		}
	}

	public double gethourTui() {
		return hourTui;
	}

	//�߰��ٹ��� �ʰ��ٹ� �ñ��� 1.5��
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
	
	//���������� ���� �޿��� ������ִ� �κ�
	public double getRealTui() {
		this.setBaseTui(baseTui);
		this.setGradeTui();
		this.setNightTui(hourTui);
		this.sethourTui();
		
		this.realTui = totalTui + surtax;
		return realTui;
	}

	//���� ����� �� �ߺ��Ǵ� ������ ������ �Լ�
	//���ο���(4.5%),�ǰ�����(3.23),�����(8.51),���뺸��(0.65)
	public double minusSurtax(double month_Tui) {
		month_Tui = (month_Tui*0.045) + ((month_Tui*0.0323)*1.0851)
				+ (month_Tui*0.0065);
		return month_Tui;
	}

	//�������� ���
	public double CalTax(double month_pay) {
		double pay = 0;
		//���� �鸸�� ���ϴ� �ҵ漼�� ���� ����
		if(month_pay<1000000) {
			pay = minusSurtax(month_pay);
		}
		//�ҵ漼 0.005
		else if (month_pay >= 1000000 && month_pay <=1500000) {
			pay = minusSurtax(month_pay) + 1.1*(month_pay*0.005); 
		}
		//�ҵ漼 0.03
		else if (month_pay >= 1500000 && month_pay <=3000000) {
			pay = minusSurtax(month_pay) + 1.1*(month_pay*0.03);
		}
		//�ҵ漼 0.06
		else if (month_pay >= 3000000 && month_pay <=5000000) {
			pay = minusSurtax(month_pay) + 1.1*(month_pay*0.06);
		}
		//�ҵ漼 0.015
		else if (month_pay >= 5000000 && month_pay <= 10000000) {
			pay = minusSurtax(month_pay) + 1.1*(month_pay*0.15);
		}
		//�ҵ漼 0.025
		else {
			pay = minusSurtax(month_pay) + 1.1*(month_pay*0.25);
		}

		return Math.round(tui);
	}

}
