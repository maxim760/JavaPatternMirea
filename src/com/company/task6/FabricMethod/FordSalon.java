package src.com.company.task6.FabricMethod;

public class FordSalon extends AutoSalon {
  @Override
  public void sellAuto() {
    super.sellAuto();
  }

  @Override
  public Auto createAuto() {
    return new Ford();
  }
}
