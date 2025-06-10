// Sorted Column-wise and Row-wise

import java.util.Arrays;

public class BinarySearchRowColMatrix {
    public static int[] search(int[][] a, int target) {
        int row = 0, col = a[0].length - 1;
        while (col >= 0 && row < a.length) {
            if (a[row][col] == target) {
                return new int[] { row, col };
            } else if (a[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[][] a = {
                { 10, 20, 30, 40 },
                { 11, 23, 36, 43 },
                { 20, 29, 38, 47 }
        };
        int[] result = search(a, 47);
        System.out.println(Arrays.toString(result));
    }
}