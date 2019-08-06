public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sLinked = new SinglyLinkedList();
        sLinked.add(1);
        sLinked.add(2);
        sLinked.add(3);
        sLinked.add(4);

        sLinked.print();
        sLinked.remvoe(3);
        sLinked.print();
    }
}