package ListaDuplamente;

public class Ex3 {
    public static void main(String[] args) {
        CircularLinkedList list1 = new CircularLinkedList();

        list1.insertAtHead(3);
        list1.insertAtHead(2);
        list1.insertAtHead(1);

        System.out.println("Número de elementos: " + list1.countElements()); 

        CircularLinkedList list2 = new CircularLinkedList();
        list2.insertAtHead(6);
        list2.insertAtHead(5);
        list2.insertAtHead(4);

        System.out.println("Lista 1: " + list1.toString()); 
        System.out.println("Lista 2: " + list2.toString()); 

        list1.concatenate(list2);

        System.out.println("Lista concatenada: " + list1.toString()); 

        CircularLinkedList sortedList1 = new CircularLinkedList();
        sortedList1.insertSorted(5);
        sortedList1.insertSorted(3);
        sortedList1.insertSorted(1);

        CircularLinkedList sortedList2 = new CircularLinkedList();
        sortedList2.insertSorted(6);
        sortedList2.insertSorted(4);
        sortedList2.insertSorted(2);

        CircularLinkedList mergedList = CircularLinkedList.merge(sortedList1, sortedList2);
        System.out.println("Lista intercalada ordenada: " + mergedList.toString()); 

        CircularLinkedList listCopy = list1.copy();
        System.out.println("Cópia da lista: " + listCopy.toString()); 
    }
}

class CircularLinkedList {
    private Node head;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            newNode.next = head;
            current.next = newNode;
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
        int count = 1;
        while (current.next != head) {
            current = current.next;
            count++;
        }
        return count;
    }

    public void concatenate(CircularLinkedList list) {
        if (head == null) {
            head = list.head;
        } else if (list.head != null) {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = list.head;
            Node listLastNode = list.head;
            while (listLastNode.next != list.head) {
                listLastNode = listLastNode.next;
            }
            listLastNode.next = head;
        }
    }

    public static CircularLinkedList merge(CircularLinkedList list1, CircularLinkedList list2) {
        CircularLinkedList mergedList = new CircularLinkedList();
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

    public CircularLinkedList copy() {
        CircularLinkedList newList = new CircularLinkedList();
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
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
