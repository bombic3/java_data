/*
 * ������ Ŭ����
 * ������
 *  - ��� ��� ���� ���
 *  - ��ȸ�� / ��ȸ�� �߰�
 *  - ���� ����
 *  - �̸� / ȸ����ȣ �˻��Ͽ� ���
 *  - �̸� / ȸ����ȣ �˻��Ͽ� ����
 *  
 *  ����ڰ� �̸� / ȸ����ȣ�� �Է� �� �ش� ��ü�� �����ش�.
 */


import java.util.Scanner;

public class Administrator {	
	private Member[] member;
	private NonMember[] nonMember; 
	
	private int idx = 0;			//idx for member
	private int idx2 = 0;			//idx for non member
	
	//Admin's ID and PW for manage the whole system
	private String ID;
	private int PW;
	
	//������ ������ -> ����� 50����� ���� �����ϴ�. (has a)
	public Administrator() {
		member = new Member[50];
		nonMember = new NonMember[5];
		
		//Set the admin ID and PW
		ID = "root";
		PW = 1234;
	}
	
	//Check the login attempt is valid
	public int check(String ID, int PW) {
		//Check ID and PW is admin
		if(ID.equals(this.ID) && PW == this.PW) {
			return 1000;
		}
		
		for(int i=0 ; i<idx ; i++) {
			if(member[i].getName().equals(ID) && member[i].getPeople_id() == PW) {
				return i;
			}
		}
		
		for(int i=0 ; i<idx2 ; i++) {
			if(nonMember[i].getName().equals(ID) && nonMember[i].getPeople_id() == PW) {
				return 50 + i;
			}
		}
		
		return -1;
	}
	
	public Member getMember(int num) {
		return member[num];
	}
	
	public NonMember getNonMember(int num) {
		return nonMember[num];
	}
	
	//Member Class ����
	
	//������ ��� �߰�
	public void addMember() {
		if(idx>49) {
			System.out.println("50������� ���� �����մϴ�.");
			return;
		}
		System.out.println("ȸ�� �߰�!");
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		String name = sc.next();
		String membership = null;
		while(true) {
			System.out.println("1.�ʱ� A��(����) 2.�ʱ� B��(����) 3.�߱� A��(����) 4.�߱� B��(����) 5.��� A��(����)");
			System.out.print("ȸ����� : ");
			int c = sc.nextInt();
			if(c==1) {
				membership = "�ʱ� A��(����)";
				break;
			}
			else if(c==2) {
				membership = "�ʱ� B��(����)";
				break;
			}
			else if(c==3) {
				membership = "�߱� A��(����)";
				break;
			}
			else if(c==4) {
				membership = "�߱� B��(����)";
				break;
			}
			else if(c==5) {
				membership = "��� A��(����)";
				break;
			}
			System.out.println("�߸� �� ȸ������Դϴ�!");
		}
		System.out.print("���� : ");
		int birthday = sc.nextInt();
		System.out.print("��ϳ�¥ : ");
		int start = sc.nextInt();
		System.out.print("������ ��ȣ : ");
		int department_code = sc.nextInt();
		System.out.print("������ �̸� : ");
		String department_name = sc.next();
		System.out.print("����ó : ");
		int phone_number = sc.nextInt();
		System.out.print("ȸ����ȣ : ");
		int member_id = sc.nextInt();
		System.out.print("�̸��� : ");
		String email = sc.next();
		System.out.print("�ּ� : ");
		String address = sc.next();
		System.out.print("���� ����� : ");
		String account_name = sc.next();
		System.out.print("���¹�ȣ : ");
		String account_number = sc.next();
		System.out.print("���� ������ : ");
		String account_owner = sc.next();
		System.out.print("������ : ");
		int tui = sc.nextInt();
		System.out.print("�ʰ� ������ : ");
		int hourTui = sc.nextInt();
		System.out.print("�ʰ� ��ð� : ");
		int overTime = sc.nextInt();
		System.out.print("�ʰ� �߰� ��ð� : ");
		int nightTime = sc.nextInt();
		member[idx++] = new Member(name, membership, birthday, start, department_code, department_name, 
				phone_number, member_id, email, address, account_name, account_number, account_owner, tui, hourTui, overTime, nightTime);
	}
	
