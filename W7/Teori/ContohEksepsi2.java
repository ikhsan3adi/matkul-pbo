public class ContohEksepsi2 {
  public static void main(String[] args) {
    int pembilang = 5;
    int penyebut = 0;

    try {
      int hasil = pembilang / penyebut;
      System.out.println("Hasil = " + hasil);
    } catch (ArithmeticException x) {
      System.out.println("Error: terdapat pembagian nol");
    }
  }
}
