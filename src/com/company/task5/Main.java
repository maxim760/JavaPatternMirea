package src.com.company.task5;

public class Main {
  public static void main(String[] args) {
    testSingleton1();
    testSingleton2();
    testSingleton3();
  }
  public static void testSingleton1() {
    System.out.println("singleton 1");
    Singleton1 s1 = Singleton1.INSTANCE;
    System.out.println(s1.getCount());
    s1.incCount();
    s1.incCount();
    Singleton1 s2 = Singleton1.INSTANCE;
    s1.decCount();
    Singleton1 s3 = Singleton1.INSTANCE;
    s3.incCount();
    s3.incCount();
    System.out.println(s1.getCount() + " | " + s2.getCount() + " | " + s3.getCount());
  }
  public static void testSingleton2() {
    System.out.println("singleton 2");
    Singleton2 s1 = Singleton2.getInstance();
    System.out.println(s1.getCount());
    s1.incCount();
    s1.incCount();
    Singleton2 s2 = Singleton2.getInstance();
    s1.decCount();
    Singleton2 s3 = Singleton2.getInstance();
    s3.incCount();
    s3.incCount();
    System.out.println(s1.getCount() + " | " + s2.getCount() + " | " + s3.getCount());
  }
  public static void testSingleton3() {
    System.out.println("singleton 3");
    Singleton3 s1 = Singleton3.INSTANCE;
    System.out.println(s1.getCount());
    s1.incCount();
    s1.incCount();
    Singleton3 s2 = Singleton3.INSTANCE;
    s1.decCount();
    Singleton3 s3 = Singleton3.INSTANCE;
    s3.incCount();
    s3.incCount();
    System.out.println(s1.getCount() + " | " + s2.getCount() + " | " + s3.getCount());
  }
}
