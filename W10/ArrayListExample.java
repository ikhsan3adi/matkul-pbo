import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        
        // Add elements
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");
        
        // Access by index - sangat cepat O(1)
        System.out.println("Element at index 1: " + arrayList.get(1));
        
        // Iteration
        for (String language : arrayList) {
            System.out.println(language);
        }
        
        // Remove element - kurang efisien untuk posisi awal
        arrayList.remove(0);
        System.out.println("After removal: " + arrayList);
    }
}