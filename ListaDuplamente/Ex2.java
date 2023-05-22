package ListaDuplamente;

public class Ex2 {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtFront(3);
        list.insertAtFront(2);
        list.insertAtFront(1);

        list.insertAtEnd(4);
        list.insertAtEnd(5);

        list.displayForward(); 
        list.displayBackward(); 

        System.out.println("Search 3: " + list.search(3)); 
        System.out.println("Search 6: " + list.search(6)); 

        list.delete(3);
        list.displayForward(); 
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public void insertAtFront(Object data) {
        Node newNode = new Node(data);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    public void insertAtEnd(Object data) {
        Node newNode = new Node(data);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public boolean search(Object data) {
        Node current = head.next;
        while (current != tail) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void delete(Object data) {
        Node current = head.next;
        while (current != tail) {
            if (current.data.equals(data)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return;
            }
            current = current.next;
        }
    }

    public void displayForward() {
        Node current = head.next;
        while (current != tail) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Node current = tail.prev;
        while (current != head) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    private class Node {
        private Object data;
        private Node prev;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}

