import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
          handlePeminjaman();
          break;
        case "2":
          handlePengembalian();
          break;
        case "3":
          handleTampilkanDaftarPeminjaman();
          break;
        case "4":
          handleTampilkanDaftarBarang();
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

  private static void showMenu() {
    System.out.println("--- Peminjaman Barang JTK ---");
    System.out.println("[1] Peminjaman");
    System.out.println("[2] Pengembalian");
    System.out.println("[3] Tampilkan Daftar Peminjaman");
    System.out.println("[4] Tampilkan Daftar Barang");
    System.out.println("[Q] Keluar");
  }

  private static void handlePeminjaman() {
    System.out.println("\n--- Formulir Peminjaman Barang ---");
    System.out.print("Masukkan NIM Peminjam: ");
    String nim = sc.next();
    sc.nextLine();

    Student student = manager.findStudentByNIM(nim);
    if (student == null) {
      System.out.println("Mahasiswa tidak ditemukan. Silakan daftar terlebih dahulu.");
      System.out.print("Nama: ");
      String name = sc.nextLine();
      System.out.print("Program Studi: ");
      String prodi = sc.nextLine();
      student = new Student(name, nim, prodi);
      manager.addStudent(student);
      System.out.println("Mahasiswa baru berhasil ditambahkan.");
    }

    System.out.print("Masukkan Kode Barang yang akan dipinjam: ");
    String itemCode = sc.next();

    if (manager.borrowItem(nim, itemCode)) {
      System.out.println("Peminjaman berhasil dicatat!");
    } else {
      System.out.println("Gagal melakukan peminjaman. Pastikan NIM dan Kode Barang benar.");
    }
  }

  private static void handlePengembalian() {
    System.out.println("\n--- Formulir Pengembalian Barang ---");
    System.out.print("Masukkan Nomor Transaksi: ");
    try {
      int transactionNumber = sc.nextInt();
      if (manager.returnItem(transactionNumber)) {
        System.out.println("Pengembalian barang berhasil.");
      } else {
        System.out.println("Gagal melakukan pengembalian. Pastikan nomor transaksi benar.");
      }
    } catch (Exception _) {
      System.out.println("Input tidak valid. Harap masukkan angka.");
      sc.next();
    }
  }

  private static void handleTampilkanDaftarPeminjaman() {
    System.out.println("\n--- Daftar Seluruh Transaksi Peminjaman ---");
    ArrayList<Transaction> transactions = manager.getTransactions();
    if (transactions == null || transactions.isEmpty()) {
      System.out.println("Belum ada transaksi peminjaman.");
      return;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    System.out.printf("%-3s | %-20s | %-12s | %-36s | %-18s | %-18s | %-10s\n", "No", "Peminjam", "NIM", "Barang",
        "Tgl Pinjam", "Tgl Kembali", "Status");
    System.out.println(
        "-----------------------------------------------------------------------------------------------------------------------------------");

    for (Transaction t : transactions) {
      String returnDateStr = (t.getReturnDate() != null) ? sdf.format(t.getReturnDate()) : "-";
      System.out.printf("%-3d | %-20s | %-12s | %-36s | %-18s | %-18s | %-10s\n",
          t.getNumber(),
          t.getStudent().getName(),
          t.getStudent().getNim(),
          "(" + t.getItem().getCode() + ") " + t.getItem().getName(),
          sdf.format(t.getBorrowDate()),
          returnDateStr,
          t.getStatus());
    }
    System.out.println(
        "-----------------------------------------------------------------------------------------------------------------------------------");
  }

  private static void handleTampilkanDaftarBarang() {
    System.out.println("\n--- Daftar Barang Tersedia ---");

    System.out.printf("%-10s | %-10s | %-30s | %-15s | %-10s\n", "Kode", "Tipe", "Nama", "Merk", "Status");
    System.out.println("-------------------------------------------------------------------------------------");
    for (Projector p : manager.getProjectors()) {
      System.out.printf("%-10s | %-10s | %-30s | %-15s | %-10s\n",
          p.getCode(),
          p.getClass().getName(),
          p.getName(),
          p.getBrand(),
          p.getStatus());
    }
    for (Terminal t : manager.getTerminals()) {
      System.out.printf("%-10s | %-10s | %-30s | %-15s | %-10s\n",
          t.getCode(),
          t.getClass().getName(),
          t.getName(),
          t.getBrand(),
          t.getStatus());
    }
    for (Item i : manager.getOtherItems()) {
      System.out.printf("%-10s | %-10s | %-30s | %-15s | %-10s\n",
          i.getCode(),
          i.getClass().getName(),
          i.getName(),
          i.getBrand(),
          i.getStatus());
    }
    System.out.print("\n\n");
  }

  private static void initialize() {
    ArrayList<Projector> projectors = new ArrayList<Projector>();
    ArrayList<Terminal> terminals = new ArrayList<Terminal>();
    ArrayList<Item> otherItems = new ArrayList<Item>();
    Set<Student> students = new HashSet<Student>();

    projectors
        .add(new Projector(
            "Projector Epson EB-S400", "PRO-001", "Epson", "Tersedia", new String[] { "HDMI", "VGA" }));
    projectors
        .add(new Projector(
            "Projector InFocus IN112x", "PRO-002", "InFocus", "Tersedia", new String[] { "HDMI" }));
    projectors
        .add(new Projector(
            "Projector BenQ MS550", "PRO-003", "BenQ", "Tersedia", new String[] { "VGA", "S-Video" }));

    terminals.add(new Terminal("Terminal 4 Lubang", "TER-001", "Uticon", "Tersedia", 3, 4));
    terminals.add(new Terminal("Terminal 5 Lubang", "TER-002", "Uticon", "Tersedia", 5, 5));
    terminals.add(new Terminal("Stop Kontak 3 Lubang", "TER-003", "Panasonic", "Tersedia", 2, 3));

    otherItems.add(new Item("Kabel HDMI 5m", "OTH-001", "Vention", "Tersedia"));
    otherItems.add(new Item("Kabel VGA 3m", "OTH-002", "LogiLink", "Tersedia"));
    otherItems.add(new Item("Laser Pointer", "OTH-003", "Logitech", "Tersedia"));

    students.add(new Student("Ikhsan Satriadi", "241511080", "D3-Teknik Informatika"));
    students.add(new Student("Abi", "241511091", "D3-Teknik Informatika"));
    students.add(new Student("Alex", "241511067", "D3-Teknik Informatika"));

    manager = new InventoryManager(projectors, terminals, otherItems, students);
  }

  private static String getInput() {
    System.out.print("Pilih menu: ");

    return sc.next();
  }

  private static void clearScreen() {
    System.out.print("\nTekan ENTER untuk kembali ke menu...");
    try {
      System.in.read();
    } catch (Exception _) {
    }
  }
}