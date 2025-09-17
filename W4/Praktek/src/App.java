import java.util.ArrayList;
import java.util.Scanner;

import id.ac.polban.koperasi.models.*;
import id.ac.polban.koperasi.services.LayananKoperasi;
import id.ac.polban.koperasi.utils.Struk;
import id.ac.polban.koperasi.utils.Uang;

class App {
  private static Scanner sc;
  private static LayananKoperasi koperasi;

  public static void main(String[] args) {
    ArrayList<Barang> daftarBarang = buatDaftarBarang();
    koperasi = new LayananKoperasi(daftarBarang);

    sc = new Scanner(System.in);

    String choice;

    do {
      showMenu();

      System.out.print("Pilih menu: ");
      choice = sc.next();

      switch (choice) {
        case "1":
          beliBarang();
          break;
        case "2":
          lihatDaftarBarang();
          break;
        case "3":
          tambahBarang();
          break;
        case "4":
          hapusBarang();
          break;
        case "5":
          lihatDaftarTransaksi();
          break;
        case "6":
          cekPemasukanKoperasi();
          break;

        case "q":
        case "Q":
          System.out.println("Terima Kasih");
          break;

        default:
          System.out.println("Coba Lagi");
      }

      if (!choice.equals("q") && !choice.equals("Q"))
        clearScreen();

    } while (!choice.equals("q") && !choice.equals("Q"));

    sc.close();
  }

  private static void beliBarang() {
    ArrayList<Barang> daftarBarang = koperasi.getDaftarBarang();
    ArrayList<ItemTransaksi> barangDibeli = new ArrayList<ItemTransaksi>();
    String choice = "Y";

    lihatDaftarBarang();

    do {
      System.out.print("Pilih Barang Yang Ingin Dibeli: ");
      int choiceIndex = sc.nextInt();

      sc.nextLine();

      System.out.print("Jumlah: ");
      int quantity = sc.nextInt();

      sc.nextLine();

      if (choiceIndex < 1 || choiceIndex > daftarBarang.size()) {
        System.out.println("Pilihan Tidak Valid");
        continue;
      }

      Barang barang = daftarBarang.get(choiceIndex - 1);

      if (barang == null) {
        System.out.println("Barang Tidak Ditemukan!");
        continue;
      }

      if (quantity > barang.getStok()) {
        System.out.println("Stok barang tidak mencukupi!");
        continue;
      }

      ItemTransaksi item = new ItemTransaksi(barang, quantity);

      barangDibeli.add(item);

      System.out.println("Ingin membeli barang lain? [Y/n]");
      choice = sc.next();
    } while (choice.equals("y") || choice.equals("Y"));

    if (barangDibeli.size() == 0) {
      System.out.println("Tidak ada barang yang dibeli");
      return;
    }

    Transaksi transaksi = koperasi.beliBarang(barangDibeli);
    System.out.printf("\nBarang Berhasil Dibeli Seharga %s\n\n", Uang.formatRupiah(transaksi.getTotalHarga()));
    Struk.printStruk(transaksi);
  }

  private static void lihatDaftarBarang() {
    ArrayList<Barang> daftarBarang = koperasi.getDaftarBarang();
    int i = 1;

    System.out.println("--- Daftar Barang ---");
    System.out.printf("%-5s \t%-32s\t%-15s\n", "No", "Nama Barang", "Harga Barang");

    if (daftarBarang.size() == 0) {
      System.out.println("Belum ada barang tersedia\n");
      return;
    }

    for (Barang barang : daftarBarang) {
      System.out.printf("[%d] \t%-32s\t%-15s\n",
          i++,
          barang.toString(),
          Uang.formatRupiah(barang.getHarga()));
    }

    System.out.println("---------------------");
  }

