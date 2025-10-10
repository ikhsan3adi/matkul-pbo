package paintingshapes;

public class Paint {
  private double coverage; // square feet per gallon

  public Paint(double c) {
    coverage = c;
  }

  public double amount(Shape s) {
    System.out.println("Computing amount for " + s);
    return s.area() / coverage;
  }
}
