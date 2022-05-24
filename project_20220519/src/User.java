/*
 * 사용자 클래스
 * 관리자 아이디와 비밀번호를 입력하면 관리자로 로그인이 가능하다.
 * 일반 사람의 이름과 사원 번호를 확인하여 해당 사람의 객체를 받아온다.
 * 정보 조회 및 제한적 수정이 가능하다.
 */

//희인


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
			System.out.println("이름\t : "+member.getName());
			System.out.println("회원번호\t : "+member.getPeople_id());
			System.out.println("연락처\t : "+member.getPhone_number());
			System.out.println("생일\t : "+member.getBirthday());
			System.out.println("이메일\t : "+member.getEmail());
			System.out.println("주소\t : "+member.getAddress());
			System.out.println("수강반 이름\t : "+member.getDepartmentName());
			System.out.println("수강반 번호\t : "+member.getDepartmentCode());
			System.out.println("회원등급\t : "+member.getMembership());
			System.out.println("등록날짜\t : "+member.getStart());
			System.out.println("계좌번호\t : "+member.getAccountNumber());
			System.out.println("계좌은행\t : "+member.getAccountName());
			System.out.println("계좌예금주\t : "+member.getAccountOwner());
			System.out.println("총 수강비\t : "+member.getTotal());
			System.out.println("부가세\t : "+member.getSurtax());
			System.out.println("실 수강비\t : "+member.getRealTui());
			System.out.println();
		}
		else {
			System.out.println("이름\t : "+nonMember.getName());
			System.out.println("회원번호\t : "+nonMember.getPeople_id());
			System.out.println("연락처\t : "+nonMember.getPhone_number());
			System.out.println("생일\t : "+nonMember.getBirthday());
			System.out.println("이메일\t : "+nonMember.getEmail());
			System.out.println("주소\t : "+nonMember.getAddress());
			System.out.println("수강반 이름\t : "+nonMember.getDepartmentName());
			System.out.println("수강실 번호\t : "+nonMember.getDepartmentCode());
			System.out.println("회원번호\t : "+nonMember.getMembership());
			System.out.println("등록날짜\t : "+nonMember.getStart());
			System.out.println("계좌번호\t : "+nonMember.getAccountNumber());
			System.out.println("계좌은행\t : "+nonMember.getAccountName());
			System.out.println("계좌예금주\t : "+nonMember.getAccountOwner());
			System.out.println("총 수강비\t : "+nonMember.getTotalTui());
			System.out.println("할인액\t : "+nonMember.getSurtax());
			System.out.println("실 수강비\t : "+nonMember.getRealTui());
			System.out.println();
		}
	}
	
	//동적바인딩 이용
	public void edit() {
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("1.연락처 2.이메일 3.주소 4.계좌번호 5.계좌은행 6.계좌예금주 7.종료");
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
				System.out.println("잘못 된 입력입니다.");
			}
		}
	}
}