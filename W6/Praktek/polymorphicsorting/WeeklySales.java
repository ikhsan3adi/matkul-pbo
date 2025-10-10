package polymorphicsorting;

public class WeeklySales {
  public static void main(String[] args) {
    Salesperson[] salesStaff = new Salesperson[10];

    salesStaff[0] = new Salesperson("Jane", "Black", 3000);
    salesStaff[1] = new Salesperson("Daffy", "Duck", 4935);
    salesStaff[2] = new Salesperson("James", "Jones", 3000);
    salesStaff[3] = new Salesperson("Dick", "Walter", 2800);
    salesStaff[4] = new Salesperson("Don", "Trump", 1570);
    salesStaff[5] = new Salesperson("Harry", "Taylor", 3000);
    salesStaff[6] = new Salesperson("Andy", "Adams", 3000);
    salesStaff[7] = new Salesperson("Jim", "Doe", 2850);
    salesStaff[8] = new Salesperson("Walt", "Smith", 5000);
    salesStaff[9] = new Salesperson("Taylor", "Swift", 7300);

    // Sort using insertionSort (modify comparator if needed to get descending
    // order)
    Sorting.insertionSort(salesStaff);

    System.out.println("\nRanking of Sales for the Week\n");
    for (Salesperson s : salesStaff)
      System.out.println(s);
  }
}
