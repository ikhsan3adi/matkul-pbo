import java.util.Scanner;

public class DataTypes {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int tc = scanner.nextInt();
    scanner.nextLine();

    String s;

    while (0 != tc--) {
      s = scanner.nextLine();

      boolean isLong = checkLong(s);

      if (!isLong) {
        System.out.println(s + " can't be fitted anywhere.");
        continue;
      }

      boolean isInt = checkInt(s);
      boolean isShort = checkShort(s);
      boolean isByte = checkByte(s);

      System.out.println(s + " can be fitted in:");

      if (isByte)
        System.out.println("* byte");
      if (isShort)
        System.out.println("* short");
      if (isInt)
        System.out.println("* int");
      if (isLong)
        System.out.println("* long");
    }

    scanner.close();
  }

  private static boolean checkByte(String n) {
    if (Math.abs(Long.parseLong(n)) > Byte.MAX_VALUE) {
      return false;
    } else {
      return true;
    }
  }

  private static boolean checkShort(String n) {
    if (Math.abs(Long.parseLong(n)) > Short.MAX_VALUE) {
      return false;
    } else {
      return true;
    }
  }

  private static boolean checkInt(String n) {
    if (Math.abs(Long.parseLong(n)) > Integer.MAX_VALUE) {
      return false;
    } else {
      return true;
    }
  }

  private static boolean checkLong(String n) {
    try {
      Long.parseLong(n);
      return true;
    } catch (Exception _) {
      return false;
    }
  }
}
