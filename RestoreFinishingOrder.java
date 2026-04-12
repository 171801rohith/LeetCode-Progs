// 3668. Restore Finishing Order
// You are given an integer array order of length n and an integer array friends.
// order contains every integer from 1 to n exactly once, representing the IDs of the participants of a race in their finishing order.
// friends contains the IDs of your friends in the race sorted in strictly increasing order. Each ID in friends is guaranteed to appear in the order array.
// Return an array containing your friends' IDs in their finishing order.

// Example 1:
// Input: order = [3,1,2,5,4], friends = [1,3,4]
// Output: [3,1,4]
// Explanation:
// The finishing order is [3, 1, 2, 5, 4]. Therefore, the finishing order of your friends is [3, 1, 4].

// Example 2:
// Input: order = [1,4,5,3,2], friends = [2,5]
// Output: [5,2]
// Explanation:
// The finishing order is [1, 4, 5, 3, 2]. Therefore, the finishing order of your friends is [5, 2].

public class RestoreFinishingOrder {
    public boolean binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return false;
        int mid = low + (high - low) / 2;

        if (nums[mid] == target) return true;
        else if (nums[mid] < target) return binarySearch(nums, mid + 1, high, target);
        else return binarySearch(nums, low, mid - 1, target);
    }

    public int[] recoverOrder(int[] order, int[] friends) {
        int[] result = new int[friends.length];
        int j = 0;
        for (int i: order) 
            if (binarySearch(friends, 0, friends.length - 1, i)) result[j++] = i;
        
        return result;
    }
}