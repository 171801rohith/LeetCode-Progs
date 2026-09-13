// 835. Image Overlap
// You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix has only 0s and 1s as values.
// We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units. We then place it on top of the other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.
// Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.
// Return the largest possible overlap.

// Example 1:
// Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
// Output: 3
// Explanation: We translate img1 to right by 1 unit and down by 1 unit.
// The number of positions that have a 1 in both images is 3 (shown in red).

// Example 2:
// Input: img1 = [[1]], img2 = [[1]]
// Output: 1

// Example 3:
// Input: img1 = [[0]], img2 = [[0]]
// Output: 0
 

public class ImageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        for (int dr = -(n - 1); dr <= (n - 1); dr++){
            for (int dc = -(n - 1); dc <= (n - 1); dc++) {
                int overlap = 0;

                for (int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++){
                        int i2 = i - dr;
                        int j2 = j - dc;

                        if (i2 >= 0 && i2 < n && j2 >= 0 && j2 < n) 
                            if (img1[i][j] == 1 && img2[i2][j2] == 1) overlap++;
                    }
                }
                maxOverlap = Math.max(overlap, maxOverlap);
            }
        }
        return maxOverlap;
    }
}
