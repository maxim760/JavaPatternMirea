package src.com.company.task5;

public class Singleton2 {
  private int count = 0;
  private static Singleton2 instance;
  private Singleton2() {}
  public static synchronized Singleton2 getInstance() {
    if(instance == null) {
      instance = new Singleton2();
      return instance;
    }
    return instance;
  }

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
