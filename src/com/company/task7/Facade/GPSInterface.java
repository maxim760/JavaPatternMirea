package src.com.company.task7.Facade;

class GPSInterface{
  private GPSPower power;
  private GPSNotifier notifier;
  private RoadAdvisor advisor;

  public GPSInterface(GPSPower power, GPSNotifier notifier, RoadAdvisor advisor){
    this.power = power;
    this.notifier = notifier;
    this.advisor = advisor;
  }

  public void activate() {
    power.powerOn();
    notifier.downloadRoadInfo();
    notifier.subscribeRoadChange();
    advisor.route();
  }
  public void terminate() {
    notifier.unSubscribeRoadChange();
    power.powerOff();
  }
}
