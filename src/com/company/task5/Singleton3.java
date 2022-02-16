package src.com.company.task5;

public enum Singleton3 {
  INSTANCE;

  private int count = 0;
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
