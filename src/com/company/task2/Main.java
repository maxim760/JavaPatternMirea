package src.com.company.task2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Person> persons = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      persons.add(Person.generatePerson());
      System.out.println(persons.get(i));
    }
    System.out.println("\n\nвозраст > вес");
    persons
        .stream()
        .filter((p) -> p.getAge() > p.getWeight())
        .forEach(p -> System.out.println(p));

    System.out.println("сортировка по дате");
    persons
        .stream()
        .sorted(new Comparator<Person>() {
          @Override
          public int compare(Person o1, Person o2) {
            LocalDate date1 = o1.getBirthDate();
            LocalDate date2 = o2.getBirthDate();
            int cmp = date1.getYear() - date2.getYear();
            if(cmp == 0) {
              cmp = date1.getDayOfYear() - date2.getDayOfYear();
            }
            return cmp;
          }
        })
        .forEach(p -> System.out.println(p));
    System.out.println("Возрасты произведение");
    BigInteger res = persons
        .stream()
        .map(p -> p.getAge())
        .map(num -> BigInteger.valueOf(num))
        .reduce(BigInteger.ONE, (a, b) -> a.multiply(b));
    System.out.println(res);
    System.out.println("Сортировака по последнкй букве фамилии");
    persons
        .stream()
        .sorted(new Comparator<Person>() {
          @Override
          public int compare(Person o1, Person o2) {
            char letter1 = o1.getSurname().charAt(o1.getSurname().length() - 1);
            char letter2 = o2.getSurname().charAt(o2.getSurname().length() - 1);
            return Character.toString(letter1).compareToIgnoreCase(Character.toString(letter2));
          }
        })
        .forEach(p -> System.out.println(p));
  }
}
