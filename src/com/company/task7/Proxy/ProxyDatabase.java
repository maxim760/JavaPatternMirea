package src.com.company.task7.Proxy;

public class ProxyDatabase implements IDatabase {
  // Logger
  Database proxy;
  public ProxyDatabase() {
    proxy = new Database();
  }
  public void updateData() {
    proxy.updateData();
    System.out.println("data updated");
  }
}
