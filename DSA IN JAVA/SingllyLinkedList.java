public class SingllyLinkedList {
    private int data;
    private SingllyLinkedList next, head = null, tail;

    void insertRear(int data) {
        SingllyLinkedList newNode = new SingllyLinkedList();
        newNode.data = data;
        newNode.next = null;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    int deleteFront(){
        if (head == null) {
            System.out.println("Empty list");
            return -1;
        } else {
            int val = head.data;
            head = head.next;
            if (head == null) tail = null; 
            return val;
        }
    }

    void display() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            SingllyLinkedList temp = head;
            while (temp != null) {
                System.out.print(temp.data);
                temp = temp.next;
                if (temp != null) System.out.print(" -> ");
            }
            System.out.println();
        }
    }
}
