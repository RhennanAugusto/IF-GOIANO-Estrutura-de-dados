package ListaDuplamente;

public class Ex4 {
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtHead(1);

        System.out.println("Número de elementos: " + list.countElements()); 

        CircularDoublyLinkedList list2 = new CircularDoublyLinkedList();
        list2.insertAtHead(6);
        list2.insertAtHead(5);
        list2.insertAtHead(4);

        System.out.println("Lista 1: " + list.toString()); 
        System.out.println("Lista 2: " + list2.toString()); 

        list.concatenate(list2);

        System.out.println("Lista concatenada: " + list.toString()); 

        CircularDoublyLinkedList sortedList1 = new CircularDoublyLinkedList();
        sortedList1.insertSorted(5);
        sortedList1.insertSorted(3);
        sortedList1.insertSorted(1);

        CircularDoublyLinkedList sortedList2 = new CircularDoublyLinkedList();
        sortedList2.insertSorted(6);
        sortedList2.insertSorted(4);
        sortedList2.insertSorted(2);

        CircularDoublyLinkedList mergedList = CircularDoublyLinkedList.merge(sortedList1, sortedList2);
        System.out.println("Lista intercalada ordenada: " + mergedList.toString()); 

        CircularDoublyLinkedList listCopy = list.copy();
        System.out.println("Cópia da lista: " + listCopy.toString()); 
    }
}

class CircularDoublyLinkedList {
    private Node head;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertSorted(int i) {
    }

    public int countElements() {
        if (head == null) {
            return 0;
        }
        Node current = head;
        int count = 0;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    public void concatenate(CircularDoublyLinkedList list) {
        if (head == null) {
            head = list.head;
        } else if (list.head != null) {
            Node current1 = head.prev;
            Node current2 = list.head;
            current1.next = current2;
            current2.prev = current1;
            Node listLastNode = list.head.prev;
            listLastNode.next = head;
            head.prev = listLastNode;
        }
    }

    public static CircularDoublyLinkedList merge(CircularDoublyLinkedList list1, CircularDoublyLinkedList list2) {
        CircularDoublyLinkedList mergedList = new CircularDoublyLinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;
        while (current1 != list1.head && current2 != list2.head) {
            if (current1.data < current2.data) {
                mergedList.insertAtHead(current1.data);
                current1 = current1.next;
            } else {
                mergedList.insertAtHead(current2.data);
                current2 = current2.next;
            }
        }
        while (current1 != list1.head) {
            mergedList.insertAtHead(current1.data);
            current1 = current1.next;
        }
        while (current2 != list2.head) {
            mergedList.insertAtHead(current2.data);
            current2 = current2.next;
        }
        return mergedList;
    }

    public CircularDoublyLinkedList copy() {
        CircularDoublyLinkedList newList = new CircularDoublyLinkedList();
        if (head == null) {
            return newList;
        }
        Node current = head;
        do {
            newList.insertAtHead(current.data);
            current = current.next;
        } while (current != head);
        return newList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            return sb.toString();
        }
        Node current = head;
        do {
            sb.append(current.data).append(" ");
            current = current.next;
        } while (current != head);
        return sb.toString();
    }

    private static class Node {
        private int data;
        private Node prev;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}
