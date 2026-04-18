// 2418. Sort the People
// You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
// For each index i, names[i] and heights[i] denote the name and height of the ith person.
// Return names sorted in descending order by the people's heights.

// Example 1:
// Input: names = ["Mary","John","Emma"], heights = [180,165,170]
// Output: ["Mary","Emma","John"]
// Explanation: Mary is the tallest, followed by Emma and John.

// Example 2:
// Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
// Output: ["Bob","Alice","Bob"]
// Explanation: The first Bob is the tallest, followed by Alice and the second Bob.

public class SortPersons {
    public String[] sortPeople(String[] names, int[] heights) {
        for (int i = 0; i < names.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < names.length; j++) {
                if (heights[j] > heights[max]) max = j;
            }

            if (max != i) {
                String temp = names[max];
                names[max] = names[i];
                names[i] = temp;

                int temp1 = heights[max];
                heights[max] = heights[i];
                heights[i] = temp1;
            }
        }
        return names;
    }
}
