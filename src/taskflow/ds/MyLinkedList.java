package taskflow.ds;

import taskflow.model.Task;

import java.util.ArrayList;

public class MyLinkedList<T> {

    private Node<T> head;

    // ==============================
    // CONSTRUCTOR
    // ==============================

    public MyLinkedList() {
        head = null;
    }

    // ==============================
    // ADD
    // ==============================

    public void add(T data) {

        Node<T> newNode = new Node<>(data);

        // If list is empty
        if (head == null) {

            head = newNode;
            return;
        }

        // Find the last node
        Node<T> current = head;

        while (current.next != null) {

            current = current.next;
        }

        // Connect last node to new node
        current.next = newNode;
    }

    // ==============================
    // DISPLAY
    // ==============================

    public void display() {

        Node<T> current = head;

        while (current != null) {

            System.out.println(current.data);

            current = current.next;
        }
    }

    // ==============================
    // CHECK IF EMPTY
    // ==============================

    public boolean isEmpty() {

        return head == null;
    }

    // ==============================
    // FIND TASK BY ID
    // ==============================

    public T findById(int id) {

        Node<T> current = head;

        while (current != null) {

            if (current.data instanceof Task task) {

                if (task.getId() == id) {

                    return current.data;
                }
            }

            current = current.next;
        }

        return null;
    }

    // ==============================
    // CHECK ID
    // ==============================

    public boolean containsId(int id) {

        return findById(id) != null;
    }

    // ==============================
    // DELETE TASK BY ID
    // ==============================

    public boolean deleteById(int id) {

        // Empty list
        if (head == null) {

            return false;
        }

        // Delete first node
        if (head.data instanceof Task task) {

            if (task.getId() == id) {

                head = head.next;

                return true;
            }
        }

        // Search remaining nodes
        Node<T> current = head;

        while (current.next != null) {

            if (current.next.data instanceof Task task) {

                if (task.getId() == id) {

                    // Skip the node
                    current.next = current.next.next;

                    return true;
                }
            }

            current = current.next;
        }

        return false;
    }

    // ==============================
    // CONVERT TO ARRAYLIST
    // ==============================
    
    // Used by TaskFileManager
    public ArrayList<T> toArrayList() {

        ArrayList<T> list = new ArrayList<>();

        Node<T> current = head;

        while (current != null) {

            list.add(current.data);

            current = current.next;
        }

        return list;
    }

    // ==============================
    // SORT BY PRIORITY
    // ==============================

    public void sortByPriority() {

        if (head == null || head.next == null) {

            return;
        }

        Node<T> current = head;

        while (current != null) {

            Node<T> next = current.next;

            while (next != null) {

                if (current.data instanceof Task task1 &&
                    next.data instanceof Task task2) {

                    int priority1 =
                            getPriorityValue(task1.getPriority());

                    int priority2 =
                            getPriorityValue(task2.getPriority());

                    if (priority1 > priority2) {

                        T temp = current.data;

                        current.data = next.data;

                        next.data = temp;
                    }
                }

                next = next.next;
            }

            current = current.next;
        }
    }

    // ==============================
    // PRIORITY VALUE
    // ==============================

    private int getPriorityValue(String priority) {

        if (priority.equals("HIGH")) {

            return 1;
        }

        if (priority.equals("MEDIUM")) {

            return 2;
        }

        return 3;
    }

    // ==============================
    // SORT BY ID
    // ==============================

    public void sortById() {

        if (head == null || head.next == null) {

            return;
        }

        Node<T> current = head;

        while (current != null) {

            Node<T> next = current.next;

            while (next != null) {

                if (current.data instanceof Task task1 &&
                    next.data instanceof Task task2) {

                    if (task1.getId() > task2.getId()) {

                        T temp = current.data;

                        current.data = next.data;

                        next.data = temp;
                    }
                }

                next = next.next;
            }

            current = current.next;
        }
    }
}