import java.util.Scanner;

public class QueueImplementation {
    public static void main(String[] args) {
        QueueArr queue = new QueueArr(5);
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Enter your choice : 1. ENQUEUE  2. DEQUEUE 3. DISPLAY 4. EXIT :");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.print("Enter the value to enqueue :");
                        int val = sc.nextInt();
                        queue.enqueue(val);
                        break;
                    case 2:
                        int dequeueVal = queue.dequeue();
                        System.out.println("Dequeued value is: " + dequeueVal);
                        break;
                    case 3:
                        queue.display();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice...");
                }
            }
        } finally {
            sc.close();
        }
    }
}
