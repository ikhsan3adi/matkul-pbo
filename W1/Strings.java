import java.util.Scanner;

public class Strings {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String a = scanner.nextLine(), b = scanner.nextLine();

    System.out.println(a.length() + b.length());
    System.out.println(a.compareTo(b) > 0 ? "Yes" : "No");

    a = a.substring(0, 1).toUpperCase() + a.substring(1);
    b = b.substring(0, 1).toUpperCase() + b.substring(1);

    System.out.println(a + " " + b);

    scanner.close();
  }
}
