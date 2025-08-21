class ConvertDataType {
  static short methodOne(long l) {
    int i = (int) l;
    return (short) i;
  }

  public static void main(String[] args) {
    double d = 10.25;
    float f = (float) d;
    byte b = (byte) methodOne((long) f);
    System.out.println(b);
  }
}

/**
 * Operators (1)
 * 
 * Program berikut melakukan convert tipe data yang berukuran besar ke kecil
 * (long -> int ->
 * short) dan (double -> float -> byte).
 * 1. Jelaskan output nilai dari variable b.
 * jawab: 10
 * 
 * 2. Jelaskan apa yang berubah dari variable d menjadi variable b setelah
 * dilakukan cast? variabel d berubah saat memanggil methodOne dengan parameter
 * f yang dicasting ke long sehingga keluaran menjadi bilangan bulat. methodOne
 * mengonversi long ke int lalu ke short tidak mengubah nilai
 */