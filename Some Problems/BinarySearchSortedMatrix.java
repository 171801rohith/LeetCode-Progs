import java.util.Arrays;

public class BinarySearchSortedMatrix {

    public static int[] binarySearch(int[][] a, int target, int row, int cStart, int cEnd) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (a[row][mid] == target)
                return new int[] { row, mid };
            else if (a[row][mid] > target)
                cEnd = mid - 1;
            else
                cStart = mid + 1;
        }
        return new int[] { -1, -1 };
    }

    public static int[] search(int[][] a, int target) {
        int rows = a.length, cols = a[0].length;
        if (rows == 1)
            return binarySearch(a, target, 0, 0, cols - 1);

        int rStart = 0, rEnd = rows - 1, cMid = cols / 2;
        while (rStart < rEnd - 1) {
            int rMid = rStart + (rEnd - rStart) / 2;
            if (a[rMid][cMid] == target)
                return new int[] { rMid, cMid };
            else if (a[rMid][cMid] < target)
                rStart = rMid;
            else
                rEnd = rMid;
        }

        if (a[rStart][cMid] == target)
            return new int[] { rStart, cMid };
        if (a[rStart + 1][cMid] == target)
            return new int[] { rStart + 1, cMid };

        if (target <= a[rStart][cMid - 1])
            return binarySearch(a, target, rStart, 0, cMid - 1);

        if (target >= a[rStart][cMid + 1] && target <= a[rStart][cols - 1])
            return binarySearch(a, target, rStart, cMid + 1, cols - 1);

        if (target <= a[rStart + 1][cMid - 1])
            return binarySearch(a, target, rStart + 1, 0, cMid - 1);

        if (target >= a[rStart + 1][cMid + 1] && target <= a[rStart + 1][cols - 1])
            return binarySearch(a, target, rStart + 1, cMid + 1, cols - 1);

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 5, 7 },
                { 9, 11, 13, 16 },
                { 20, 23, 25, 29 },
                { 30, 31, 33, 37 }
        };

        System.out.println(Arrays.toString(search(a, 37)));
    }
}
