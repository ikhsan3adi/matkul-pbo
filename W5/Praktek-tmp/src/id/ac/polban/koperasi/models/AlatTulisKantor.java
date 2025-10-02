package id.ac.polban.koperasi.models;

public class AlatTulisKantor extends Barang {
  private String merk;
  private String tipe;

  public AlatTulisKantor(String nama, int harga, int stok, String merk, String tipe) {
    super(nama, harga, stok);
    this.merk = merk;
    this.tipe = tipe;
  }

  public String getMerk() {
    return merk;
  }

  public void setMerk(String merk) {
    this.merk = merk;
  }

  public String getTipe() {
    return tipe;
  }

  public void setTipe(String tipe) {
    this.tipe = tipe;
  }

  @Override
  public String toString() {
    return String.format("ATK %s (%s %s)", getNama(), merk, tipe);
  }
}
