import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        
        // Add elements - tidak menjamin urutan
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Apple"); // Duplicate, akan diabaikan
        
        System.out.println("HashSet: " + hashSet); // Urutan bisa berubah-ubah
        
        // Check containment - sangat cepat O(1)
        System.out.println("Contains Apple: " + hashSet.contains("Apple"));
        
        // Allow null
        hashSet.add(null);
        System.out.println("After adding null: " + hashSet);
    }
}