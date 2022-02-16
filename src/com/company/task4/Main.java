package src.com.company.task4;

public class Main {
  public static void main(String[] args) {
    MyExecutorService service = new MyExecutorService(2);
    service.submit(() -> {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        System.out.println("service 1");
      }
    });
    service.submit(() -> {
      try {
        Thread.sleep(4000);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        System.out.println("service 2");
      }
    });
    service.submit(() -> {
      try {
        Thread.sleep(500);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        System.out.println("service 3");
      }
    });
    service.submit(() -> {
      try {
        Thread.sleep(100);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        System.out.println("service 4");
      }
    });
  }
}
