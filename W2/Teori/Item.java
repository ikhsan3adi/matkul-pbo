public class Item {
  private String name;
  private String code;
  private String brand;
  private String status;

  public Item(String name, String code, String brand, String status) {
    this.name = name;
    this.code = code;
    this.brand = brand;
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public String getBrand() {
    return brand;
  }

  public String getStatus() {
    return status;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public boolean available() {
    return status == "Tersedia";
  }
}
