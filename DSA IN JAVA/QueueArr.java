// Queue Array
public class QueueArr {
    int front = -1, rear = -1;
    int maxSize;
    private int[] queueArray;

    public QueueArr(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
    }

    public void enqueue(int val) {
        if (rear == maxSize - 1) {
            System.out.println("OverFlow !!");
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
        } else {
            rear++;
        }
        queueArray[rear] = val;
    }

    public int dequeue() {
        if (rear == -1 || front > rear) {
            System.out.println("UnderFlow !!");
            return -1;
        } else {
            int dequeueVal = queueArray[front];
            front++;
            return dequeueVal;
        }
    }

    public void display() {
        if (rear == -1 || front > rear) {
            System.out.println("UnderFlow !!");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.println(queueArray[i]);
            }
        }
    }

}
