package id.ac.polban.koperasi.utils;

import java.text.NumberFormat;
import java.util.Currency;

public class Uang {
  private static Currency idrCurrency = Currency.getInstance("IDR");
  private static NumberFormat format = NumberFormat.getCurrencyInstance();

  public static String formatRupiah(long nominal) {
    format.setCurrency(idrCurrency);
    return format.format(nominal);
  }
}
