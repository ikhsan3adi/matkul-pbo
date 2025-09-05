package id.ac.polban.koperasi.models;

/// Barang yang dijual di koperasi
public class Barang {
  private static int nextId = 0;

  private int id;
  private String nama;
  private int harga;
  private int stok;

  {
    this.id = nextId++;
  }

  public Barang(String nama, int harga, int stok) {
    this.nama = nama;
    this.harga = harga;
    this.stok = stok;
  }

  public int getId() {
    return id;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public int getHarga() {
    return harga;
  }

  public void setHarga(int harga) {
    this.harga = harga;
  }

  public int getStok() {
    return stok;
  }

  public void tambahStok(int jml) {
    this.stok += jml;
  }

  public void kurangiStok(int jml) {
    this.stok -= jml;
  }
}
