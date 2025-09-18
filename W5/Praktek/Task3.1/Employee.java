class Employee extends Sortable {
  public Employee(String n, double s, int day, int month, int year) {
    name = n;
    salary = s;
    hireday = day;
    hiremonth = month;
    hireyear = year;
  }

  public void print() {
    System.out.println(name + " " + salary + " " + hireYear());
  }

  public void raiseSalary(double byPercent) {
    salary *= 1 + byPercent / 100;
  }

  public int hireYear() {
    return hireyear;
  }

  public int hireMonth() {
    return hiremonth;
  }

  public int hireDay() {
    return hireday;
  }

  private String name;
  protected double salary;
  private int hireday;

  private int hiremonth;

  private int hireyear;

  @Override
  public int compare(Sortable b) {
    Employee eb = (Employee) b;
    if (salary < eb.salary)
      return -1;
    if (salary > eb.salary)
      return +1;
    return 0;
  }
}