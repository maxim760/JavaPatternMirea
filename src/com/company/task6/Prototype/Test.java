package src.com.company.task6.Prototype;

public class Test {
  public static void main(String[] args) {
    Shape triangle = new Triangle(10, 20, "blue");
    Shape triangle2 = triangle.clone();
    System.out.println(triangle2.getColor());
  }

}
