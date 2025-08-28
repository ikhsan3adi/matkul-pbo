import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static Scanner sc;
  private static InventoryManager manager;

  public static void main(String[] args) {
    initialize();
    sc = new Scanner(System.in);

    String choice;

    do {
      showMenu();
      choice = getInput();

      switch (choice) {
        case "1":

          break;
        case "2":

          break;

        default:
          System.out.println("Try again");
      }

      clearScreen();
    } while (!choice.equals("q") && !choice.equals("Q"));

    sc.close();
  }

  private static void showMenu() {
    System.out.println("--- Peminjaman Barang JTK ---");
    System.out.println("[1] Peminjaman");
    System.out.println("[2] Pengembalian");
    System.out.println("[Q] Keluar");
  }

  private static String getInput() {
    System.out.print("Pilih menu: ");

    return sc.next();
  }

  private static void clearScreen() {
  }

  private static void initialize() {

    ArrayList<Projector> projectors;

    manager = new InventoryManager();
  }
}