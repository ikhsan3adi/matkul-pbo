public abstract class Goods {
  private String description;
  private int price;

  public Goods(String description, int price) {
    this.description = description;
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public abstract String display();
}
