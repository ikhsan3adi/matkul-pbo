import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static Scanner sc;
  private static Koperasi koperasi;

  public static void main(String[] args) {
    ArrayList<Barang> daftarBarang = buatDaftarBarang();
    koperasi = new Koperasi(daftarBarang);

    sc = new Scanner(System.in);

    String choice;

    do {
      showMenu();
      choice = getInput();

      switch (choice) {
        case "1":
          beliBarang();
          break;
        case "2":
          cekPemasukanKoperasi();
          break;

        default:
          System.out.println("Coba Lagi");
      }

    } while (!choice.equals("q") && !choice.equals("Q"));
  }

  private static void cekPemasukanKoperasi() {
    long pemasukan = koperasi.getPemasukan();

    System.out.println("Pemasukan Koperasi Sejumlah Rp" + pemasukan);
  }

  private static void beliBarang() {
    ArrayList<Barang> daftarBarang = koperasi.getDaftarBarang();
    int i = 0;

    for (Barang barang : daftarBarang) {
      System.out.println("[" + i++ + "] " + barang.getNama());
    }

    System.out.print("Pilih Barang Yang Ingin Dibeli: ");
    int choiceIndex = sc.nextInt();

    sc.nextLine();

    try {
      System.out.print("Jumlah: ");
      int quantity = sc.nextInt();

      sc.nextLine();

      Barang barang = daftarBarang.get(choiceIndex);

      if (quantity > barang.getStok()) {
        System.out.println("Stok barang tidak mencukupi!");
        return;
      }

      koperasi.tambahPemasukan(barang.getHarga() * quantity);
      barang.kurangiStok(quantity);

      System.out.println("Barang Berhasil Dibeli Seharga Rp" + barang.getHarga() * quantity);

    } catch (Exception e) {
      System.out.println("Barang Tidak Ditemukan!");
    }
  }

  private static void showMenu() {
    System.out.println("--- Koperasi JTK ---");
    System.out.println("[1] Beli Barang");
    System.out.println("[2] Cek Pemasukan Koperasi");
    System.out.println("[Q] Keluar");
  }

  private static ArrayList<Barang> buatDaftarBarang() {
    ArrayList<Barang> daftarBarang = new ArrayList<Barang>();

    daftarBarang.add(new Barang("Pulpen", 2000, 100));
    daftarBarang.add(new Barang("Pensil", 2000, 150));
    daftarBarang.add(new Barang("Kertas A4", 500, 10000));
    daftarBarang.add(new Barang("Penghapus", 1000, 100));
    daftarBarang.add(new Barang("Spidol", 5000, 100));

    return daftarBarang;
  }

  private static String getInput() {
    System.out.print("Pilih menu: ");

    return sc.next();
  }

}
