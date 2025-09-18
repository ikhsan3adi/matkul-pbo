public class Food extends Goods {
  private int calories;

  public Food(String description, int price, int calories) {
    super(description, price);
    this.calories = calories;
  }

  public int getCalories() {
    return calories;
  }

  public void setCalories(int calories) {
    this.calories = calories;
  }

  @Override
  public String display() {
    return "Food: " + getDescription() + ", Price: " + getPrice() + ", Calories: " + calories;
  }
}
