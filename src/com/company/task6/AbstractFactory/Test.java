package src.com.company.task6.AbstractFactory;

public class Test {
  public static void main(String[] args) {
    GUIFactory macFactory = new MacFactory();
    GUIFactory winFactory = new WindowsFactory();
    Client mac = new Client(macFactory);
    Client win = new Client(winFactory);
    mac.render();
    win.render();
  }
}
