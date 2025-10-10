package paintingshapes;

import java.text.DecimalFormat;

public class PaintThings {
  public static void main(String[] args) {
    final double COVERAGE = 350;
    Paint paint = new Paint(COVERAGE);

    Rectangle deck = new Rectangle(20, 35);
    Sphere bigBall = new Sphere(15);
    Cylinder tank = new Cylinder(10, 30);

    double deckAmt = paint.amount(deck);
    double ballAmt = paint.amount(bigBall);
    double tankAmt = paint.amount(tank);

    DecimalFormat fmt = new DecimalFormat("0.#");
    System.out.println("\nNumber of gallons of paint needed...");
    System.out.println("Deck " + fmt.format(deckAmt));
    System.out.println("Big Ball " + fmt.format(ballAmt));
    System.out.println("Tank " + fmt.format(tankAmt));
  }
}
