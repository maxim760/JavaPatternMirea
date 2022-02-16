package src.com.company.task6.Builder;

public class HouseBuilder implements Builder {
  private String fence;
  private String swimmingPool;
  private String garage;
  @Override
  public void setFence(String fence) {
    this.fence = fence;
  }
  @Override
  public void setGarage(String garage) {
    this.garage = garage;
  }
  @Override
  public void setSwimmingPool(String pool) {
    this.swimmingPool = pool;
  }

  @Override
  public House getResult() {
    return new House(fence, swimmingPool, garage);
  }
}
