// 57. Insert Interval
// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
// Two intervals are considered overlapping if they share at least one point.
// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
// Return intervals after the insertion.
// Note that you don't need to modify intervals in-place. You can make a new array and return it.

// Example 1:
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]

// Example 2:
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

import java.util.Arrays;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] { newInterval };

        int n = intervals.length, m = intervals[0].length;
        int[][] arr = new int[n + 1][m];

        for (int i = 0; i < n; i++) arr[i] = intervals[i];
        arr[n] = newInterval;

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0],b[0]));

        int[][] res = new int[n + 1][m];
        int[] cur = arr[0];
        int k = 0;
        
        for (int i = 1; i < n + 1; i++) {
            if (cur[1] >= arr[i][0]) cur[1] = Math.max(cur[1], arr[i][1]);
            else {
                res[k++] = cur;
                cur = arr[i];
            }
        }
        res[k++] = cur;
        return Arrays.copyOf(res, k);
    }
}
