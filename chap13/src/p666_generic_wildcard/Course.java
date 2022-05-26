package p666_generic_wildcard;

public class Course<T> {
	private String name;
	private T[] students;
	
	public Course(String name, int capacity) {
		this.name = name;
		students = (T[]) (new Object[capacity]);
		// 타입 파라미터로 배열 생성하려면 이형태로 해야 함
	}
	
	public String getName() { return name; }
	public T[] getStudent() { return students; }
	
	// 배열에 비어있는 부분을 찾아서 수강생을 추가하는 메소드
	public void add(T t) {
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}

}
