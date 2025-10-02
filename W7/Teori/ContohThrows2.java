public class ContohThrows2 {
  public static void test(int x) throws NullPointerException, ArithmeticException {
    if (x < 0) {
      throw new NullPointerException("kesalahan: NullPointerException");
    } else if (x == 0) {
      throw new ArithmeticException("kesalahan: ArithmeticException");
    }
  }

  public static void main(String[] args) {
    try {
      // test(-10); // menimbulkan NullPointerException
      test(0); // menimbulkan ArithmeticException
    } catch (Exception x) {
      System.out.println("eksepsi ditangkap disini");
      System.out.println(x.getMessage());
    }

    System.out.println("statement setelah blok try-catch");
  }
}