  private static void tambahBarang() {
    sc.nextLine();

    System.out.print("Nama Barang: ");
    String nama = sc.nextLine();

    System.out.print("Harga Barang: ");
    int harga = sc.nextInt();

    System.out.print("Stok Barang: ");
    int stok = sc.nextInt();

    Barang barang = new Barang(nama, harga, stok);
    koperasi.tambahBarang(barang);

    System.out.println("Barang Berhasil Ditambahkan. ID Barang: " + barang.getId());
  }

  private static void hapusBarang() {
    lihatDaftarBarang();

    System.out.printf("Pilih Nomor Barang Yang Ingin Dihapus (1 - %d): ", koperasi.getDaftarBarang().size());
    int choiceIndex = sc.nextInt();

    if (choiceIndex < 1 || choiceIndex > koperasi.getDaftarBarang().size()) {
      System.out.println("Pilihan Tidak Valid");
      return;
    }

    koperasi.hapusBarang(choiceIndex - 1);

    System.out.println("Barang Berhasil Dihapus");
  }

  private static void lihatDaftarTransaksi() {
    ArrayList<Transaksi> daftarTransaksi = koperasi.getDaftarTransaksi();
    int i = 1;

    System.out.println("--- Daftar Transaksi ---");
    System.out.printf("%-5s \t%-25s \t%-15s\n", "No", "Waktu Transaksi", "Total Harga");

    if (daftarTransaksi.size() == 0) {
      System.out.println("Belum ada transaksi\n");
      return;
    }

    for (Transaksi transaksi : daftarTransaksi) {
      System.out.printf("[%d] \t%s\t%s\n",
          i++,
          transaksi.getWaktuTransaksi().toString(),
          Uang.formatRupiah(transaksi.getTotalHarga()));
    }

    System.out.println("------------------------");
  }

  private static void cekPemasukanKoperasi() {
    long pemasukan = koperasi.getPemasukan();

    System.out.println("Pemasukan Koperasi Sejumlah " + Uang.formatRupiah(pemasukan));
  }

  private static ArrayList<Barang> buatDaftarBarang() {
    ArrayList<Barang> daftarBarang = new ArrayList<Barang>();

    daftarBarang.add(new AlatTulisKantor("Pulpen", 2000, 100, "Snowman", "Ballpoint"));
    daftarBarang.add(new AlatTulisKantor("Pensil", 2000, 150, "Joyko", "2B"));
    daftarBarang.add(new AlatTulisKantor("Penghapus", 1000, 100, "Faber-Castell", "Karet"));
    daftarBarang.add(new AlatTulisKantor("Spidol", 5000, 100, "Snowman", "Permanent"));
    daftarBarang.add(new AlatTulisKantor("Stabilo", 3000, 100, "Snowman", "Highlighter"));
    daftarBarang.add(new AlatTulisKantor("Buku Tulis", 10000, 100, "Sinar Dunia", "A5"));
    daftarBarang.add(new AlatTulisKantor("Buku Gambar", 15000, 100, "Sinar Dunia", "A4"));

    daftarBarang.add(new Merchandise("Ganci Polban", 50000, 50, 5, "Biru"));
    daftarBarang.add(new Merchandise("Ganci JTK", 50000, 50, 5, "Merah"));
    daftarBarang.add(new Merchandise("Tumbler Polban", 100000, 20, 20, "Biru"));
    daftarBarang.add(new Merchandise("Stiker Polban", 10000, 100, 5, "Biru"));

    return daftarBarang;
  }

  private static void showMenu() {
    System.out.println("--- Koperasi JTK ---");
    System.out.println("[1] Beli Barang");
    System.out.println("[2] Lihat Daftar Barang");
    System.out.println("[3] Tambah Barang");
    System.out.println("[4] Hapus Barang");
    System.out.println("[5] Lihat Daftar Transaksi");
    System.out.println("[6] Cek Pemasukan Koperasi");
    System.out.println("[Q] Keluar");
  }

  private static void clearScreen() {
    System.out.println("Tekan Enter untuk melanjutkan...");
    try {
      System.in.read();
    } catch (Exception e) {
    }
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}