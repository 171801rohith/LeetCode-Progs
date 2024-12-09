import java.util.Scanner;

public class SatckImplementation {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Enter your choice : 1. PUSH  2. POP 3. DISPLAY 4. EXIT :");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.print("Enter the value to push");
                        int val = sc.nextInt();
                        stack.push(val);
                        break;
                    case 2:
                        int popped = stack.pop();
                        System.out.println("Popped value is: " + popped);
                        break;
                    case 3:
                        stack.display();
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