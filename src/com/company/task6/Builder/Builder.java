package src.com.company.task6.Builder;

public interface Builder {
  void setFence(String fence); // забор
  void setSwimmingPool(String pool);
  void setGarage(String garage);
  House getResult();
}
