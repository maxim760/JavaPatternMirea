package src.com.company.task1;
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {
    Student st1 = new Student(95);
    Student st2 = new Student(25);
    Student st3 = new Student(55);
    Student st4 = new Student(100);
    Student[] students1 = {st1, st2, st3};
    Student[] students2 = {st1, st2, st3, st4};
    Predicate<Student[]> isIncludesMaxMark = ((list) -> {
      for (int i = 0; i <= list.length - 1; i++) {
        if(list[i].mark == Student.MAX_MARK) {
          return true;
        }
      }
      return false;
    });
    System.out.println(isIncludesMaxMark.test(students1)); // false
    System.out.println(isIncludesMaxMark.test(students2)); // true
  }
}
