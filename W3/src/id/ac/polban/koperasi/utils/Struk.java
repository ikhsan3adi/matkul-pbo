package id.ac.polban.koperasi.utils;

import id.ac.polban.koperasi.models.ItemTransaksi;
import id.ac.polban.koperasi.models.Transaksi;

public class Struk {
  public static void printStruk(Transaksi transaksi) {
    System.out.println("----- STRUK PEMBELIAN -----");

    for (ItemTransaksi item : transaksi.getDaftarItem()) {
      System.out.printf("%-16s \t%-12s \t%-3s \t%-12s\n",
          item.getBarang().getNama(),
          Uang.formatRupiah(item.getBarang().getHarga()),
          item.getQuantity(),
          Uang.formatRupiah(item.getTotalHarga()));
    }

    System.out.println("Total Harga: \t\t" + Uang.formatRupiah(transaksi.getTotalHarga()));
    System.out.println("---------------------------");
  }
}
