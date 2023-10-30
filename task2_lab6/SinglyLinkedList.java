package task2;
public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    public SinglyLinkedList() {
        super();
    }

    // Returns the number of elements in the list.
    public int size() {
        return size;
    }

    // Returns true if the list is empty, and false otherwise.
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns (but does not remove) the first element in the list.
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    // Returns (but does not remove) the last element in the list.
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // Adds a new element to the front of the list.
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    // Adds a new element to the end of the list.
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    // Removes and returns the first element of the list.
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E removedElement = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return removedElement;
    }

    // Removes and returns the last element of the list.
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            E removedElement = head.getElement();
            head = null;
            tail = null;
            size = 0;
            return removedElement;
        }
        Node<E> current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        E removedElement = tail.getElement();
        current.setNext(null);
        tail = current;
        size--;
        return removedElement;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    public static void main(String[] args) {
        // Tạo một danh sách liên kết mới
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        // Kiểm tra phương thức isEmpty()
        System.out.println("Is list empty? " + list.isEmpty()); 

        // Thêm các phần tử vào danh sách
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.addLast(5);

        // Kiểm tra phương thức size()
        System.out.println("List size: " + list.size()); 

        // Kiểm tra phương thức isEmpty()
        System.out.println("Is list empty? " + list.isEmpty()); 

        // Kiểm tra phương thức first()
        System.out.println("First element: " + list.first()); 

        // Kiểm tra phương thức last()
        System.out.println("Last element: " + list.last()); 

        // Kiểm tra phương thức removeFirst()
        int removedElement = list.removeFirst();
        System.out.println("Removed first element: " + removedElement); 

        // Kiểm tra phương thức removeLast()
        removedElement = list.removeLast();
        System.out.println("Removed last element: " + removedElement); 

        // Kiểm tra phương thức size() sau khi xóa phần tử
        System.out.println("List size after removal: " + list.size()); 

        // Kiểm tra lại phương thức first() và last()
        System.out.println("First element: " + list.first()); 
        System.out.println("Last element: " + list.last()); 
    }
}