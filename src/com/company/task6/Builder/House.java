package src.com.company.task6.Builder;

import java.util.Arrays;
import java.util.stream.Collectors;

public class House {
  private final String fence;
  private final String swimmingPool;
  private final String garage;

  public House(String fence, String swimmingPool, String garage) {
    this.fence = fence;
    this.swimmingPool = swimmingPool;
    this.garage = garage;
  }

  public String getFence() {
    return fence;
  }

  public String getSwimmingPool() {
    return swimmingPool;
  }

  public String getGarage() {
    return garage;
  }

  public String getInfo() {
    String[] list = {fence, swimmingPool, garage};
    return Arrays.stream(list).filter(item -> item != null).collect(Collectors.joining(", "));
  }
}
