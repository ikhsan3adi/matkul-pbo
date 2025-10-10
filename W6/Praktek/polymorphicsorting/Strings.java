package polymorphicsorting;

import java.util.Scanner;

public class Strings {
  public static void main(String[] args) {
    String[] list;
    int size;

    Scanner scan = new Scanner(System.in);
    System.out.print("\nHow many strings do you want to sort? ");
    size = scan.nextInt();
    scan.nextLine();
    list = new String[size];

    System.out.println("\nEnter the strings...");
    for (int i = 0; i < size; i++)
      list[i] = scan.nextLine();

    Sorting.insertionSort(list);

    System.out.println("\nYour strings in sorted order...");
    for (int i = 0; i < size; i++)
      System.out.println(list[i]);

    scan.close();
  }
}
