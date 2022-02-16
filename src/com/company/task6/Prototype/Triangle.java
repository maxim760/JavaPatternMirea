package src.com.company.task6.Prototype;

public class Triangle implements Shape {
  private int x;
  private int y;
  private String color;

  public Triangle(int x, int y, String color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public String getColor() {
    return color;
  }

  @Override
  public Shape clone() {
    return new Triangle(x, y, color);
  }
}
