/// user / peminjam / mahasiswa
public class Student {
  private String name;
  private String nim;
  private String prodi;

  public Student(String name, String nim, String prodi) {
    this.name = name;
    this.nim = nim;
    this.prodi = prodi;
  }

  public String getName() {
    return name;
  }

  public String getNim() {
    return nim;
  }

  public String getProdi() {
    return prodi;
  }
}
