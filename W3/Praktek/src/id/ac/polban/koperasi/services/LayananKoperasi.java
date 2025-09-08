package id.ac.polban.koperasi.services;

import java.util.ArrayList;
import java.util.Collection;

import id.ac.polban.koperasi.models.*;

/// Service koperasi
public class LayananKoperasi {
  private long pemasukan;
  private ArrayList<Barang> daftarBarang;
  private ArrayList<Transaksi> daftarTransaksi;

  public LayananKoperasi(Collection<Barang> daftarBarang) {
    this.daftarBarang = new ArrayList<Barang>();
    this.daftarBarang.addAll(daftarBarang);
    this.daftarTransaksi = new ArrayList<Transaksi>();
  }

  public long getPemasukan() {
    return pemasukan;
  }

  private void tambahPemasukan(long pemasukan) {
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

  public ArrayList<Transaksi> getDaftarTransaksi() {
    return daftarTransaksi;
  }

  private void tambahTransaksi(Transaksi transaksi) {
    daftarTransaksi.add(transaksi);
  }

  public Transaksi beliBarang(Collection<ItemTransaksi> daftarItem) {
    Transaksi transaksi = new Transaksi(daftarItem);
    tambahTransaksi(transaksi);
    tambahPemasukan(transaksi.getTotalHarga());
    return transaksi;
  }
}
