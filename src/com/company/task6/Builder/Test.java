package src.com.company.task6.Builder;

public class Test {
  public static void main(String[] args) {
    HouseBuilder builder = new HouseBuilder();
    House defaultHouse = builder.getResult();
    builder.setGarage("Большой гараж");
    House houseWithGarage = builder.getResult();
    builder.setFence("Деревянный забор");
    builder.setSwimmingPool("Бассейн 10 на 10");
    House expensiveHouse = builder.getResult();
    System.out.println(defaultHouse.getInfo());
    System.out.println(houseWithGarage.getInfo());
    System.out.println(expensiveHouse.getInfo());
  }
}
