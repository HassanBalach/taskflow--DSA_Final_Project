package taskflow.ds;

public class MyStack<T> {

    private Node<T> top;

    public MyStack() {
        top = null;
    }

    // Add item to stack
    public void push(T data) {

        Node<T> newNode = new Node<>(data);

        newNode.next = top;

        top = newNode;
    }

    // Remove and return top item
    public T pop() {

        if (top == null) {
            return null;
        }

        T data = top.data;

        top = top.next;

        return data;
    }

    // Look at top item without removing it
    public T peek() {

        if (top == null) {
            return null;
        }

        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {

        return top == null;
    }
}