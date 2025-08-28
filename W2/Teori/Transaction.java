import java.util.Date;

public class Transaction {
  private int number;
  private Item item;
  private Student student;
  private Date borrowDate;
  private Date returnDate;
  private String status;

  public Transaction(int number, Item item, Student student, Date borrowDate) {
    this.number = number;
    this.item = item;
    this.student = student;
    this.borrowDate = borrowDate;
    this.returnDate = null;
    this.status = "AKTIF";
  }

  public Transaction(int number, Item item, Student student, Date borrowDate, Date returnDate) {
    this.number = number;
    this.item = item;
    this.student = student;
    this.borrowDate = borrowDate;
    this.returnDate = returnDate;
    this.status = "AKTIF";
  }

  public int getNumber() {
    return number;
  }

  public Item getItem() {
    return item;
  }

  public Student getStudent() {
    return student;
  }

  public Date getBorrowDate() {
    return borrowDate;
  }

  public Date getReturnDate() {
    return returnDate;
  }

  public String getStatus() {
    return status;
  }

  public void returnItem(Date returnDate) {
    this.returnDate = returnDate;
    this.status = "SELESAI";
  }
}
