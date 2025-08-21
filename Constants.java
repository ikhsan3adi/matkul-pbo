public class Constants {
  public static void main(String[] args) {
    final double CM_PER_INCH = 2.54;

    double paperWidth = 8.5;
    double paperHeight = 11;

    System.out.println("Paper size in centimeters: " + paperWidth *
        CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
  }
}

/**
 * Variables
 * 
 * Dari 2 contoh baris program diatas, jawablah pertanyaan dibawah ini:
 * 1. Bagaimana output dari masing masing class Constants dan Constants2?
 * jawab: Output sama, yaitu: `Paper size in centimeters: 21.59 by 27.94`
 * 
 * 2. Apa perbedaan penggunaan final double dengan public static final double?
 * jawab: `final double CM_PER_INCH` adalah konstanta/variable final di dalam
 * method dan hanya bisa diakses oleh kode didalam method tersebut,
 * 
 * sedangkan `public static final double CM_PER_INCH` adalah attribute dari
 * class Constants2 dan dapat diakses oleh seluruh method di class itu sendiri
 * maupun dari kelas lain karena memiliki access modifier public
 */