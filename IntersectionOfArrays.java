// 349. Intersection of Two Arrays
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]

// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.


// 350. Intersection of Two Arrays II
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]

// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// Explanation: [9,4] is also accepted.

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (nums1.length < nums2.length) {
            for (int num1 : nums1)
                if (Arrays.binarySearch(nums2, num1) >= 0 && !list.contains(num1))
                    list.add(num1);
        } else {
            for (int num2 : nums2)
                if (Arrays.binarySearch(nums1, num2) >= 0 && !list.contains(num2))
                    list.add(num2);
        }

        // List to int Array convertion
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (p1 != nums1.length && p2 != nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                list.add(nums1[p1]);
                p1++; p2++;
            } else if (nums1[p1] < nums2[p2]) p1++;
            else p2++;

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);

        return res;

    }
}
