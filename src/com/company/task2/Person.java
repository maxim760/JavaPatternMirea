package src.com.company.task2;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;

public class Person {
  private static final Random random = new Random();
  private int weight;
  private String surname;
  private int age;
  private LocalDate birthDate;

  public Person(int weight, String surname, int age) {
    this.weight = weight;
    this.surname = surname;
    this.age = age;
    int year =  Calendar.getInstance().get(Calendar.YEAR);
    this.birthDate = LocalDate.of(year - age, random.nextInt(12) + 1, random.nextInt(20) + 1);
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
  private static String[] surnames = {
      "Ivanov",
      "Petrov",
      "Sobolev",
      "Markin",
      "Ivanovsky",
      "Petrenko"
  };
  public static Person generatePerson() {
    int age = random.nextInt(90) + 10; // 10 - 100
    int w = random.nextInt(50) + 30; // 30 - 80
    int surnameIndex = random.nextInt(surnames.length);
    return new Person(w, surnames[surnameIndex], age );
  }

  @Override
  public String toString() {
    return surname + " " + weight + " кг" + ", " + age + " лет, родился:" + birthDate.getYear() + " " + birthDate.getMonth().toString() + " " + birthDate.getDayOfMonth();
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getAge() {
    return age;
  }
  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
