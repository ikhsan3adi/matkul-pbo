package anothertypeofemployee;

public class Commission extends Hourly {
  private double totalSales;
  private double commissionRate;

  public Commission(
      String eName,
      String eAddress,
      String ePhone,
      String socSecNumber,
      double rate,
      double commissionRate) {
    super(eName, eAddress, ePhone, socSecNumber, rate);
    this.commissionRate = commissionRate;
    this.totalSales = 0;
  }

  public void addSales(double sales) {
    totalSales += sales;
  }

  @Override
  public double pay() {
    double payment = super.pay();
    payment += commissionRate * totalSales;
    totalSales = 0;
    return payment;
  }

  @Override
  public String toString() {
    return super.toString() + "\nTotal sales: " + totalSales;
  }
}
