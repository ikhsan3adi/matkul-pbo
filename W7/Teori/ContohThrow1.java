public class ContohThrow1 {
  public static void main(String[] args) {
    RuntimeException x;
    x = new RuntimeException("eksepsi RuntimeException");

    System.out.println("sebelum throw");
    throw x;
  }
}
