public class Projector extends Item {
  private String[] outputs;

  public Projector(String name, String code, String brand, String status, String[] outputs) {
    super(name, code, brand, status);

    this.outputs = outputs;
  }

  public Projector(String name, String code, String brand, String status) {
    super(name, code, brand, status);

    this.outputs[0] = "HDMI";
  }

  public String[] getOutputs() {
    return outputs;
  }
}
