package p695;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

//한 덩어리를 잡으라고 하는게 List. 정수 실수 상관 없이
public class FunctionExample2 {
   private static List<Student> list = Arrays.asList(  
      new Student("홍길동",90,96),
      new Student("신용권",95,93)
   );
   
 //ToIntFunction은 우리가 만든 함수가 아니라 예약어로 우리가 가져다 쓰는거.
 // -> 정수만 가져와서 돌려라
   public static double avg( ToIntFunction<Student> function ) { 
      int sum = 0;
      for(Student student : list) {
         sum += function.applyAsInt(student);
      }
      
         double avg = (double) sum / list.size();
         return avg;
   }
      
   public static void main(String[] args) {
      double englishAvg = avg(  s -> s.getEnglishScore() );
      System.out.println("영어 평균 점수: " + englishAvg);
      
      double mathAvg = avg( s -> s.getMathScore() );
      System.out.println("수학 평균 점수: " + mathAvg);
   }
}