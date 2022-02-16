package src.com.company.task6.AbstractFactory;

public class MacFactory implements GUIFactory {
  @Override
  public GUI createButton() {
    return new MacButton();
  }

  @Override
  public GUI createTextField() {
    return new MacTextField();
  }

  @Override
  public GUI createTooltip() {
    return new MacTooltip();
  }
}
