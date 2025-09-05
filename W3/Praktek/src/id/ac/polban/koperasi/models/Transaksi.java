package id.ac.polban.koperasi.models;

import java.util.*;

public class Transaksi {
  private static int nextId = 0;

  private int id;
  private ArrayList<ItemTransaksi> daftarItem;
  private long totalHarga;
  private Date waktuTransaksi;

  {
    this.id = nextId++;
  }

  public Transaksi(Collection<ItemTransaksi> daftarItem) {
    this.daftarItem = new ArrayList<>();
    this.daftarItem.addAll(daftarItem);
    this.waktuTransaksi = new Date();

    updateTotalHarga();
  }

  public int getId() {
    return id;
  }

  public ArrayList<ItemTransaksi> getDaftarItem() {
    return daftarItem;
  }

  public void addItem(ItemTransaksi item) {
    this.daftarItem.add(item);
    updateTotalHarga();
  }

  public void removeItem(ItemTransaksi item) {
    this.daftarItem.remove(item);
    updateTotalHarga();
  }

  public long getTotalHarga() {
    return totalHarga;
  }

  private void updateTotalHarga() {
    this.totalHarga = 0;
    for (ItemTransaksi item : daftarItem) {
      this.totalHarga += item.getTotalHarga();
    }
  }

  public Date getWaktuTransaksi() {
    return waktuTransaksi;
  }
}
