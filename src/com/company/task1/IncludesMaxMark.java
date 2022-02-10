package src.com.company.task1;

import java.util.function.Predicate;

public class IncludesMaxMark<E> implements Predicate<Student[]> {
  @Override
  public boolean test(Student[] list) {
    for (int i = 0; i <= list.length - 1; i++) {
      if(list[i].mark == Student.MAX_MARK) {
        return true;
      }
    }
    return false;
  }
}
