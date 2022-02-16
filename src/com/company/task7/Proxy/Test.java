package src.com.company.task7.Proxy;

public class Test {
  public static void main(String[] args) {
    IDatabase base = new ProxyDatabase();
    base.updateData();
    base.updateData();
  }
}
