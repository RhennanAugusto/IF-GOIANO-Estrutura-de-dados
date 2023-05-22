package ListaDuplamente;

public class Ex5 {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insert(3);
        list.insert(2);
        list.insert(1);

        System.out.println("Número de elementos: " + list.countElements()); 

        CircularLinkedList list2 = new CircularLinkedList();
        list2.insert(6);
        list2.insert(5);
        list2.insert(4);

        System.out.println("Lista 1: " + list.toString()); 
        System.out.println("Lista 2: " + list2.toString()); 

        list.concatenate(list2);

        System.out.println("Lista concatenada: " + list.toString()); 
    }
}

class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {
        head = new Node();
        head.next = head;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
    }

    public int countElements() {
        Node current = head.next;
        int count = 0;
        while (current != head) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void concatenate(CircularLinkedList list) {
        Node lastNode = head;
        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }
        lastNode.next = list.head.next;
        list.head.next = head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head.next;
        while (current != head) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }
}

