package id.ac.polban.koperasi.models;

public class ItemTransaksi {
  private Barang barang;
  private int quantity;

  public ItemTransaksi(Barang barang) {
    this.barang = barang;
    this.quantity = 1;
  }

  public ItemTransaksi(Barang barang, int quantity) {
    this.barang = barang;
    this.quantity = quantity;
  }

  public Barang getBarang() {
    return barang;
  }

  public int getQuantity() {
    return quantity;
  }

  public void addQuantity(int quantity) {
    this.quantity += quantity;
  }

  public long getTotalHarga() {
    return barang.getHarga() * quantity;
  }
}
