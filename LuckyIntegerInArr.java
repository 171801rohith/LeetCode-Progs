// 1394. Find Lucky Integer in an Array
// Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.
// Return the largest lucky integer in the array. If there is no lucky integer return -1.

// Example 1:
// Input: arr = [2,2,3,4]
// Output: 2
// Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

// Example 2:
// Input: arr = [1,2,2,3,3,3]
// Output: 3
// Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.

// Example 3:
// Input: arr = [2,2,2,3,3]
// Output: -1
// Explanation: There are no lucky numbers in the array.
 


import java.util.HashMap;
import java.util.Map;

public class LuckyIntegerInArr {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for (int n: arr) freq[n]++;
        int max = -1;
        for (int i = 1; i <= 500; i++) 
            if (i == freq[i]) max = Math.max(max, i);
        return max; 
    }

    public int findLuckyLazy(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n: arr) map.put(n, map.getOrDefault(n, 0) + 1);
        int max = -1;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getValue().equals(entry.getKey())) 
                max = Math.max(max, entry.getKey());     
        }
        return max; 
    } 
}
