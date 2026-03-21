// 217. Contains Duplicate
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: true
// Explanation:
// The element 1 occurs at the indices 0 and 3.

// Example 2:
// Input: nums = [1,2,3,4]
// Output: false
// Explanation:
// All elements are distinct.

// Example 3:
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true



// 219. Contains Duplicate II
// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

// Example 1:
// Input: nums = [1,2,3,1], k = 3
// Output: true

// Example 2:
// Input: nums = [1,0,1,1], k = 1
// Output: true

// Example 3:
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false


// import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // for(int i = 0; i < nums.length - 1 ; i++){
        // if(nums[i] == nums[i+1]) return true;
        // }
        // return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }   
        return false;

    }

    public boolean containsNearbyDuplicatelazy(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.get(nums[i]).add(i);
            else {
                map.put(nums[i], new ArrayList<Integer>());
                map.get(nums[i]).add(i);
            }
        }

        System.out.println(map);

        for (Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
            if (entry.getValue().size() > 1) {
                for (int i = 0; i < entry.getValue().size() - 1; i++) {
                    int diff = Math.abs(entry.getValue().get(i) - entry.getValue().get(i + 1)) ;
                    if (diff <= k) return true;
                }
                
            }
        }

        return false;

    }
}
