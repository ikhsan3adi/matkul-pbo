public class Book extends Goods implements Taxable {
  private String author;

  public Book(String description, int price, String author) {
    super(description, price);
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public String display() {
    return "Book: " + getDescription() + ", Price: " + getPrice() + ", Author: " + author;
  }

  @Override
  public float calculateTax() {
    return getPrice() * taxRate;
  }
}