	//������ ��ü ���
	public void printMember() {
		for(int i=0 ; i<idx ; i++) {
			System.out.println("�̸�\t : "+member[i].getName());
			System.out.println("ȸ����ȣ\t : "+member[i].getPeople_id());
			System.out.println("����ó\t : "+member[i].getPhone_number());
			System.out.println("����\t : "+member[i].getBirthday());
			System.out.println("�̸���\t : "+member[i].getEmail());
			System.out.println("�ּ�\t : "+member[i].getAddress());
			System.out.println("������ �̸�\t : "+member[i].getDepartmentName());
			System.out.println("������ ��ȣ\t : "+member[i].getDepartmentCode());
			System.out.println("ȸ�����\t : "+member[i].getMembership());
			System.out.println("��ϳ�¥\t : "+member[i].getStart());
			System.out.println("���¹�ȣ\t : "+member[i].getAccountNumber());
			System.out.println("��������\t : "+member[i].getAccountName());
			System.out.println("���¿�����\t : "+member[i].getAccountOwner());
			System.out.println("�Ѽ�����\t : "+member[i].getTotal());
			System.out.println("���α�\t : "+member[i].getSurtax());
			System.out.println("�Ǽ�����\t : "+member[i].getRealTui());
		}
		System.out.println();
	}
	
