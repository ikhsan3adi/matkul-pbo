public class Main {
  public static void main(String[] args) {
    Employee asep = new Fulltime("Asep", Jabatan.StafProgrammer, 3, 2, 500000);
    Employee ujang = new Parttime("Ujang", 5);

    asep.calculateTotalSalary();
    ujang.calculateTotalSalary();

    System.out.println("Total gaji Asep: " + asep.getSalary());
    System.out.println("Total gaji Ujang: " + ujang.getSalary());
  }
}

// 3000000 + 2000000 + 500000 + 90000 + 1000000 - 500000