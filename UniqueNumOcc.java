// 1207. Unique Number of Occurrences
// Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

// Example 1:
// Input: arr = [1,2,2,1,1,3]
// Output: true
// Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

// Example 2:
// Input: arr = [1,2]
// Output: false

// Example 3:
// Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
// Output: true
 

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumOcc {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.compute(i, (key, value) -> value + 1);
            } else {
                map.put(i, 1);
            }
        }

        Collection<Integer> values = map.values();
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : values) {
            if (set.contains(i))
                return false;
            set.add(i);
        }
        return true;
    }
}
