class Employee {
  protected String name;
  protected int jamLembur;
  protected int baseSalary = 0;
  protected int totalSalary;
  protected int tunjanganLembur;

  public static int TUNJANGAN_LEMBUR_PER_JAM = 30000;
  public static int TUNJANGAN_KOMUNIKASI = 500000;

  public Employee(String name, int jamLembur) {
    this.name = name;
    this.jamLembur = jamLembur;
  }

  public String getName() {
    return name;
  }

  public int getSalary() {
    return totalSalary;
  }

  public void calculateTotalSalary() {
    int tunjanganLembur = jamLembur * TUNJANGAN_LEMBUR_PER_JAM;
    this.totalSalary = baseSalary + tunjanganLembur;
    this.tunjanganLembur = tunjanganLembur;
  }
}