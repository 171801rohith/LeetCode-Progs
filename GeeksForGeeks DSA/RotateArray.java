// Rotate Array
// Given an array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.
// Note: Consider the array as circular.
// Examples :

// Input: arr[] = [1, 2, 3, 4, 5], d = 2
// Output: [3, 4, 5, 1, 2]
// Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.

// Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
// Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
// Explanation: when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.

// Input: arr[] = [7, 3, 9, 1], d = 9
// Output: [3, 9, 1, 7]
// Explanation: when we rotate 9 times, we'll get 3 9 1 7 as resultant array.

public class RotateArray {
    void reverseArr(int arr[], int start, int end) {
        int i = start, j = end;
        int temp;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        RotateArray rotate = new RotateArray();
        d = d % arr.length;
        rotate.reverseArr(arr, 0, d - 1);
        rotate.reverseArr(arr, d, arr.length - 1);
        rotate.reverseArr(arr, 0, arr.length - 1);
    }
}

// NOTES : Algorithm to Rotate an Array

// Input:
// Array arr of size n
// Number of positions to rotate, k

// Adjust k:
// If k > n, set k = k % n (to handle rotations greater than the array size).

// Steps to Rotate (Clockwise):
// 1. Reverse the entire array.
// 2. Reverse the first k elements.
// 3. Reverse the remaining n-k elements.

// Steps to Rotate (Counter-Clockwise):
// 1. Reverse the first k elements.
// 2. Reverse the remaining n-k elements.
// 3. Reverse the entire array.