public class CircularQueueArr {
    int front = -1, rear = -1;
    int maxSize;
    private int[] cirqueueArray;

    public CircularQueueArr(int maxSize) {
        this.maxSize = maxSize;
        cirqueueArray = new int[maxSize];
    }

    public void enqueue(int value) {
        if ((rear + 1) % maxSize == front) {
            System.out.println("OverFlow !!");
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % maxSize;
        }
        cirqueueArray[rear] = value;
    }

    public int dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("UnderFlow !!");
            return -1;
        } else if (rear == front) {
            int dequeueVal = cirqueueArray[front];
            front = rear = -1;
            return dequeueVal;
        } else {
            int dequeueVal = cirqueueArray[front];
            front = (front + 1) % maxSize;
            return dequeueVal;
        }
    }

    public void display() {
        if (front == -1 && rear == -1) {
            System.out.println("UnderFlow !!");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(cirqueueArray[i]);
                i = (i + 1) % maxSize;
            }
            System.out.println(cirqueueArray[rear]);

        }
    }
}
