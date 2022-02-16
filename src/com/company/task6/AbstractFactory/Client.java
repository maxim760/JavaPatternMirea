package src.com.company.task6.AbstractFactory;

public class Client {
  GUIFactory factory;
  public Client(GUIFactory factory) {
    this.factory = factory;
  }

  public void render() {
    factory.createButton().render();
    factory.createTooltip().render();
    factory.createTextField().render();
  }

}
