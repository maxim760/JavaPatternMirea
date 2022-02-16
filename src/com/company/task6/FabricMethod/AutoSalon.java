package src.com.company.task6.FabricMethod;

public abstract class AutoSalon {
  public void sellAuto() {
    Auto auto = createAuto();
    auto.sell();
  }
  public abstract Auto createAuto();
}
