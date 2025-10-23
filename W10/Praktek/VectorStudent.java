import java.util.Vector;

public class VectorStudent {
    public static void main(String[] args) {
        Vector<Student> students = new Vector<>();
        
        students.add(new Student("S001", "John", "Computer Science", "123 Main St"));
        students.add(new Student("S002", "Alice", 101, "456 Oak Ave"));
        students.add(new Student("S003", "Bob", "Mathematics", "789 Pine Rd"));
        students.add(new Student("S004", "Diana", 102, "321 Elm St"));
        students.add(new Student("S005", "Charlie", "Computer Science", "654 Maple Dr"));
        
        System.out.println("Computer Science Department Students:");
        for (Student student : students) {
            Object dept = student.getDepartment();
            // Filter berdasarkan string "Computer Science" atau kode 101
            if (dept.equals("Computer Science") || dept.equals(101)) {
                System.out.println(student);
            }
        }
    }
}