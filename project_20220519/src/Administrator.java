/*
 * 관리자 클래스
 * 관리자
 *  - 모든 사람 정보 출력
 *  - 정회원 / 비회원 추가
 *  - 정보 수정
 *  - 이름 / 회원번호 검색하여 출력
 *  - 이름 / 회원번호 검색하여 삭제
 *  
 *  사용자가 이름 / 회원번호를 입력 시 해당 객체를 돌려준다.
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
	
	//관리자 생성자 -> 사람을 50명까지 생성 가능하다. (has a)
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
	
	//Member Class 제어
	
	//관리자 사람 추가
	public void addMember() {
		if(idx>49) {
			System.out.println("50명까지만 생성 가능합니다.");
			return;
		}
		System.out.println("회원 추가!");
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		String membership = null;
		while(true) {
			System.out.println("1.초급 A반(오전) 2.초급 B반(오후) 3.중급 A반(오전) 4.중급 B반(오후) 5.고급 A반(오전)");
			System.out.print("회원등급 : ");
			int c = sc.nextInt();
			if(c==1) {
				membership = "초급 A반(오전)";
				break;
			}
			else if(c==2) {
				membership = "초급 B반(오후)";
				break;
			}
			else if(c==3) {
				membership = "중급 A반(오전)";
				break;
			}
			else if(c==4) {
				membership = "중급 B반(오후)";
				break;
			}
			else if(c==5) {
				membership = "고급 A반(오전)";
				break;
			}
			System.out.println("잘못 된 회원등급입니다!");
		}
		System.out.print("생일 : ");
		int birthday = sc.nextInt();
		System.out.print("등록날짜 : ");
		int start = sc.nextInt();
		System.out.print("수강실 번호 : ");
		int department_code = sc.nextInt();
		System.out.print("수강반 이름 : ");
		String department_name = sc.next();
		System.out.print("연락처 : ");
		int phone_number = sc.nextInt();
		System.out.print("회원번호 : ");
		int member_id = sc.nextInt();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("주소 : ");
		String address = sc.next();
		System.out.print("계좌 은행명 : ");
		String account_name = sc.next();
		System.out.print("계좌번호 : ");
		String account_number = sc.next();
		System.out.print("계좌 예금주 : ");
		String account_owner = sc.next();
		System.out.print("수강비 : ");
		int tui = sc.nextInt();
		System.out.print("초과 수강비 : ");
		int hourTui = sc.nextInt();
		System.out.print("초과 운동시간 : ");
		int overTime = sc.nextInt();
		System.out.print("초과 야간 운동시간 : ");
		int nightTime = sc.nextInt();
		member[idx++] = new Member(name, membership, birthday, start, department_code, department_name, 
				phone_number, member_id, email, address, account_name, account_number, account_owner, tui, hourTui, overTime, nightTime);
	}
	
	//관리자 전체 출력
	public void printMember() {
		for(int i=0 ; i<idx ; i++) {
			System.out.println("이름\t : "+member[i].getName());
			System.out.println("회원번호\t : "+member[i].getPeople_id());
			System.out.println("연락처\t : "+member[i].getPhone_number());
			System.out.println("생일\t : "+member[i].getBirthday());
			System.out.println("이메일\t : "+member[i].getEmail());
			System.out.println("주소\t : "+member[i].getAddress());
			System.out.println("수강반 이름\t : "+member[i].getDepartmentName());
			System.out.println("수강실 번호\t : "+member[i].getDepartmentCode());
			System.out.println("회원등급\t : "+member[i].getMembership());
			System.out.println("등록날짜\t : "+member[i].getStart());
			System.out.println("계좌번호\t : "+member[i].getAccountNumber());
			System.out.println("계좌은행\t : "+member[i].getAccountName());
			System.out.println("계좌예금주\t : "+member[i].getAccountOwner());
			System.out.println("총수강비\t : "+member[i].getTotal());
			System.out.println("할인금\t : "+member[i].getSurtax());
			System.out.println("실수강비\t : "+member[i].getRealTui());
		}
		System.out.println();
	}
	
	//관리자 정회원 검색
	public void searchMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하고 싶은 회원의 이름과 회원 번호를 입력하세요 : ");
		String name = sc.next();
		int member_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(member[i].getName().equals(name) && member[i].getPeople_id() == member_id) {
				System.out.println("이름\t : "+member[i].getName());
				System.out.println("회원번호\t : "+member[i].getPeople_id());
				System.out.println("번호\t : "+member[i].getPhone_number());
				System.out.println("생일\t : "+member[i].getBirthday());
				System.out.println("이메일\t : "+member[i].getEmail());
				System.out.println("주소\t : "+member[i].getAddress());
				System.out.println("수강반 이름\t : "+member[i].getDepartmentName());
				System.out.println("수강실 번호\t : "+member[i].getDepartmentCode());
				System.out.println("회원등급\t : "+member[i].getMembership());
				System.out.println("등록날짜\t : "+member[i].getStart());
				System.out.println("계좌번호\t : "+member[i].getAccountNumber());
				System.out.println("계좌은행\t : "+member[i].getAccountName());
				System.out.println("계좌예금주\t : "+member[i].getAccountOwner());
				System.out.println("총수강비\t : "+member[i].getTotal());
				System.out.println("총수강비\t : "+member[i].getSurtax());
				System.out.println("실수강비\t : "+member[i].getRealTui());
				System.out.println();
				return;
			}
		}
		System.out.println("일치하는 이름 및 회원번호가 없습니다!");
	}
	
	//관리자 정회원 수정
	public void editMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정하고 싶은 회원의 이름과 회원번호를 입력하세요 : ");
		String name = sc.next();
		int member_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(member[i].getName().equals(name) && member[i].getPeople_id() == member_id) {
				while(true) {
					System.out.println("무엇을 수정하시겠습니까?");
					System.out.println("1.이름 2.회원번호 3.연락처 4.생일 5.이메일 6.주소 7.수강반 이름 "
							+ "8.수강실 번호 9.회원등급 10.등록날짜 11.계좌번호 12.계좌은행 13.계좌예금주 14.종료");
					int choice = sc.nextInt();
					String str_temp;
					int int_temp;
					switch(choice) {
					//이름
					case 1:
						str_temp = sc.next();
						member[i].setName(str_temp);
						break;
						//회원번호
					case 2:
						int_temp = sc.nextInt();
						member[i].setPeople_id(int_temp);
						break;
						//연락처
					case 3:
						int_temp = sc.nextInt();
						member[i].setPhone_number(int_temp);
						break;
						//생일
					case 4:
						int_temp = sc.nextInt();
						member[i].setBirthday(int_temp);
						break;
						//이메일
					case 5:
						str_temp = sc.next();
						member[i].setEmail(str_temp);
						break;
						//주소
					case 6:
						str_temp = sc.next();
						member[i].setAddress(str_temp);
						break;
						//수강반 이름
					case 7:
						str_temp = sc.next();
						member[i].setDepartmentName(str_temp);
						break;
						//수강실 번호
					case 8:
						int_temp = sc.nextInt();
						member[i].setDepartmentCode(int_temp);
						break;
						//회원등급
					case 9:
						str_temp = sc.next();
						member[i].setMembership(str_temp);
						break;
						//등록날짜
					case 10:
						int_temp = sc.nextInt();
						member[i].setStart(int_temp);
						break;
						//계좌번호
					case 11:
						str_temp = sc.next();
						member[i].SetAccountNumber(str_temp);
						break;
						//계좌은행
					case 12:
						str_temp = sc.next();
						member[i].SetAccountName(str_temp);
						break;
						//계좌예금주
					case 13:
						str_temp = sc.next();
						member[i].SetAccountOwner(str_temp);
						break;
					case 14:
						return;
					default:
						System.out.println("잘못 된 입력");
					}
				}
			}
		}
		System.out.println("일치하는 이름 및 회원번호가 없습니다!");
	}
	
	//관리자가 정회원 삭제
	public void deleteMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하고 싶은 회원의 이름과 회원번호를 입력하세요 : ");
		String name = sc.next();
		int member_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(member[i].getName().equals(name) && member[i].getPeople_id() == member_id) {
				member[i] = member[--idx];
				System.out.println("삭제 완료!");
				return;
			}
		}
		System.out.println("일치하는 이름 및 회원번호가 없습니다!");
	}
	
	
	//NonMember Class 제어
	
	//administrator is adding the non member
	void addNonMember() {
		if(idx2>5) {
			System.out.println("5명까지만 생성 가능합니다.");
			return;
		}
		System.out.println("비회원 추가!");
		nonMember[idx2] = new NonMember();
		Scanner sc = new Scanner(System.in);
		nonMember[idx2].setMembership("비회원");
		//set the values of non member
		System.out.print("이름 : ");
		nonMember[idx2].setName(sc.next());
		System.out.print("생일 : ");
		nonMember[idx2].setBirthday(sc.nextInt());
		System.out.print("등록날짜 : ");
		nonMember[idx2].setStart(sc.nextInt());
		System.out.print("수강실 번호 : ");
		nonMember[idx2].setDepartmentCode(sc.nextInt());
		System.out.print("수강반 이름 : ");
		nonMember[idx2].setDepartmentName(sc.next());
		System.out.print("연락처 : ");
		nonMember[idx2].setPhone_number(sc.nextInt());;
		System.out.print("회원번호 : ");
		nonMember[idx2].setPeople_id(sc.nextInt());
		System.out.print("이메일 : ");
		nonMember[idx2].setEmail(sc.next());
		System.out.print("주소 : ");
		nonMember[idx2].setAddress(sc.next());
		System.out.print("계좌 은행명 : ");
		nonMember[idx2].SetAccountName(sc.next());
		System.out.print("계좌번호 : ");
		nonMember[idx2].SetAccountNumber(sc.next());
		System.out.print("계좌 예금주 : ");
		nonMember[idx2].SetAccountOwner(sc.next());
		System.out.print("시간당 수강비 : ");
		nonMember[idx2].setHourTui(sc.nextInt());
		System.out.print("운동시간 : ");
		nonMember[idx2].setWorkoutTime(sc.nextInt());
		System.out.print("초과 운동시간 : ");
		nonMember[idx2].setOverTime(sc.nextInt());
		System.out.print("초과 야간 운동시간 : ");
		nonMember[idx2].setNightTime(sc.nextInt());
		idx2++;
	}
	
	//print all of the non member
	void printNonMember() {
		for(int i=0 ; i<idx2 ; i++) {
			System.out.println("이름\t : "+nonMember[i].getName());
			System.out.println("회원번호\t : "+nonMember[i].getPeople_id());
			System.out.println("연락처\t : "+nonMember[i].getPhone_number());
			System.out.println("생일\t : "+nonMember[i].getBirthday());
			System.out.println("이메일\t : "+nonMember[i].getEmail());
			System.out.println("주소\t : "+nonMember[i].getAddress());
			System.out.println("수강반 이름\t : "+nonMember[i].getDepartmentName());
			System.out.println("수강실 번호\t : "+nonMember[i].getDepartmentCode());
			System.out.println("회원등급\t : "+nonMember[i].getMembership());
			System.out.println("등록날짜\t : "+nonMember[i].getStart());
			System.out.println("계좌번호\t : "+nonMember[i].getAccountNumber());
			System.out.println("계좌은행\t : "+nonMember[i].getAccountName());
			System.out.println("계좌예금주\t : "+nonMember[i].getAccountOwner());
			System.out.println("총수강비\t : "+nonMember[i].getTotalTui());
			System.out.println("부가세\t : "+nonMember[i].getSurtax());
			System.out.println("실수강비\t : "+nonMember[i].getRealTui());
			System.out.println();
		}
	}
	
	//get name and people_id and searching the match one
	void searchNonMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하고 싶은 회원의 이름과 회원번호를 입력하세요 : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(nonMember[i].getName().equals(name) && nonMember[i].getPeople_id() == people_id) {
				System.out.println("이름\t : "+nonMember[i].getName());
				System.out.println("회원번호\t : "+nonMember[i].getPeople_id());
				System.out.println("연락처\t : "+nonMember[i].getPhone_number());
				System.out.println("생일\t : "+nonMember[i].getBirthday());
				System.out.println("이메일\t : "+nonMember[i].getEmail());
				System.out.println("주소\t : "+nonMember[i].getAddress());
				System.out.println("수강반 이름\t : "+nonMember[i].getDepartmentName());
				System.out.println("수강실 번호\t : "+nonMember[i].getDepartmentCode());
				System.out.println("회원등급\t : "+nonMember[i].getMembership());
				System.out.println("등록날짜\t : "+nonMember[i].getStart());
				System.out.println("계좌번호\t : "+nonMember[i].getAccountNumber());
				System.out.println("계좌은행\t : "+nonMember[i].getAccountName());
				System.out.println("계좌예금주\t : "+nonMember[i].getAccountOwner());
				System.out.println("총수강비\t : "+nonMember[i].getTotalTui());
				System.out.println("부가세\t : "+nonMember[i].getSurtax());
				System.out.println("실수강비\t : "+nonMember[i].getRealTui());
				System.out.println();
				return;
			}
		}
		System.out.println("일치하는 비회원이 없습니다!");
	}
	
	//get name and people_id and edit the element choose by administrator
	void editNonMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정하고 싶은 회원의 이름과 회원번호를 입력하세요 : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(nonMember[i].getName().equals(name) && nonMember[i].getPeople_id() == people_id) {
				while(true) {
					System.out.println("무엇을 수정하시겠습니까?");
					System.out.println("1.이름 2.회원번호 3.연락처 4.생일 5.이메일 6.주소 7.수강반 이름 "
							+ "8.수강반 번호 9.시간당 수강료 10.등록일 11.계좌번호 12.계좌은행 13.계좌예금주 "
							+ "14.운동시간 15.초과운동시간 16.초과야간운동시간 17.종료");
					int choice = sc.nextInt();
					String str_temp;
					int int_temp;
					switch(choice) {
					//이름
					case 1:
						str_temp = sc.next();
						nonMember[i].setName(str_temp);
						break;
						//회원번호
					case 2:
						int_temp = sc.nextInt();
						nonMember[i].setPeople_id(int_temp);
						break;
						//번호
					case 3:
						int_temp = sc.nextInt();
						nonMember[i].setPhone_number(int_temp);
						break;
						//생일
					case 4:
						int_temp = sc.nextInt();
						nonMember[i].setBirthday(int_temp);
						break;
						//이메일
					case 5:
						str_temp = sc.next();
						nonMember[i].setEmail(str_temp);
						break;
						//주소
					case 6:
						str_temp = sc.next();
						nonMember[i].setAddress(str_temp);
						break;
						//수강반
					case 7:
						str_temp = sc.next();
						nonMember[i].setDepartmentName(str_temp);
						break;
						//수강실 번호
					case 8:
						int_temp = sc.nextInt();
						nonMember[i].setDepartmentCode(int_temp);
						break;
						//시간당 수강비
					case 9:
						nonMember[i].setHourTui(sc.nextInt());
						break;
						//등록일
					case 10:
						int_temp = sc.nextInt();
						nonMember[i].setStart(int_temp);
						break;
						//계좌번호
					case 11:
						str_temp = sc.next();
						nonMember[i].SetAccountNumber(str_temp);
						break;
						//계좌은행
					case 12:
						str_temp = sc.next();
						nonMember[i].SetAccountName(str_temp);
						break;
						//계좌예금주
					case 13:
						str_temp = sc.next();
						nonMember[i].SetAccountOwner(str_temp);
						break;
						//운동시간
					case 14:
						nonMember[i].setWorkoutTime(sc.nextInt());
						break;
						//초과 운동시간
					case 15:
						nonMember[i].setOverTime(sc.nextInt());
						break;
						//초과 야간 운동시간
					case 16:
						nonMember[i].setNightTime(sc.nextInt());
						break;
						//종료
					case 17:
						return;
					default:
						System.out.println("잘못 된 입력");
					}
				}
			}
		}
		System.out.println("일치하는 비회원이 없습니다!");
	}
	
	//get name and people_id and delete the element and swap with last one
	void deleteNonMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제하고 싶은 회원의 이름과 회원번호를 입력하세요 : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(nonMember[i].getName().equals(name) && nonMember[i].getPeople_id() == people_id) {
				nonMember[i] = nonMember[--idx2];
				System.out.println("삭제 완료!");
				return;
			}
		}
		System.out.println("일치하는 비회원 없습니다!");
	}
}