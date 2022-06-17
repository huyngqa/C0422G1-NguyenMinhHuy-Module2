package ss10_dsa_list.excercise.my_linkedlist;

public class MyListTest {
    public static void main(String[] args) {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.addFirst("a");
        stringMyLinkedList.addFirst("b");
        stringMyLinkedList.addFirst("e");
        stringMyLinkedList.addFirst("c");
        stringMyLinkedList.printList();
    }
}
