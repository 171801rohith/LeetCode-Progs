// 56. Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:
//  Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

// Example 2:
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

import java.util.Arrays;

public class MergeIntervals {
       public int[][] merge(int[][] intervals) {
        int n = intervals.length, m = intervals[0].length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // for (int i = 0; i < n; i++){
        //     int minIdx = i;
        //     for (int j = i + 1; j < n; j++) 
        //         if (intervals[minIdx][0] > intervals[j][0]) minIdx = j;
            
        //     if (minIdx != i) {
        //         int[] temp = intervals[i];
        //         intervals[i] = intervals[minIdx];
        //         intervals[minIdx] = temp;
        //     }
        // }
        
        int[][] arr = new int[n][m];
        int k = 0;

        int[] cur = intervals[0];
        for (int i = 1; i < n; i++) {
            if (cur[1] >= intervals[i][0]) cur[1] = Math.max(cur[1], intervals[i][1]);
            else {
                arr[k++] = cur;
                cur = intervals[i];
            }
        }        
        arr[k++] = cur;

        return Arrays.copyOf(arr, k);
    }  
}
