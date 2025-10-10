package paintingshapes;

public class Rectangle extends Shape {
  private double length, width;

  public Rectangle(double length, double width) {
    super("Rectangle");
    this.length = length;
    this.width = width;
  }

  public double area() {
    return length * width;
  }

  public String toString() {
    return super.toString() + " (" + length + " x " + width + ")";
  }
}
