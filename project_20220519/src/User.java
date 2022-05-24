/*
 * ����� Ŭ����
 * ������ ���̵�� ��й�ȣ�� �Է��ϸ� �����ڷ� �α����� �����ϴ�.
 * �Ϲ� ����� �̸��� ��� ��ȣ�� Ȯ���Ͽ� �ش� ����� ��ü�� �޾ƿ´�.
 * ���� ��ȸ �� ������ ������ �����ϴ�.
 */

//����


import java.util.Scanner;

public class User {
	private People people;
	private Member member;
	private NonMember nonMember;
	
	public User(Member member) {
		this.member = member;
		people = member;
		nonMember = null;
	}
	
	public User(NonMember nonMember) {
		this.nonMember = nonMember;
		people = nonMember;
		member = null;
	}
	
	public void print() {
		if(member != null) {
			System.out.println("�̸�\t : "+member.getName());
			System.out.println("ȸ����ȣ\t : "+member.getPeople_id());
			System.out.println("����ó\t : "+member.getPhone_number());
			System.out.println("����\t : "+member.getBirthday());
			System.out.println("�̸���\t : "+member.getEmail());
			System.out.println("�ּ�\t : "+member.getAddress());
			System.out.println("������ �̸�\t : "+member.getDepartmentName());
			System.out.println("������ ��ȣ\t : "+member.getDepartmentCode());
			System.out.println("ȸ�����\t : "+member.getMembership());
			System.out.println("��ϳ�¥\t : "+member.getStart());
			System.out.println("���¹�ȣ\t : "+member.getAccountNumber());
			System.out.println("��������\t : "+member.getAccountName());
			System.out.println("���¿�����\t : "+member.getAccountOwner());
			System.out.println("�� ������\t : "+member.getTotal());
			System.out.println("�ΰ���\t : "+member.getSurtax());
			System.out.println("�� ������\t : "+member.getRealTui());
			System.out.println();
		}
		else {
			System.out.println("�̸�\t : "+nonMember.getName());
			System.out.println("ȸ����ȣ\t : "+nonMember.getPeople_id());
			System.out.println("����ó\t : "+nonMember.getPhone_number());
			System.out.println("����\t : "+nonMember.getBirthday());
			System.out.println("�̸���\t : "+nonMember.getEmail());
			System.out.println("�ּ�\t : "+nonMember.getAddress());
			System.out.println("������ �̸�\t : "+nonMember.getDepartmentName());
			System.out.println("������ ��ȣ\t : "+nonMember.getDepartmentCode());
			System.out.println("ȸ����ȣ\t : "+nonMember.getMembership());
			System.out.println("��ϳ�¥\t : "+nonMember.getStart());
			System.out.println("���¹�ȣ\t : "+nonMember.getAccountNumber());
			System.out.println("��������\t : "+nonMember.getAccountName());
			System.out.println("���¿�����\t : "+nonMember.getAccountOwner());
			System.out.println("�� ������\t : "+nonMember.getTotalTui());
			System.out.println("���ξ�\t : "+nonMember.getSurtax());
			System.out.println("�� ������\t : "+nonMember.getRealTui());
			System.out.println();
		}
	}
	
	//�������ε� �̿�
	public void edit() {
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("1.����ó 2.�̸��� 3.�ּ� 4.���¹�ȣ 5.�������� 6.���¿����� 7.����");
			choice = sc.nextInt();
			if(choice == 1) {
				people.setPhone_number(sc.nextInt());
			}
			else if(choice == 2) {
				people.setEmail(sc.next());
			}
			else if(choice == 3) {
				people.setAddress(sc.next());
			}
			else if(choice == 4 ) {
				people.SetAccountNumber(sc.next());
			}
			else if(choice == 5) {
				people.SetAccountName(sc.next());
			}
			else if(choice == 6) {
				people.SetAccountOwner(sc.next());
			}
			else if(choice == 7) {
				return;
			}
			else {
				System.out.println("�߸� �� �Է��Դϴ�.");
			}
		}
	}
}