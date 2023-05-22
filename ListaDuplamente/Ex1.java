package ListaDuplamente;

public class Ex1 {
    public static void main(String[] args) {
       
        LinkedList list1 = new LinkedList();
        list1.append(1);
        list1.append(3);
        list1.append(5);

        LinkedList list2 = new LinkedList();
        list2.append(2);
        list2.append(4);
        list2.append(6);

        LinkedList concatList = LinkedList.concatenate(list1, list2);
        System.out.println("Lista concatenada: " + concatList.toString());

     
        LinkedList[] separatedLists = concatList.separate();
        System.out.println("Primeira lista separada: " + separatedLists[0].toString());
        System.out.println("Segunda lista separada: " + separatedLists[1].toString());

       
        LinkedList sortedList1 = new LinkedList();
        sortedList1.append(1);
        sortedList1.append(3);
        sortedList1.append(5);

        LinkedList sortedList2 = new LinkedList();
        sortedList2.append(2);
        sortedList2.append(4);
        sortedList2.append(6);

      
        LinkedList mergedList = LinkedList.merge(sortedList1, sortedList2);
        System.out.println("Lista intercalada ordenada: " + mergedList.toString());
    }

    static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static class LinkedList {
        private Node head;
        private Node tail;

        public void append(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        public static LinkedList concatenate(LinkedList list1, LinkedList list2) {
            LinkedList concatenatedList = new LinkedList();

            Node current = list1.head;
            while (current != null) {
                concatenatedList.append(current.data);
                current = current.next;
            }

            current = list2.head;
            while (current != null) {
                concatenatedList.append(current.data);
                current = current.next;
            }

            return concatenatedList;
        }

        public LinkedList[] separate() {
            LinkedList[] separatedLists = new LinkedList[2];
            separatedLists[0] = new LinkedList();
            separatedLists[1] = new LinkedList();

            Node current = head;
            int count = 1;
            while (current != null) {
                if (count % 2 == 1) {
                    separatedLists[0].append(current.data);
                } else {
                    separatedLists[1].append(current.data);
                }
                current = current.next;
                count++;
            }

            return separatedLists;
        }

        public static LinkedList merge(LinkedList list1, LinkedList list2) {
            LinkedList mergedList = new LinkedList();

            Node current1 = list1.head;
            Node current2 = list2.head;

            while (current1 != null && current2 != null) {
                if (current1.data < current2.data) {
                    mergedList.append(current1.data);
                    current1 = current1.next;
                } else {
                    mergedList.append(current2.data);
                    current2 = current2.next;
                }
            }

            while (current1 != null) {
                mergedList.append(current1.data);
                current1 = current1.next;
            }

            while (current2 != null) {
                mergedList.append(current2.data);
                current2 = current2.next;
            }

            return mergedList;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.data).append(" ");
                current = current.next;
            }
            return sb.toString();
        }
    }
}
