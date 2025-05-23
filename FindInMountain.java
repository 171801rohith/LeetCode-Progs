// 1095. Find in Mountain Array
// (This problem is an interactive problem.)
// You may recall that an array arr is a mountain array if and only if:
// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
// Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
// You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
// MountainArray.get(k) returns the element of the array at index k (0-indexed).
// MountainArray.length() returns the length of the array.
// Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

// Example 1:
// Input: mountainArr = [1,2,3,4,5,3,1], target = 3
// Output: 2
// Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

// Example 2:
// Input: mountainArr = [0,1,2,4,2,1], target = 3
// Output: -1
// Explanation: 3 does not exist in the array, so we return -1.

interface MountainArray {
    public int get(int index);

    public int length();
}

public class FindInMountain {
    public int binarySearchAnyOrder(MountainArray mountainArr, int target, int start, int end) {
        boolean isAsc = mountainArr.get(start) < mountainArr.get(end);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == mountainArr.get(mid)) {
                return mid;
            }
            if (isAsc) {
                if (mountainArr.get(mid) < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (mountainArr.get(mid) > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int low = 0, high = mountainArr.length() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int mid = peakIndexInMountainArray(mountainArr);
        int loc1 = binarySearchAnyOrder(mountainArr, target, 0, mid);
        if (loc1 == -1) {
            return binarySearchAnyOrder(mountainArr, target, mid + 1, mountainArr.length() - 1);
        }
        return loc1;
    }
}
