class Fulltime extends Employee implements Koperasi {
  private Jabatan jabatan;
  private int tunjanganJabatan;
  private int jumlahAnak;
  private int tunjanganAnak;
  private int loanMonthly;

  public static int TUNJANGAN_PER_ANAK = 500000;

  public Fulltime(String name,
      Jabatan jabatan,
      int jamLembur,
      int jumlahAnak,
      int pinjamanKoperasi) {
    super(name, jamLembur);

    this.jabatan = jabatan;
    this.jumlahAnak = jumlahAnak;
    this.loanMonthly = pinjamanKoperasi;
  }

  @Override
  public int getSalary() {
    return totalSalary;
  }

  public int getTunjanganJabatan() {
    return tunjanganJabatan;
  }

  public void setTunjanganJabatan(int tunjanganJabatan) {
    this.tunjanganJabatan = tunjanganJabatan;
  }

  public int getTunjanganAnak() {
    return tunjanganAnak;
  }

  public void setTunjanganAnak(int tunjanganAnak) {
    this.tunjanganAnak = tunjanganAnak;
  }

  @Override
  public int loanMonthly() {
    return loanMonthly;
  }

  @Override
  public void calculateTotalSalary() {
    super.calculateTotalSalary();
    int tunjanganAnak = Math.min(jumlahAnak, 2) * TUNJANGAN_PER_ANAK;

    int gajiPokok = 0;
    int tunjanganJabatan = 0;

    switch (jabatan) {
      case StafManager:
        gajiPokok = 5000000;
        tunjanganJabatan = 5000000;
        break;
      case StafProgrammer:
        gajiPokok = 3000000;
        tunjanganJabatan = 2000000;
        break;
      case StafAnalis:
        gajiPokok = 3000000;
        tunjanganJabatan = 3000000;
        break;
    }

    // System.out.println(gajiPokok);
    // System.out.println(tunjanganAnak);
    // System.out.println(tunjanganLembur);
    // System.out.println(tunjanganJabatan);
    // System.out.println(TUNJANGAN_KOMUNIKASI);

    this.totalSalary = gajiPokok
        + tunjanganLembur
        + tunjanganJabatan
        + tunjanganAnak
        + TUNJANGAN_KOMUNIKASI
        - loanMonthly;
  }
}