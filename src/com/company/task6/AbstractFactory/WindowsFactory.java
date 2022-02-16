package src.com.company.task6.AbstractFactory;

public class WindowsFactory implements GUIFactory {
  @Override
  public GUI createButton() {
    return new WindowsButton();
  }

  @Override
  public GUI createTextField() {
    return new WindowsTextField();
  }

  @Override
  public GUI createTooltip() {
    return new WindowTooltip();
  }
}
