import java.util.Scanner;

public class ParseInts {
  public static void main(String[] args) {
    int val, sum = 0;
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter a line of text");
    Scanner scanLine = new Scanner(scan.nextLine());

    while (scanLine.hasNext()) {
      String token = scanLine.next();
      try {
        val = Integer.parseInt(token);
        sum += val;
        System.out.println("Added: " + val);
      } catch (NumberFormatException e) {
        System.out.println("Skipping non-integer: '" + token + "'");
      }
    }

    System.out.println("The sum of the integers on this line is " + sum);

    scanLine.close();
    scan.close();
  }
}