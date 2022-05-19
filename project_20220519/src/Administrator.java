/*
 * ������ Ŭ����
 * ������
 *  - ��� ��� ���� ���
 *  - ���� / �˹� �߰�
 *  - ���� ����
 *  - �̸� / �����ȣ �˻��Ͽ� ���
 *  - �̸� / �����ȣ �˻��Ͽ� ����
 *  
 *  ����ڰ� �̸� / �����ȣ�� �Է� �� �ش� ��ü�� �����ش�.
 */



import java.util.Scanner;

public class Administrator {	
	private Worker[] worker;
	private PartTimer[] partTimer; 
	
	private int idx = 0;			//idx for worker
	private int idx2 = 0;			//idx for part timer
	
	//Admin's ID and PW for manage the whole system
	private String ID;
	private int PW;
	
	//������ ������ -> ����� 50����� ���� �����ϴ�. (has a)
	public Administrator() {
		worker = new Worker[50];
		partTimer = new PartTimer[5];
		
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
			if(worker[i].getName().equals(ID) && worker[i].getPeople_id() == PW) {
				return i;
			}
		}
		
		for(int i=0 ; i<idx2 ; i++) {
			if(partTimer[i].getName().equals(ID) && partTimer[i].getPeople_id() == PW) {
				return 50 + i;
			}
		}
		
