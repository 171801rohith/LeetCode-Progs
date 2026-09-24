// 846. Hand of Straights
// Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
// Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

// Example 1:
// Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
// Output: true
// Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

// Example 2:
// Input: hand = [1,2,3,4,5], groupSize = 4
// Output: false
// Explanation: Alice's hand can not be rearranged into groups of 4.


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i: hand) freq.put(i, freq.getOrDefault(i, 0) + 1);

        List<Integer> list = new ArrayList<>(freq.keySet());
        Collections.sort(list);

        for (int x: list) {
            int need = freq.get(x);
            while (need-- != 0) {
                for (int i = 0; i < groupSize; i++) {
                    int card = x + i;
                    if (freq.getOrDefault(card, 0) == 0) return false;
                    freq.put(card, freq.get(card) - 1);
                }
            }
        }
        return true;
    }
}
