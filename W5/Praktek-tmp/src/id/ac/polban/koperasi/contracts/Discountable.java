package id.ac.polban.koperasi.contracts;

public interface Discountable {
  double hitungDiskon(double persentase);

  int getHargaSetelahDiskon();
}
