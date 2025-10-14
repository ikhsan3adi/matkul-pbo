import java.util.ArrayList;
import java.util.Collection;

class Department {
  private String name;

  ArrayList<Employee> employees = new ArrayList<Employee>();

  public Department(String name) {
    this.name = name;
  }

  public Department(String name, Collection<Employee> employees) {
    this.name = name;
    this.employees.addAll(employees);
  }

  public String departmentName() {
    return name;
  }
}