	//������ ��ȸ�� �˻�
	public void searchMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��ϰ� ���� ȸ���� �̸��� ȸ�� ��ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int member_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(member[i].getName().equals(name) && member[i].getPeople_id() == member_id) {
				System.out.println("�̸�\t : "+member[i].getName());
				System.out.println("ȸ����ȣ\t : "+member[i].getPeople_id());
				System.out.println("��ȣ\t : "+member[i].getPhone_number());
				System.out.println("����\t : "+member[i].getBirthday());
				System.out.println("�̸���\t : "+member[i].getEmail());
				System.out.println("�ּ�\t : "+member[i].getAddress());
				System.out.println("������ �̸�\t : "+member[i].getDepartmentName());
				System.out.println("������ ��ȣ\t : "+member[i].getDepartmentCode());
				System.out.println("ȸ�����\t : "+member[i].getMembership());
				System.out.println("��ϳ�¥\t : "+member[i].getStart());
				System.out.println("���¹�ȣ\t : "+member[i].getAccountNumber());
				System.out.println("��������\t : "+member[i].getAccountName());
				System.out.println("���¿�����\t : "+member[i].getAccountOwner());
				System.out.println("�Ѽ�����\t : "+member[i].getTotal());
				System.out.println("�Ѽ�����\t : "+member[i].getSurtax());
				System.out.println("�Ǽ�����\t : "+member[i].getRealTui());
				System.out.println();
				return;
			}
		}
		System.out.println("��ġ�ϴ� �̸� �� ȸ����ȣ�� �����ϴ�!");
	}
	
	//������ ��ȸ�� ����
	public void editMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ� ���� ȸ���� �̸��� ȸ����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int member_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(member[i].getName().equals(name) && member[i].getPeople_id() == member_id) {
				while(true) {
					System.out.println("������ �����Ͻðڽ��ϱ�?");
					System.out.println("1.�̸� 2.ȸ����ȣ 3.����ó 4.���� 5.�̸��� 6.�ּ� 7.������ �̸� "
							+ "8.������ ��ȣ 9.ȸ����� 10.��ϳ�¥ 11.���¹�ȣ 12.�������� 13.���¿����� 14.����");
					int choice = sc.nextInt();
					String str_temp;
					int int_temp;
					switch(choice) {
					//�̸�
					case 1:
						str_temp = sc.next();
						member[i].setName(str_temp);
						break;
						//ȸ����ȣ
					case 2:
						int_temp = sc.nextInt();
						member[i].setPeople_id(int_temp);
						break;
						//����ó
					case 3:
						int_temp = sc.nextInt();
						member[i].setPhone_number(int_temp);
						break;
						//����
					case 4:
						int_temp = sc.nextInt();
						member[i].setBirthday(int_temp);
						break;
						//�̸���
					case 5:
						str_temp = sc.next();
						member[i].setEmail(str_temp);
						break;
						//�ּ�
					case 6:
						str_temp = sc.next();
						member[i].setAddress(str_temp);
						break;
						//������ �̸�
					case 7:
						str_temp = sc.next();
						member[i].setDepartmentName(str_temp);
						break;
						//������ ��ȣ
					case 8:
						int_temp = sc.nextInt();
						member[i].setDepartmentCode(int_temp);
						break;
						//ȸ�����
					case 9:
						str_temp = sc.next();
						member[i].setMembership(str_temp);
						break;
						//��ϳ�¥
					case 10:
						int_temp = sc.nextInt();
						member[i].setStart(int_temp);
						break;
						//���¹�ȣ
					case 11:
						str_temp = sc.next();
						member[i].SetAccountNumber(str_temp);
						break;
						//��������
					case 12:
						str_temp = sc.next();
						member[i].SetAccountName(str_temp);
						break;
						//���¿�����
					case 13:
						str_temp = sc.next();
						member[i].SetAccountOwner(str_temp);
						break;
					case 14:
						return;
					default:
						System.out.println("�߸� �� �Է�");
					}
				}
			}
		}
		System.out.println("��ġ�ϴ� �̸� �� ȸ����ȣ�� �����ϴ�!");
	}
	
	//�����ڰ� ��ȸ�� ����
	public void deleteMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��ϰ� ���� ȸ���� �̸��� ȸ����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int member_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(member[i].getName().equals(name) && member[i].getPeople_id() == member_id) {
				member[i] = member[--idx];
				System.out.println("���� �Ϸ�!");
				return;
			}
		}
		System.out.println("��ġ�ϴ� �̸� �� ȸ����ȣ�� �����ϴ�!");
	}
	
	
	//NonMember Class ����
	
	//administrator is adding the non member
	void addNonMember() {
		if(idx2>5) {
			System.out.println("5������� ���� �����մϴ�.");
			return;
		}
		System.out.println("��ȸ�� �߰�!");
		nonMember[idx2] = new NonMember();
		Scanner sc = new Scanner(System.in);
		nonMember[idx2].setMembership("��ȸ��");
		//set the values of non member
		System.out.print("�̸� : ");
		nonMember[idx2].setName(sc.next());
		System.out.print("���� : ");
		nonMember[idx2].setBirthday(sc.nextInt());
		System.out.print("��ϳ�¥ : ");
		nonMember[idx2].setStart(sc.nextInt());
		System.out.print("������ ��ȣ : ");
		nonMember[idx2].setDepartmentCode(sc.nextInt());
		System.out.print("������ �̸� : ");
		nonMember[idx2].setDepartmentName(sc.next());
		System.out.print("����ó : ");
		nonMember[idx2].setPhone_number(sc.nextInt());;
		System.out.print("ȸ����ȣ : ");
		nonMember[idx2].setPeople_id(sc.nextInt());
		System.out.print("�̸��� : ");
		nonMember[idx2].setEmail(sc.next());
		System.out.print("�ּ� : ");
		nonMember[idx2].setAddress(sc.next());
		System.out.print("���� ����� : ");
		nonMember[idx2].SetAccountName(sc.next());
		System.out.print("���¹�ȣ : ");
		nonMember[idx2].SetAccountNumber(sc.next());
		System.out.print("���� ������ : ");
		nonMember[idx2].SetAccountOwner(sc.next());
		System.out.print("�ð��� ������ : ");
		nonMember[idx2].setHourTui(sc.nextInt());
		System.out.print("��ð� : ");
		nonMember[idx2].setWorkoutTime(sc.nextInt());
		System.out.print("�ʰ� ��ð� : ");
		nonMember[idx2].setOverTime(sc.nextInt());
		System.out.print("�ʰ� �߰� ��ð� : ");
		nonMember[idx2].setNightTime(sc.nextInt());
		idx2++;
	}
	
	//print all of the non member
	void printNonMember() {
		for(int i=0 ; i<idx2 ; i++) {
			System.out.println("�̸�\t : "+nonMember[i].getName());
			System.out.println("ȸ����ȣ\t : "+nonMember[i].getPeople_id());
			System.out.println("����ó\t : "+nonMember[i].getPhone_number());
			System.out.println("����\t : "+nonMember[i].getBirthday());
			System.out.println("�̸���\t : "+nonMember[i].getEmail());
			System.out.println("�ּ�\t : "+nonMember[i].getAddress());
			System.out.println("������ �̸�\t : "+nonMember[i].getDepartmentName());
			System.out.println("������ ��ȣ\t : "+nonMember[i].getDepartmentCode());
			System.out.println("ȸ�����\t : "+nonMember[i].getMembership());
			System.out.println("��ϳ�¥\t : "+nonMember[i].getStart());
			System.out.println("���¹�ȣ\t : "+nonMember[i].getAccountNumber());
			System.out.println("��������\t : "+nonMember[i].getAccountName());
			System.out.println("���¿�����\t : "+nonMember[i].getAccountOwner());
			System.out.println("�Ѽ�����\t : "+nonMember[i].getTotalTui());
			System.out.println("�ΰ���\t : "+nonMember[i].getSurtax());
			System.out.println("�Ǽ�����\t : "+nonMember[i].getRealTui());
			System.out.println();
		}
	}
	
	//get name and people_id and searching the match one
	void searchNonMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��ϰ� ���� ȸ���� �̸��� ȸ����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(nonMember[i].getName().equals(name) && nonMember[i].getPeople_id() == people_id) {
				System.out.println("�̸�\t : "+nonMember[i].getName());
				System.out.println("ȸ����ȣ\t : "+nonMember[i].getPeople_id());
				System.out.println("����ó\t : "+nonMember[i].getPhone_number());
				System.out.println("����\t : "+nonMember[i].getBirthday());
				System.out.println("�̸���\t : "+nonMember[i].getEmail());
				System.out.println("�ּ�\t : "+nonMember[i].getAddress());
				System.out.println("������ �̸�\t : "+nonMember[i].getDepartmentName());
				System.out.println("������ ��ȣ\t : "+nonMember[i].getDepartmentCode());
				System.out.println("ȸ�����\t : "+nonMember[i].getMembership());
				System.out.println("��ϳ�¥\t : "+nonMember[i].getStart());
				System.out.println("���¹�ȣ\t : "+nonMember[i].getAccountNumber());
				System.out.println("��������\t : "+nonMember[i].getAccountName());
				System.out.println("���¿�����\t : "+nonMember[i].getAccountOwner());
				System.out.println("�Ѽ�����\t : "+nonMember[i].getTotalTui());
				System.out.println("�ΰ���\t : "+nonMember[i].getSurtax());
				System.out.println("�Ǽ�����\t : "+nonMember[i].getRealTui());
				System.out.println();
				return;
			}
		}
		System.out.println("��ġ�ϴ� ��ȸ���� �����ϴ�!");
	}
	
	//get name and people_id and edit the element choose by administrator
	void editNonMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ� ���� ȸ���� �̸��� ȸ����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(nonMember[i].getName().equals(name) && nonMember[i].getPeople_id() == people_id) {
				while(true) {
					System.out.println("������ �����Ͻðڽ��ϱ�?");
					System.out.println("1.�̸� 2.ȸ����ȣ 3.����ó 4.���� 5.�̸��� 6.�ּ� 7.������ �̸� "
							+ "8.������ ��ȣ 9.�ð��� ������ 10.����� 11.���¹�ȣ 12.�������� 13.���¿����� "
							+ "14.��ð� 15.�ʰ���ð� 16.�ʰ��߰���ð� 17.����");
					int choice = sc.nextInt();
					String str_temp;
					int int_temp;
					switch(choice) {
					//�̸�
					case 1:
						str_temp = sc.next();
						nonMember[i].setName(str_temp);
						break;
						//ȸ����ȣ
					case 2:
						int_temp = sc.nextInt();
						nonMember[i].setPeople_id(int_temp);
						break;
						//��ȣ
					case 3:
						int_temp = sc.nextInt();
						nonMember[i].setPhone_number(int_temp);
						break;
						//����
					case 4:
						int_temp = sc.nextInt();
						nonMember[i].setBirthday(int_temp);
						break;
						//�̸���
					case 5:
						str_temp = sc.next();
						nonMember[i].setEmail(str_temp);
						break;
						//�ּ�
					case 6:
						str_temp = sc.next();
						nonMember[i].setAddress(str_temp);
						break;
						//������
					case 7:
						str_temp = sc.next();
						nonMember[i].setDepartmentName(str_temp);
						break;
						//������ ��ȣ
					case 8:
						int_temp = sc.nextInt();
						nonMember[i].setDepartmentCode(int_temp);
						break;
						//�ð��� ������
					case 9:
						nonMember[i].setHourTui(sc.nextInt());
						break;
						//�����
					case 10:
						int_temp = sc.nextInt();
						nonMember[i].setStart(int_temp);
						break;
						//���¹�ȣ
					case 11:
						str_temp = sc.next();
						nonMember[i].SetAccountNumber(str_temp);
						break;
						//��������
					case 12:
						str_temp = sc.next();
						nonMember[i].SetAccountName(str_temp);
						break;
						//���¿�����
					case 13:
						str_temp = sc.next();
						nonMember[i].SetAccountOwner(str_temp);
						break;
						//��ð�
					case 14:
						nonMember[i].setWorkoutTime(sc.nextInt());
						break;
						//�ʰ� ��ð�
					case 15:
						nonMember[i].setOverTime(sc.nextInt());
						break;
						//�ʰ� �߰� ��ð�
					case 16:
						nonMember[i].setNightTime(sc.nextInt());
						break;
						//����
					case 17:
						return;
					default:
						System.out.println("�߸� �� �Է�");
					}
				}
			}
		}
		System.out.println("��ġ�ϴ� ��ȸ���� �����ϴ�!");
	}
	
	//get name and people_id and delete the element and swap with last one
	void deleteNonMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ� ���� ȸ���� �̸��� ȸ����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(nonMember[i].getName().equals(name) && nonMember[i].getPeople_id() == people_id) {
				nonMember[i] = nonMember[--idx2];
				System.out.println("���� �Ϸ�!");
				return;
			}
		}
		System.out.println("��ġ�ϴ� ��ȸ�� �����ϴ�!");
	}
}