// Second Largest
// Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.
// Note: The second largest element should not be equal to the largest element.
// Examples:

// Input: arr[] = [12, 35, 1, 10, 34, 1]
// Output: 34
// Explanation: The largest element of the array is 35 and the second largest element is 34.

// Input: arr[] = [10, 5, 10]
// Output: 5
// Explanation: The largest element of the array is 10 and the second largest element is 5.

// Input: arr[] = [10, 10, 10]
// Output: -1
// Explanation: The largest element of the array is 10 and the second largest element does not exist.

public class SecondLargest {
    public int getSecondLargest(int[] arr) {
        int max = arr[0];
        int sec_max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max && arr[i] > sec_max) sec_max = arr[i];
        }
        return sec_max;
    }
}
