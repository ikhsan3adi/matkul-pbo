public class Terminal extends Item {
  private float cableLength; // meter
  private int socketCount;

  public Terminal(String name, String code, String brand, String status, int cableLength, int socketCount) {
    super(name, code, brand, status);

    this.cableLength = cableLength;
    this.socketCount = socketCount;
  }

  public Terminal(String name, String code, String brand, String status, int cableLength) {
    super(name, code, brand, status);

    this.cableLength = cableLength;
    this.socketCount = 1;
  }

  public Terminal(String name, String code, String brand, String status) {
    super(name, code, brand, status);

    this.cableLength = 1;
    this.socketCount = 1;
  }

  public float getCableLength() {
    return cableLength;
  }

  public int getSocketCount() {
    return socketCount;
  }
}
