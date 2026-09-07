package taskflow.ds;

public class MyQueue<T> {

    private Node<T> front;
    private Node<T> rear;

    public MyQueue() {
        front = null;
        rear = null;
    }

    // Add item to queue
    public void enqueue(T data) {

        Node<T> newNode = new Node<>(data);

        if (rear == null) {

            front = newNode;
            rear = newNode;

            return;
        }

        rear.next = newNode;

        rear = newNode;
    }

    // Remove item from front
    public T dequeue() {

        if (front == null) {
            return null;
        }

        T data = front.data;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    // See the first item
    public T peek() {

        if (front == null) {
            return null;
        }

        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {

        return front == null;
    }
}