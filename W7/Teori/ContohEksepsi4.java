public class ContohEksepsi4 {
  public static void main(String[] args) {
    int pembilang = 5;
    int penyebut = 0;

    try {
      int hasil = pembilang / penyebut; // timbul eksepsi
      System.out.println("Hasil = " + hasil);
    } catch (Exception x) {
      System.out.println(x.getMessage());
    }
    System.out.println("Statement setelah blok try-catch");
  }
}
