// 35. Search Insert Position
// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
// You must write an algorithm with O(log n) runtime complexity.
// Example 1:
// Input: nums = [1,3,5,6], target = 5
// Output: 2

// Example 2:
// Input: nums = [1,3,5,6], target = 2
// Output: 1

// Example 3:
// Input: nums = [1,3,5,6], target = 7
// Output: 4

import java.util.ArrayList;

public class InsertPosition {

    public boolean checkGreat(ArrayList<Integer> nums, int target) {
        int great = target;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > great) {
                great = nums.get(i);
            }
        }
        if (great == target) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSmall(ArrayList<Integer> nums, int target) {
        int small = target;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < small) {
                small = nums.get(i);
            }
        }
        if (small == target) {
            return true;
        } else {
            return false;
        }
    }

    public int searchInsert(int[] nums, int target) {
        ArrayList<Integer> numsList = new ArrayList<Integer>();
        for (int i : nums) {
            numsList.add(i);
        }
        if (numsList.contains(target)) {
            return numsList.indexOf(target);
        } else if (checkGreat(numsList, target)) {
            System.out.println(90);
            return numsList.size();
        } else if (checkSmall(numsList, target)) {
            return 0;
        } else if (numsList.size() == 2) {
            if (numsList.get(0) < target && numsList.get(1) > target) {
                return 1;
            } else if (checkGreat(numsList, target)) {
                return numsList.size();
            } else {
                return 0;
            }
        } else {
            for (int i = 1; i < numsList.size(); i++) {
                if (target > numsList.get(i - 1) && target < numsList.get(i)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
