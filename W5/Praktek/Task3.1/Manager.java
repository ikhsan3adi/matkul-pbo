import java.util.Calendar;
import java.util.GregorianCalendar;

class Manager extends Employee {
  public Manager(String n, double s, int d, int m, int y) {
    super(n, s, d, m, y);
    secretaryName = "";
  }

  public void raiseSalary(double byPercent) {
    // add 1/2% bonus for every year of service
    GregorianCalendar todaysDate = new GregorianCalendar();
    int currentYear = todaysDate.get(Calendar.YEAR);
    double bonus = 0.5 * (currentYear - hireYear());
    super.raiseSalary(byPercent + bonus);
  }

  public String getSecretaryName() {
    return secretaryName;
  }

  private String secretaryName;

  @Override
  public int compare(Sortable b) {
    Manager eb = (Manager) b;
    if (salary < eb.salary)
      return -1;
    if (salary > eb.salary)
      return +1;
    return 0;
  }
}