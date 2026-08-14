// 378. Kth Smallest Element in a Sorted Matrix
// Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
// Note that it is the kth smallest element in the sorted order, not the kth distinct element.
// You must find a solution with a memory complexity better than O(n2).

// Example 1:
// Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
// Output: 13
// Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

// Example 2:
// Input: matrix = [[-5]], k = 1
// Output: -5
 

import java.util.PriorityQueue;

class Cell {
    int value;
    int row;
    int col;

    Cell(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }
}

public class KthSmallestElementInSortedMat {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.value, b.value));

        for (int i = 0; i < matrix.length; i++) minHeap.offer(new Cell(matrix[i][0], i, 0));

        for (int count = 0; count < k; count++) {
            Cell cell = minHeap.poll();

            if (count == k - 1)
                return cell.value;

            int nxtCol = cell.col + 1;
            if (nxtCol < matrix[0].length)
                minHeap.offer(new Cell(
                        matrix[cell.row][nxtCol],
                        cell.row,
                        nxtCol));
        }
        return -1;

    }
}
