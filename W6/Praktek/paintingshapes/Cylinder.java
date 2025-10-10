package paintingshapes;

public class Cylinder extends Shape {
  private double radius, height;

  public Cylinder(double radius, double height) {
    super("Cylinder");
    this.radius = radius;
    this.height = height;
  }

  // surface area for the exercise uses PI * radius^2 * height (per instructions)
  public double area() {
    return Math.PI * radius * radius * height;
  }

  public String toString() {
    return super.toString() + " of radius " + radius + " and height " + height;
  }
}
