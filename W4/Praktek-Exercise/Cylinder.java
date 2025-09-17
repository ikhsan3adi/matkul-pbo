public class Cylinder extends Circle {
  private double height;

  // Constructors
  public Cylinder() {
    super(); // Memanggil constructor Circle()
    this.height = 1.0;
  }

  public Cylinder(double height) {
    super(); // Memanggil constructor Circle()
    this.height = height;
  }

  public Cylinder(double radius, double height) {
    super(radius); // Memanggil constructor Circle(radius)
    this.height = height;
  }

  public Cylinder(double radius, double height, String color, boolean filled) {
    super(radius, color, filled); // Memanggil constructor Circle(radius, color, filled)
    this.height = height;
  }

  // Getter dan Setter
  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  // Method untuk menghitung luas permukaan dan volume tabung

  @Override
  public double getArea() {
    // Luas permukaan = 2 * PI * r * h + 2 * luas alas
    return (2 * Math.PI * getRadius() * height) + (2 * super.getArea());
  }

  public double getVolume() {
    return super.getArea() * height;
  }

  // Override toString()
  @Override
  public String toString() {
    // Memanfaatkan toString() dari superclass
    return "Cylinder: subclass of " + super.toString() + " height=" + height;
  }
}
