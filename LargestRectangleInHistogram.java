// 84. Largest Rectangle in Histogram
// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Example 1:
// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.

// Example 2:
// Input: heights = [2,4]
// Output: 4
 

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            while (!st.empty() && heights[st.peek()] > heights[i]) {
                int h = heights[st.pop()];
                int left = st.empty() ? -1 : st.peek();
                int right = i;
                int w = right - left - 1;

                maxArea = Math.max(maxArea, h * w);
            }
            st.push(i);
        }

        while (!st.empty()) {
            int h = heights[st.pop()];
            int left = st.empty() ? -1 : st.peek();
            int right = heights.length;
            int w = right - left - 1;
            maxArea = Math.max(maxArea, h * w);
        }

        return maxArea;   
    }
}
