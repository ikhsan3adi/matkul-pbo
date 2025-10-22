import java.util.Scanner;

public class Factorials {
  public static void main(String[] args) {
    String keepGoing = "y";
    Scanner scan = new Scanner(System.in);

    while (keepGoing.equals("y") || keepGoing.equals("Y")) {
      System.out.print("Enter an integer: ");

      try {
        if (!scan.hasNextInt()) {
          throw new IllegalArgumentException("Invalid input: please enter an integer");
        }

        int val = scan.nextInt();
        int result = MathUtils.factorial(val);
        System.out.println("Factorial(" + val + ") = " + result);

      } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
      } catch (Exception e) {
        System.out.println("Unexpected error: " + e.getMessage());
      }

      System.out.print("Another factorial? (y/n) ");
      keepGoing = scan.next();
    }

    scan.close();
  }
}