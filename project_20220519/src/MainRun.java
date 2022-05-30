import java.util.*;


public class MainRun {
	private User user;
	private Administrator administrator;
	
	public MainRun() {
		administrator = new Administrator();
	}
	
	//로그인
	//관리자가 로그인을 판단한다.
	public void login() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("피트니스센터 회원 정보 포털에 오신 것을 환영합니다!");
			System.out.println("로그인을 통하여 정보를 조회하실 수 있습니다.");
			System.out.println("직원은 이름을 ID로 사원번호를 비밀번호(숫자)로 사용합니다.");
			System.out.println("ID에 0을 입력 시 프로그램을 종료합니다.");
			System.out.print("ID : ");
			String ID = sc.next();
			
			if(ID.equals("0")) {
				System.out.println("프로그램 종료..");
				System.exit(-1);                    //0을 누르면 프로그램 종료
			}
			
			System.out.print("PW : ");
			int PW = sc.nextInt();                //비밀번호 기입
			
			
			int result = administrator.check(ID, PW);
			
			if(result==1000) {
				this.adminRun();
			}
			else if(result >= 0 && result < 50) {
				user = new User(administrator.getMember(result));
				this.userRun();
			}
			else if(result >= 50 && result < 55) {
				user = new User(administrator.getNonMember(result-50));
				this.userRun();
			}
			else {
				System.out.println("로그인 실패! 일치하는 정보가 없습니다.");
			}
		}
	}
	
	public void userRun() {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("1.조회 2.수정 3.종료");
			choice = sc.nextInt();
			if(choice==1) {            //1을 누르면 조회
				user.print();
			}
			else if(choice==2) {       //2를 누르면 수정
				user.edit();
			}
			else if(choice==3) {       //3을 누르면 종료
				break;
			}
			else {
				System.out.println("잘못 된 입력입니다.");    //그 외의 값을 입력 시
			}
		}
	}
	
	public void adminRun() {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("1.정회원 2.비회원 3.종료");
			choice = sc.nextInt();
			if(choice == 1) {
				while(true) {
					System.out.println("1.회원추가 2.전체조회 3.검색 4.수정 5.삭제 6.종료");
					choice = sc.nextInt();
					if(choice==1) {
						administrator.addMember();        //1을 누르면 정회원추가
					}
					else if(choice==2) {
						administrator.printMember();      //2를 누르면 전체조회
					}
					else if(choice==3) {
						administrator.searchMember();     //3을 누르면 정회원검색
					}
					else if(choice==4) {
						administrator.editMember();       //4를 누르면 정회원수정
					}
					else if(choice==5) {
						administrator.deleteMember();     //5를 누르면 정회원삭제
					}
					else if(choice==6) {                //6을 누르면 종료
						break;
					}
					else {
						System.out.println("잘못 된 입력입니다.");   //그 외의 값을 입력 시
					}
				}
			}
			else if(choice == 2) {
				while(true) {
					System.out.println("1.회원추가 2.전체조회 3.검색 4.수정 5.삭제 6.종료");
					choice = sc.nextInt();
					if(choice==1) {
						administrator.addNonMember();      //1을 누르면 비회원추가
					} 
					else if(choice==2) {
						administrator.printNonMember();    //2를 누르면 전체조회
					}
					else if(choice==3) {
						
						administrator.searchNonMember();   //3을 누르면 비회원검색
					}
					else if(choice==4) {
						administrator.editNonMember();     //4를 누르면 비회원수정
					}
					else if(choice==5) {
						administrator.deleteNonMember();   //5를 누르면 비회원삭제
					}
					else if(choice==6) {                 //6을 누르면 종료
						break;
					}
					else {
						System.out.println("잘못 된 입력입니다.");    //그 외의 값을 입력 시
					}
				}
			}
			else if(choice == 3) {
				break;
			}
			else {
				System.out.println("잘못 된 선택입니다!");
			}
		}
		System.out.println("프로그램 종료");
	}
	
	
	public static void main(String[] args) {
		MainRun mainRun = new MainRun();
		mainRun.login();
	}
}