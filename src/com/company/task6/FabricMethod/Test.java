package src.com.company.task6.FabricMethod;

public class Test {
  public static void main(String[] args) {
    AutoSalon fordSalon = new FordSalon();
    AutoSalon mazdaSalon = new MazdaSalon();
    fordSalon.createAuto().sell();
    mazdaSalon.createAuto().sell();
  }
}
