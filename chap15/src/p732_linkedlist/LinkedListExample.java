package p732_linkedlist;

//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
import java.util.*;

public class LinkedListExample {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long starTime;
		long endTime;
		
		starTime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("AraayList 걸린시간 : " + (endTime-starTime) + " ns");

		starTime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("AraayList 걸린시간 : " + (endTime-starTime) + " ns");

	}

}
