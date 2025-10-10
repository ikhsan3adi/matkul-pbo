package polymorphicsorting;

public class Salesperson implements Comparable<Salesperson> {
  private String firstName, lastName;
  private int totalSales;

  public Salesperson(String first, String last, int sales) {
    firstName = first;
    lastName = last;
    totalSales = sales;
  }

  public String toString() {
    return lastName + ", " + firstName + ": \t" + totalSales;
  }

  public boolean equals(Object other) {
    return (lastName.equals(((Salesperson) other).getLastName()) &&
        firstName.equals(((Salesperson) other).getFirstName()));
  }

  public int compareTo(Salesperson other) {
    int result = Integer.compare(this.totalSales, other.totalSales);
    if (result == 0) {
      result = this.lastName.compareTo(other.lastName);
      if (result == 0) {
        result = this.firstName.compareTo(other.firstName);
      }
    }
    return result;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getSales() {
    return totalSales;
  }
}
