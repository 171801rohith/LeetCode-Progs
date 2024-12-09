// Satck Array
public class StackArr {
    private int top = -1;
    private int maxSize;
    private int[] stackArray;

    public StackArr(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
    }

    public void push(int val) {
        if (top == maxSize - 1) {
            System.out.println("OverFlow");
        } else {
            top++;
            stackArray[top] = val;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Underflow");
            return -1;
        } else {
            int poppedValue = stackArray[top];
            top--;
            return poppedValue;
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            for (int i = top ; i >= 0; i--) {
                System.out.println(stackArray[i]);
            }
        }
    }
}