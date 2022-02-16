package src.com.company.task7.Facade;

public class GPSNotifier {
  public void downloadRoadInfo(){
    System.out.println("Downloading road information...");
    System.out.println("Download complete!");
  }
  public void subscribeRoadChange() {
    System.out.println("subscribed on update info about road");
  }
  public void unSubscribeRoadChange() {
    System.out.println("unsubscribed on update info about road");
  }
}
