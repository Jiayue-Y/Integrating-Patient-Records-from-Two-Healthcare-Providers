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


}
