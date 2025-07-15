// 448. Find All Numbers Disappeared in an Array
// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

// Example 1:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]

// Example 2:
// Input: nums = [1,1]
// Output: [2]

import java.util.ArrayList;
import java.util.List;

public class AllMissingNums {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedList = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct])
                swap(nums, i, correct);
            else
                i++;
        }
        for (int j = 0; j < nums.length; j++)
            if (nums[j] - 1 != j)
                disappearedList.add(j + 1);
                
        return disappearedList;
    }
}
