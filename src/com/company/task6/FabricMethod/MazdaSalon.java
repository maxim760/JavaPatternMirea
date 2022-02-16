package src.com.company.task6.FabricMethod;

public class MazdaSalon extends AutoSalon {
  @Override
  public void sellAuto() {
    super.sellAuto();
  }

  @Override
  public Auto createAuto() {
    return new Mazda();
  }
}