		return -1;
	}
	
	public Worker getWorker(int num) {
		return worker[num];
	}
	
	public PartTimer getPartTimer(int num) {
		return partTimer[num];
	}
	
	//Worker Class ����
	
	//������ ��� �߰�
	public void addWorker() {
		if(idx>49) {
			System.out.println("50������� ���� �����մϴ�.");
			return;
		}
		System.out.println("ȸ�� �߰�!");
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		String name = sc.next();
		String rank = null;
		while(true) {
			System.out.println("1.�ʱ� A��(����) 2.�ʱ� B��(����) 3.�߱� A��(����) 4.�߱� B��(����) 5.��� A��(����)");
			System.out.print("ȸ����� : ");
			int c = sc.nextInt();
			if(c==1) {
				rank = "�ʱ� A��(����)";
				break;
			}
			else if(c==2) {
				rank = "�ʱ� B��(����)";
				break;
			}
			else if(c==3) {
				rank = "�߱� A��(����)";
				break;
			}
			else if(c==4) {
				rank = "�߱� B��(����)";
				break;
			}
			else if(c==5) {
				rank = "��� A��(����)";
				break;
			}
			System.out.println("�߸� �� �����Դϴ�!");
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
		int worker_id = sc.nextInt();
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
		int pay = sc.nextInt();
		System.out.print("�ʰ� ������ : ");
		int hourPay = sc.nextInt();
		System.out.print("�ʰ� �����ð� : ");
		int overHour = sc.nextInt();
		System.out.print("�ʰ� �߰� �����ð� : ");
		int nightHour = sc.nextInt();
		worker[idx++] = new Worker(name, rank, birthday, start, department_code, department_name, 
				phone_number, worker_id, email, address, account_name, account_number, account_owner, pay, hourPay, overHour, nightHour);
	}
	
	//������ ��ü ���
	public void printWorker() {
		for(int i=0 ; i<idx ; i++) {
			System.out.println("�̸�\t : "+worker[i].getName());
			System.out.println("ȸ����ȣ\t : "+worker[i].getPeople_id());
			System.out.println("����ó\t : "+worker[i].getPhone_number());
			System.out.println("����\t : "+worker[i].getBirthday());
			System.out.println("�̸���\t : "+worker[i].getEmail());
			System.out.println("�ּ�\t : "+worker[i].getAddress());
			System.out.println("������ �̸�\t : "+worker[i].getDepartmentName());
			System.out.println("������ ��ȣ\t : "+worker[i].getDepartmentCode());
			System.out.println("ȸ�����\t : "+worker[i].getRank());
			System.out.println("��ϳ�¥\t : "+worker[i].getStart());
			System.out.println("���¹�ȣ\t : "+worker[i].getAccountNumber());
			System.out.println("��������\t : "+worker[i].getAccountName());
			System.out.println("���¿�����\t : "+worker[i].getAccountOwner());
			System.out.println("\t : "+worker[i].getTotal());
			System.out.println("���α�\t : "+worker[i].getTax());
			System.out.println("�Ǽ�����\t : "+worker[i].getRealPay());
		}
		System.out.println();
	}
	
	//������ ���� �˻�
	public void searchWorker() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��ϰ� ���� ȸ���� �̸��� ȸ�� ��ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int worker_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(worker[i].getName().equals(name) && worker[i].getPeople_id() == worker_id) {
				System.out.println("�̸�\t : "+worker[i].getName());
				System.out.println("ȸ����ȣ\t : "+worker[i].getPeople_id());
				System.out.println("��ȣ\t : "+worker[i].getPhone_number());
				System.out.println("����\t : "+worker[i].getBirthday());
				System.out.println("�̸���\t : "+worker[i].getEmail());
				System.out.println("�ּ�\t : "+worker[i].getAddress());
				System.out.println("������ �̸�\t : "+worker[i].getDepartmentName());
				System.out.println("������ ��ȣ\t : "+worker[i].getDepartmentCode());
				System.out.println("ȸ�����\t : "+worker[i].getRank());
				System.out.println("��ϳ�¥\t : "+worker[i].getStart());
				System.out.println("���¹�ȣ\t : "+worker[i].getAccountNumber());
				System.out.println("��������\t : "+worker[i].getAccountName());
				System.out.println("���¿�����\t : "+worker[i].getAccountOwner());
				System.out.println("�Ѽ�����\t : "+worker[i].getTotal());
				System.out.println("���α�\t : "+worker[i].getTax());
				System.out.println("�Ǽ�����\t : "+worker[i].getRealPay());
				System.out.println();
				return;
			}
		}
		System.out.println("��ġ�ϴ� �̸� �� ȸ����ȣ�� �����ϴ�!");
	}
	
	//������ ���� ����
	public void editWorker() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ� ���� ȸ���� �̸��� ȸ����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int worker_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(worker[i].getName().equals(name) && worker[i].getPeople_id() == worker_id) {
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
						worker[i].setName(str_temp);
						break;
						//ȸ����ȣ
					case 2:
						int_temp = sc.nextInt();
						worker[i].setPeople_id(int_temp);
						break;
						//����ó
					case 3:
						int_temp = sc.nextInt();
						worker[i].setPhone_number(int_temp);
						break;
						//����
					case 4:
						int_temp = sc.nextInt();
						worker[i].setBirthday(int_temp);
						break;
						//�̸���
					case 5:
						str_temp = sc.next();
						worker[i].setEmail(str_temp);
						break;
						//�ּ�
					case 6:
						str_temp = sc.next();
						worker[i].setAddress(str_temp);
						break;
						//������ �̸�
					case 7:
						str_temp = sc.next();
						worker[i].setDepartmentName(str_temp);
						break;
						//������ ��ȣ
					case 8:
						int_temp = sc.nextInt();
						worker[i].setDepartmentCode(int_temp);
						break;
						//ȸ�����
					case 9:
						str_temp = sc.next();
						worker[i].setRank(str_temp);
						break;
						//��ϳ�¥
					case 10:
						int_temp = sc.nextInt();
						worker[i].setStart(int_temp);
						break;
						//���¹�ȣ
					case 11:
						str_temp = sc.next();
						worker[i].SetAccountNumber(str_temp);
						break;
						//��������
					case 12:
						str_temp = sc.next();
						worker[i].SetAccountName(str_temp);
						break;
						//���¿�����
					case 13:
						str_temp = sc.next();
						worker[i].SetAccountOwner(str_temp);
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
	
	//�����ڰ� ���� ����
	public void deleteWorker() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��ϰ� ���� ȸ���� �̸��� ȸ����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int worker_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(worker[i].getName().equals(name) && worker[i].getPeople_id() == worker_id) {
				worker[i] = worker[--idx];
				System.out.println("���� �Ϸ�!");
				return;
			}
		}
		System.out.println("��ġ�ϴ� �̸� �� ȸ����ȣ�� �����ϴ�!");
	}
	
	
	//PartTimer Class ����
	
	//administrator is adding the part timer
	void addPartTimer() {
		if(idx2>5) {
			System.out.println("5������� ���� �����մϴ�.");
			return;
		}
		System.out.println("��ȸ�� �߰�!");
		partTimer[idx2] = new PartTimer();
		Scanner sc = new Scanner(System.in);
		partTimer[idx2].setRank("��ȸ��");
		//set the values of part timer
		System.out.print("�̸� : ");
		partTimer[idx2].setName(sc.next());
		System.out.print("���� : ");
		partTimer[idx2].setBirthday(sc.nextInt());
		System.out.print("��ϳ�¥ : ");
		partTimer[idx2].setStart(sc.nextInt());
		System.out.print("������ ��ȣ : ");
		partTimer[idx2].setDepartmentCode(sc.nextInt());
		System.out.print("������ �̸� : ");
		partTimer[idx2].setDepartmentName(sc.next());
		System.out.print("����ó : ");
		partTimer[idx2].setPhone_number(sc.nextInt());;
		System.out.print("ȸ����ȣ : ");
		partTimer[idx2].setPeople_id(sc.nextInt());
		System.out.print("�̸��� : ");
		partTimer[idx2].setEmail(sc.next());
		System.out.print("�ּ� : ");
		partTimer[idx2].setAddress(sc.next());
		System.out.print("���� ����� : ");
		partTimer[idx2].SetAccountName(sc.next());
		System.out.print("���¹�ȣ : ");
		partTimer[idx2].SetAccountNumber(sc.next());
		System.out.print("���� ������ : ");
		partTimer[idx2].SetAccountOwner(sc.next());
		System.out.print("�ð��� ������ : ");
		partTimer[idx2].setHourPay(sc.nextInt());
		System.out.print("��ð� : ");
		partTimer[idx2].setWorkHour(sc.nextInt());
		System.out.print("�ʰ� ��ð� : ");
		partTimer[idx2].setOverHour(sc.nextInt());
		System.out.print("�ʰ� �߰� ��ð� : ");
		partTimer[idx2].setNightHour(sc.nextInt());
		idx2++;
	}
	
	//print all of the part timer
	void printPartTimer() {
		for(int i=0 ; i<idx2 ; i++) {
			System.out.println("�̸�\t : "+partTimer[i].getName());
			System.out.println("ȸ����ȣ\t : "+partTimer[i].getPeople_id());
			System.out.println("����ó\t : "+partTimer[i].getPhone_number());
			System.out.println("����\t : "+partTimer[i].getBirthday());
			System.out.println("�̸���\t : "+partTimer[i].getEmail());
			System.out.println("�ּ�\t : "+partTimer[i].getAddress());
			System.out.println("������ �̸�\t : "+partTimer[i].getDepartmentName());
			System.out.println("������ ��ȣ\t : "+partTimer[i].getDepartmentCode());
			System.out.println("ȸ�����\t : "+partTimer[i].getRank());
			System.out.println("��ϳ�¥\t : "+partTimer[i].getStart());
			System.out.println("���¹�ȣ\t : "+partTimer[i].getAccountNumber());
			System.out.println("��������\t : "+partTimer[i].getAccountName());
			System.out.println("���¿�����\t : "+partTimer[i].getAccountOwner());
			System.out.println("�Ѽ�����\t : "+partTimer[i].getTotalPay());
			System.out.println("���α�\t : "+partTimer[i].getTax());
			System.out.println("�Ǽ�����\t : "+partTimer[i].getRealPay());
			System.out.println();
		}
		System.out.println("��ġ�ϴ� ��ȸ���� �����ϴ�!");
	}
	
	//get name and people_id and searching the match one
	void searchPartTimer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��ϰ� ���� ȸ���� �̸��� ȸ����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(partTimer[i].getName().equals(name) && partTimer[i].getPeople_id() == people_id) {
				System.out.println("�̸�\t : "+partTimer[i].getName());
				System.out.println("ȸ����ȣ\t : "+partTimer[i].getPeople_id());
				System.out.println("����ó\t : "+partTimer[i].getPhone_number());
				System.out.println("����\t : "+partTimer[i].getBirthday());
				System.out.println("�̸���\t : "+partTimer[i].getEmail());
				System.out.println("�ּ�\t : "+partTimer[i].getAddress());
				System.out.println("������ �̸�\t : "+partTimer[i].getDepartmentName());
				System.out.println("������ ��ȣ\t : "+partTimer[i].getDepartmentCode());
				System.out.println("ȸ�����\t : "+partTimer[i].getRank());
				System.out.println("��ϳ�¥\t : "+partTimer[i].getStart());
				System.out.println("���¹�ȣ\t : "+partTimer[i].getAccountNumber());
				System.out.println("��������\t : "+partTimer[i].getAccountName());
				System.out.println("���¿�����\t : "+partTimer[i].getAccountOwner());
				System.out.println("�Ѽ�����\t : "+partTimer[i].getTotalPay());
				System.out.println("���α�\t : "+partTimer[i].getTax());
				System.out.println("�Ǽ�����\t : "+partTimer[i].getRealPay());
				System.out.println();
				return;
			}
		}
		System.out.println("��ġ�ϴ� ��ȸ���� �����ϴ�!");
	}
	
	//get name and people_id and edit the element choose by administrator
	void editPartTimer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ� ���� ȸ���� �̸��� ȸ����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(partTimer[i].getName().equals(name) && partTimer[i].getPeople_id() == people_id) {
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
						partTimer[i].setName(str_temp);
						break;
						//�����ȣ
					case 2:
						int_temp = sc.nextInt();
						partTimer[i].setPeople_id(int_temp);
						break;
						//��ȣ
					case 3:
						int_temp = sc.nextInt();
						partTimer[i].setPhone_number(int_temp);
						break;
						//����
					case 4:
						int_temp = sc.nextInt();
						partTimer[i].setBirthday(int_temp);
						break;
						//�̸���
					case 5:
						str_temp = sc.next();
						partTimer[i].setEmail(str_temp);
						break;
						//�ּ�
					case 6:
						str_temp = sc.next();
						partTimer[i].setAddress(str_temp);
						break;
						//�μ���
					case 7:
						str_temp = sc.next();
						partTimer[i].setDepartmentName(str_temp);
						break;
						//�μ���ȣ
					case 8:
						int_temp = sc.nextInt();
						partTimer[i].setDepartmentCode(int_temp);
						break;
						//�ñ�
					case 9:
						partTimer[i].setHourPay(sc.nextInt());
						break;
						//�Ի���
					case 10:
						int_temp = sc.nextInt();
						partTimer[i].setStart(int_temp);
						break;
						//���¹�ȣ
					case 11:
						str_temp = sc.next();
						partTimer[i].SetAccountNumber(str_temp);
						break;
						//��������
					case 12:
						str_temp = sc.next();
						partTimer[i].SetAccountName(str_temp);
						break;
						//���¿�����
					case 13:
						str_temp = sc.next();
						partTimer[i].SetAccountOwner(str_temp);
						break;
						//�ٹ��ð�
					case 14:
						partTimer[i].setWorkHour(sc.nextInt());
						break;
						//�ʰ��ٹ��ð�
					case 15:
						partTimer[i].setOverHour(sc.nextInt());
						break;
						//�ʰ��߰��ٹ��ð�
					case 16:
						partTimer[i].setNightHour(sc.nextInt());
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
	void deletePartTimer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ� ���� ȸ���� �̸��� ȸ����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(partTimer[i].getName().equals(name) && partTimer[i].getPeople_id() == people_id) {
				partTimer[i] = partTimer[--idx2];
				System.out.println("���� �Ϸ�!");
				return;
			}
		}
		System.out.println("��ġ�ϴ� ��ȸ�� �����ϴ�!");
	}
}
