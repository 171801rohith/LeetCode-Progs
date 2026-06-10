// 3945. Digit Frequency Score
// You are given an integer n.
// The score of n is defined as the sum of d * freq(d) over all distinct digits d, where freq(d) denotes the number of times the digit d appears in n.
// Return an integer denoting the score of n.

// Example 1:
// Input: n = 122
// Output: 5
// Explanation:
// The digit 1 appears 1 time, contributing 1 * 1 = 1.
// The digit 2 appears 2 times, contributing 2 * 2 = 4.
// Thus, the score of n is 1 + 4 = 5.

// Example 2:
// Input: n = 101
// Output: 2
// Explanation:
// The digit 0 appears 1 time, contributing 0 * 1 = 0.
// The digit 1 appears 2 times, contributing 1 * 2 = 2.
// Thus, the score of n is 2.

import java.util.HashMap;
import java.util.Map;

public class DigitFreqScore {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];
        int digit;
        while (n > 0) {
            digit = n % 10;
            freq[digit]++;
            n /= 10;
        }

        int sum = 0;
        for (int i = 0; i < freq.length; i++) sum += (i * freq[i]); 
        return sum;
    }

    public int digitFrequencyScoreLazy(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int digit;
        while (n > 0) {
            digit = n % 10;
            map.put(digit, map.getOrDefault(digit, 0) + 1);
            n /= 10;
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) sum += (entry.getKey() * entry.getValue());
        
        return sum;
    }
}