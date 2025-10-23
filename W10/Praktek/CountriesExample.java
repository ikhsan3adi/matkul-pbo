import java.util.HashSet;
import java.util.Set;

public class CountriesExample {
  public static void main(String[] args) {
    Set<String> countries = new HashSet<>();

    countries.add("Indonesia");
    countries.add("Malaysia");
    countries.add("Singapore");
    countries.add("Thailand");
    countries.add("Vietnam");
    countries.add("Indonesia"); // duplikat

    System.out.println("Countries: " + countries);
  }
}