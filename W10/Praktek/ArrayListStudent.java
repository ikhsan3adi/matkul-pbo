import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListStudent {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        
        students.add(new Student("S001", "John", "Computer Science", "123 Main St"));
        students.add(new Student("S002", "Alice", 101, "456 Oak Ave"));
        students.add(new Student("S003", "Bob", "Mathematics", "789 Pine Rd"));
        students.add(new Student("S004", "Diana", 102, "321 Elm St"));
        students.add(new Student("S005", "Charlie", "Computer Science", "654 Maple Dr"));
        
        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student);
        }
        
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        System.out.println("\nAfter sorting by name:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}