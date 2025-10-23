import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();
        
        // Add elements
        linkedList.add("Java");
        linkedList.add("Python");
        linkedList.add("C++");
        
        // Add at beginning - sangat cepat O(1)
        ((LinkedList<String>) linkedList).addFirst("JavaScript");
        
        // Add at end - sangat cepat O(1)
        ((LinkedList<String>) linkedList).addLast("Go");
        
        // Remove from beginning - sangat cepat O(1)
        ((LinkedList<String>) linkedList).removeFirst();
        
        System.out.println("LinkedList: " + linkedList);
        
        // Access by index - lambat O(n)
        System.out.println("Element at index 2: " + linkedList.get(2));
    }
}