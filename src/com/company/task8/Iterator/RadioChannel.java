package src.com.company.task8.Iterator;

public class RadioChannel {
  private double freq;
  private String name;
  private RadioType type;

  public RadioChannel(double freq, String name, RadioType type) {
    this.freq = freq;
    this.name = name;
    this.type = type;
  }

  public double getFreq() {
    return freq;
  }

  public String getName() {
    return name;
  }
  public RadioType getType() {
    return type;
  }

  @Override
  public String toString() {
    return getName() + " " + getFreq() + " " + getType().toString();
  }
}
