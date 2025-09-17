public class Circle extends Shape {
  private double radius;
  private String color;

  // Constructors (overloaded)
  /** Constructor default */
  public Circle() {
    radius = 1.0;
    color = "red";
  }

  /** Constructor dengan radius */
  public Circle(double radius) {
    this.radius = radius;
    this.color = "red";
  }

  /** Constructor dengan radius dan color */
  public Circle(double radius, String color, boolean filled) {
    this.radius = radius;
    this.color = color;
    setFilled(filled);
  }

  // Getter dan Setter
  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getArea() {
    return radius * radius * Math.PI;
  }

  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  @Override
  public String toString() {
    return "A Circle with radius=" + radius + ", which is a subclass of " + super.toString();
  }
}
