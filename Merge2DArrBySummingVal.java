// 2570. Merge Two 2D Arrays by Summing Values
// You are given two 2D integer arrays nums1 and nums2.
// nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
// nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
// Each array contains unique ids and is sorted in ascending order by id.
// Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:
// Only ids that appear in at least one of the two arrays should be included in the resulting array.
// Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
// Return the resulting array. The returned array must be sorted in ascending order by id.

// Example 1:
// Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
// Output: [[1,6],[2,3],[3,2],[4,6]]
// Explanation: The resulting array contains the following:
// - id = 1, the value of this id is 2 + 4 = 6.
// - id = 2, the value of this id is 3.
// - id = 3, the value of this id is 2.
// - id = 4, the value of this id is 5 + 1 = 6.

// Example 2:
// Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
// Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
// Explanation: There are no common ids, so we just include each id with its value in the resulting list.
 
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Merge2DArrBySummingVal {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] arr = new int[nums1.length + nums2.length][2];
        int i = 0, k = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) arr[k++] = new int[] {nums1[i][0], nums1[i++][1] + nums2[j++][1]};
            else if (nums1[i][0] < nums2[j][0]) arr[k++] = nums1[i++];
            else arr[k++] = nums2[j++];
        }
        while (i < nums1.length) arr[k++] = nums1[i++];
        while (j < nums2.length) arr[k++] = nums2[j++];

        return Arrays.copyOf(arr, k);
    }

    public int[][] mergeArraysLazy(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) 
            map.put(nums1[i][0], map.getOrDefault(nums1[i][0], 0) + nums1[i][1]); 
        for (int i = 0; i < nums2.length; i++)   
            map.put(nums2[i][0], map.getOrDefault(nums2[i][0], 0) + nums2[i][1]); 

        int[][] res = new int[map.size()][2];

        map = new TreeMap<>(map);
        int i = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            res[i][0] = entry.getKey();
            res[i][1] = entry.getValue();
            i++;
        }
        return res;
    }
}
