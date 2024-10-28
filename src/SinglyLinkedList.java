import java.util.Stack;

public class SinglyLinkedList<E> {
    Node<E> head;
    Node<E> tail;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node<E> temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    public void add(E e) {
        if (isEmpty()) {
            tail = new Node<>(e);
            head = tail;
        }
        else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
    }

    public void append(SinglyLinkedList<E> input) {
        tail.next = input.head;
        input.tail = tail;
    }

    public void display(){
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void reverse(){
        if (isEmpty()) {
            return;
        }
        Node<E> temp = head;
        Stack<Node<E>> stack = new Stack<>();

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        head = stack.pop();
        temp = head;

        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }

        temp.next = null;
    }
}
