public class Toy extends Goods implements Taxable {
  private int minimumAge;

  public Toy(String description, int price, int minAge) {
    super(description, price);
    this.minimumAge = minAge;
  }

  public int getMinimumAge() {
    return minimumAge;
  }

  public void setMinimumAge(int minAge) {
    this.minimumAge = minAge;
  }

  @Override
  public String display() {
    return "Toy: " + getDescription() + ", Price: " + getPrice() + ", Min Age: " + minimumAge;
  }

  @Override
  public float calculateTax() {
    return getPrice() * taxRate;
  }
}
