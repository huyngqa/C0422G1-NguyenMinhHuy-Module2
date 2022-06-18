package ss10_dsa_list.excercise.my_linkedlist;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public int size() {
        return numNodes;
    }
}
