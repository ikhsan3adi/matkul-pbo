import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class InventoryManager {
  private ArrayList<Projector> projectors;
  private ArrayList<Terminal> terminals;
  private ArrayList<Item> otherItems;

  /// daftar peminjam unik
  private Set<Student> students;

  /// daftar transaksi peminjaman/pengembalian
  private ArrayList<Transaction> transactions;

  private int currentTransactionNumber = 1;

  public InventoryManager(
      ArrayList<Projector> projectors,
      ArrayList<Terminal> terminals,
      ArrayList<Item> otherItems,
      Set<Student> students) {
    this.projectors = projectors;
    this.terminals = terminals;
    this.otherItems = otherItems;
    this.students = students;

    this.transactions = new ArrayList<Transaction>();
  }

  public ArrayList<Student> getAllStudents() {
    return new ArrayList<Student>(students);
  }

  public ArrayList<Projector> getProjectors() {
    return projectors;
  }

  public ArrayList<Terminal> getTerminals() {
    return terminals;
  }

  public ArrayList<Item> getOtherItems() {
    return otherItems;
  }

  protected Item findItemByCode(String code) {
    for (Item item : projectors)
      if (item.getCode().equals(code))
        return item;

    for (Item item : terminals)
      if (item.getCode().equals(code))
        return item;

    for (Item item : otherItems)
      if (item.getCode().equals(code))
        return item;

    return null;
  }

  protected Student findStudentByNIM(String nim) {
    for (Student student : students)
      if (student.getNim().equals(nim))
        return student;

    return null;
  }

  protected Transaction findTransactionByNumber(int number) {
    for (Transaction t : transactions)
      if (t.getNumber() == number)
        return t;

    return null;
  }

  public ArrayList<Transaction> getTransactions() {
    return transactions;
  }

  public boolean addStudent(Student student) {
    for (Student s : students)
      if (s.getNim().equals(student.getNim()))
        return false;

    return students.add(student);
  }

  public boolean borrowItem(String nim, String itemCode) {
    Student borrower = findStudentByNIM(nim);
    Item item = findItemByCode(itemCode);

    if (borrower == null || item == null) {
      return false;
    }

    if (!item.available()) {
      System.out.println("Barang Sedang Dipinjam!");
      return false;
    }

    Transaction transaction = new Transaction(currentTransactionNumber++, item, borrower, new Date());

    transactions.add(transaction);

    return true;
  }

  public boolean returnItem(int transactionNumber) {
    Transaction transaction = findTransactionByNumber(transactionNumber);

    if (transaction == null) {
      return false;
    }

    transaction.returnItem(new Date());

    return true;
  }
}
