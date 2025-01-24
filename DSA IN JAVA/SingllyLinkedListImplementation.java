public class SingllyLinkedListImplementation {
    public static void main(String[] args) {
        SingllyLinkedList l = new SingllyLinkedList();
        l.deleteFront();
        l.insertRear(10);
        l.insertRear(20);
        l.insertRear(30);
        l.insertRear(50);
        l.insertRear(60);
        l.display();
        l.deleteFront();
        l.deleteFront();
        l.display();
    }
}
