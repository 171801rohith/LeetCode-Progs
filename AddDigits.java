// 258. Add Digits
// Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

// Example 1:
// Input: num = 38
// Output: 2
// Explanation: The process is
// 38 --> 3 + 8 --> 11
// 11 --> 1 + 1 --> 2 
// Since 2 has only one digit, return it.

// Example 2:
// Input: num = 0
// Output: 0

import java.util.ArrayList;

public class AddDigits {
    public int addNums(ArrayList<Integer> nums) {
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return sum;
    }

    public ArrayList<Integer> storeInArray(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (num != 0) {
            arr.add(num % 10);
            num /= 10;
        }
        return arr;
    }

    public int addDigits(int num) {
        if (num == 0)
            return 0;
        while (num > 9) {
            ArrayList<Integer> nums = storeInArray(num);
            num = addNums(nums);
        }
        return num;
    }
}
