import java.util.TreeSet;
import java.util.Set;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();
        
        // Add elements - otomatis tersortir
        treeSet.add("Orange");
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Apple"); // Duplicate, akan diabaikan
        
        System.out.println("TreeSet: " + treeSet); // [Apple, Banana, Orange]
        
        // First and last elements
        System.out.println("First: " + ((TreeSet<String>) treeSet).first());
        System.out.println("Last: " + ((TreeSet<String>) treeSet).last());
        
        // Subset operations
        Set<String> subSet = ((TreeSet<String>) treeSet).subSet("Apple", "Orange");
        System.out.println("Subset: " + subSet);
    }
}