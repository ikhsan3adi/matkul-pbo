import java.util.ArrayList;
import java.util.Collection;

public class Koperasi {
  private long pemasukan;
  private ArrayList<Barang> daftarBarang;

  public Koperasi(Collection<Barang> daftarBarang) {
    this.daftarBarang = new ArrayList<Barang>();
    this.daftarBarang.addAll(daftarBarang);
  }

  public long getPemasukan() {
    return pemasukan;
  }

  public void tambahPemasukan(long pemasukan) {
    this.pemasukan += pemasukan;
  }

  public ArrayList<Barang> getDaftarBarang() {
    return daftarBarang;
  }

  public void tambahBarang(Barang barang) {
    daftarBarang.add(barang);
  }

  public void hapusBarang(int indexBarang) {
    daftarBarang.remove(indexBarang);
  }
}
