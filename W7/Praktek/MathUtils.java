public class MathUtils {
  // Returns the factorial of the argument given
  // Throws IllegalArgumentException for invalid inputs
  public static int factorial(int n) throws IllegalArgumentException {
    // Check for negative numbers
    if (n < 0) {
      throw new IllegalArgumentException("Factorial is not defined for negative numbers: " + n);
    }

    // Check for overflow (factorials > 16 exceed int capacity)
    if (n > 16) {
      throw new IllegalArgumentException("Factorial too large for int type (n > 16): " + n);
    }

    int fac = 1;
    for (int i = n; i > 0; i--) {
      fac *= i;
    }
    return fac;
  }
}