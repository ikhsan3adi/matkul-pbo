import java.util.ArrayList;

public class GenericStack<T> {
  private ArrayList<T> items;

  public GenericStack() {
    items = new ArrayList<T>();
  }

  public void push(T item) {
    items.add(item);
  }

  public T pop() {
    if (isEmpty()) {
      throw new GenericStackException("Underflow Error");
    }
    return items.remove(items.size() - 1);
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }

  public static class GenericStackException extends RuntimeException {
    public GenericStackException(String message) {
      super(message);
    }
  }

  public static void main(String[] args) {
    GenericStack<Integer> stack = new GenericStack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    // stack.push(4); //overflow error
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}