import java.util.ArrayList;

import id.ac.polban.koperasi.models.Barang;
import id.ac.polban.koperasi.services.LayananKoperasi;

public class Main {
  public static void main(String[] args) {

    ArrayList<Barang> daftarbarang = new ArrayList<Barang>();

    daftarbarang.add(new Barang("Tes Barang", 1000, 100));

    LayananKoperasi koperasi = new LayananKoperasi(daftarbarang);

    koperasi.tambahBarang(new Barang("Tes Barang 2", 1000, 100));

    for (Barang barang : koperasi.getDaftarBarang()) {
      System.out.println(barang.getNama());
    }
  }
}
