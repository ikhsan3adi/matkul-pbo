import java.util.TreeMap;
import java.util.Map;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<String, Integer> treeMap = new TreeMap<>();
        
        // Put elements - otomatis tersortir berdasarkan key
        treeMap.put("John", 25);
        treeMap.put("Alice", 30);
        treeMap.put("Bob", 28);
        // treeMap.put(null, 0); // Tidak mengizinkan null key
        
        System.out.println("TreeMap: " + treeMap); // {Alice=30, Bob=28, John=25}
        
        // First and last key
        System.out.println("First key: " + ((TreeMap<String, Integer>) treeMap).firstKey());
        System.out.println("Last key: " + ((TreeMap<String, Integer>) treeMap).lastKey());
        
        // Submap operations
        Map<String, Integer> subMap = ((TreeMap<String, Integer>) treeMap)
                                      .subMap("Alice", "John");
        System.out.println("SubMap: " + subMap);
        
        // Descending order
        System.out.println("Descending: " + ((TreeMap<String, Integer>) treeMap).descendingMap());
    }
}