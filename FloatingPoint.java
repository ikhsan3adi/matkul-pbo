class FloatingPoint {
  public static void main(String[] args) {
    double x = 92.98;
    int nx = (int) Math.round(x);

    System.out.println(nx);
  }
}

/**
 * Operators
 * 
 * Math Class berisi bermacam-macam fungsi matematika seperti pada contoh diatas
 * pada penggunaan round(x), terdapat beberapa pertanyaan yang perlu untuk
 * dijelaskan:
 * 1. Pada kasus berikut jelaskan nilai nx setelah digunakan Math.round(x)?
 * jawab: 93, karena Math.round melakukan pembulatan ke bilangan bulat terdekat
 * 
 * 2. Kenapa dibutuhkan cast (int) dalam penggunaan Math.round(x)?
 * jawab: karena Math.round(double x) mengembalikan nilai bertipe long sehingga
 * perlu dilakukan casting/konversi
 */