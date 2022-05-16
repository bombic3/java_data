
import java.util.*;

public class MainEntry {

	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		// Customer customer = new Customer();
		Scanner sc = new Scanner(System.in);
		int n = 0;

		Boolean flag = true;
		while (flag) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("1. 회원 추가   |   2. 회원 삭제   |   3. 회원 리스트   |   4. 회원 정보 수정   |   5. 종료");
			System.out.println("------------------------------------------------------------------");
			System.out.print("실행할 번호를 입력하세요:");
			n = sc.nextInt();

			switch (n) {
			case 1: // 추가
				System.out.println();
				System.out.println("추가할 회원의 정보를 입력하세요.");
				System.out.println("---------------------");
				System.out.print("이름: ");
				String name = sc.next();
				System.out.print("주소: ");
				String address = sc.next();
				System.out.print("연락처: ");
				String phone = sc.next();
				System.out.print("회원번호: ");
				String id = sc.next();
				System.out.print("프로그램: ");
				String program = sc.next();
				System.out.print("강사: ");
				String instructor = sc.next();
				System.out.print("등록일: ");
				String start = sc.next();
				System.out.print("추천인: ");
				String friend = sc.next();
				
				customers.add(new Customer(name, address, phone, id, program, instructor, start, friend ));
				System.out.println("추가 되었습니다!");
				break;

			case 2: // 삭제
				System.out.println();
				System.out.println("삭제할 회원의 이름을 입력하세요.");
				System.out.println("---------------------");
				System.out.print("이름: ");
				name = sc.next();
				for (int i = 0; i < customers.size(); i++) {
					if (name.equals(customers.get(i).getName())) {
						customers.remove(i);
						System.out.println("삭제되었습니다!");
					} else
						System.out.println("회원이 존재하지 않습니다.");
				}
				break;

			case 3: // 리스트 출력
				System.out.println();
				for (Customer customer : customers)
					System.out.println(customer);

			case 4: // 수정
				System.out.println();
				System.out.print("수정할 회원의 이름을 입력하세요.");
				name = sc.next();
				for (int i = 0; i < customers.size(); i++) {
					if (name.equals(customers.get(i).getName())) {

						System.out.print("수정하실 항목을 선택하세요. (1)이름  (2)주소  (3)연락처  (4)회원번호  (5)프로그램  (6)강사  (7)등록일자  (8)추천인  ");
						n = sc.nextInt();
						System.out.println();

						switch (n) {
						case 1:
							System.out.print("이름을 새로 입력하세요.");
							name = sc.next();
							customers.get(i).setName(name);
							break;
						case 2:
							System.out.print("주소를 새로 입력하세요.");
							address = sc.next();
							customers.get(i).setAddress(address);
							break;
						case 3:
							System.out.print("연락처를 새로 입력하세요.");
							phone = sc.next();
							customers.get(i).setPhone(phone);
							break;
							
						case 4:
							System.out.print("회원번호를 새로 입력하세요.");
							id = sc.next();
							customers.get(i).setId(id);	
							break;
							
						case 5:
							System.out.print("프로그램을 새로 입력하세요.");
							program = sc.next();
							customers.get(i).setProgram(program);
							break;
							
						case 6:
							System.out.print("강사를 새로 입력하세요.");
							instructor = sc.next();
							customers.get(i).setInstructor(instructor);
							break;
							
							
						case 7:
							System.out.print("등록일자를 새로 입력하세요.");
							start = sc.next();
							customers.get(i).setStart(start);	
							break;
							
						case 8:
							System.out.print("추천인을 새로 입력하세요.");
							friend = sc.next();
							customers.get(i).setFriend(friend);	
							break;
							
							
						}
						System.out.println("수정되었습니다!");

					} else
						System.out.println("잘못된 정보입니다.");
				}

				break;

			case 5:
				flag = false;
				System.out.println("시스템이 종료되었습니다.");
				break;

			default:
				System.out.println("1 ~ 5 까지의 숫자만 입력하세요.");
				break;

			}

		}

	}

}