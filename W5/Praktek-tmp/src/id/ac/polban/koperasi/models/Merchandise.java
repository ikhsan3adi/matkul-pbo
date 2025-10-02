package id.ac.polban.koperasi.models;

import id.ac.polban.koperasi.contracts.Discountable;

public class Merchandise extends Barang implements Discountable {


  @Override
  public double hitungDiskon(double persentase) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'hitungDiskon'");
  }

  @Override
  public int getHargaSetelahDiskon() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getHargaSetelahDiskon'");
  }

  private int ukuran; // dalam cm
  private String warna;

  public Merchandise(String nama, int harga, int stok, int ukuran, String warna) {
    super(nama, harga, stok);
    this.ukuran = ukuran;
    this.warna = warna;
  }

  public int getUkuran() {
    return ukuran;
  }

  public void setUkuran(int ukuran) {
    this.ukuran = ukuran;
  }

  public String getWarna() {
    return warna;
  }

  public void setWarna(String warna) {
    this.warna = warna;
  }

  @Override
  public String toString() {
    return String.format("Merch %s (%dcm, %s)", getNama(), ukuran, warna);
  }

}
