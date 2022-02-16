package src.com.company.task5;

public class Singleton1 {
  public static final Singleton1 INSTANCE = new Singleton1();
  private int count = 0;
  private Singleton1() {};
  public void incCount() {
    this.count += 1;
  }
  public void decCount() {
    this.count -= 1;
  }
  public int getCount() {
    return count;
  }
}
