package src.com.company.task7.Facade;

public class Test {
  public static void main(String[] args) throws InterruptedException {
    GPSPower power = new GPSPower();
    GPSNotifier notifier= new GPSNotifier();
    RoadAdvisor advisor = new RoadAdvisor();
    GPSInterface gui = new GPSInterface(power, notifier, advisor);
    gui.activate();
    Thread.sleep(2000);
    gui.terminate();
  }
}
