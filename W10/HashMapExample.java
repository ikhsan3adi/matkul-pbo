import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        
        // Put elements
        hashMap.put("John", 25);
        hashMap.put("Alice", 30);
        hashMap.put("Bob", 28);
        hashMap.put(null, 0); // Null key allowed
        hashMap.put("Diana", null); // Null value allowed
        
        System.out.println("HashMap: " + hashMap);
        
        // Get value - sangat cepat O(1)
        System.out.println("John's age: " + hashMap.get("John"));
        
        // Check key existence
        System.out.println("Contains Alice: " + hashMap.containsKey("Alice"));
        
        // Iterate through entries
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}