public class Recursion {

    public static void printNums(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        printNums(n - 1);
        System.out.println(n);
    }

    public static int fibonacci(int n) {
        if (n < 2)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        // printNums(6);
        for (int i = 0; i <= 5; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
