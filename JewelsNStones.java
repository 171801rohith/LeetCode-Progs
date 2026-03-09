// 771. Jewels and Stones
// You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
// Letters are case sensitive, so "a" is considered a different type of stone from "A".

// Example 1:
// Input: jewels = "aA", stones = "aAAbbbb"
// Output: 3

// Example 2:
// Input: jewels = "z", stones = "ZZ"
// Output: 0

import java.util.HashSet;

public class JewelsNStones {
     public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewelSet = new HashSet<>();
        int count = 0;
        for (char jewel: jewels.toCharArray()) jewelSet.add(jewel);
        for (char stone: stones.toCharArray()) if(jewelSet.contains(stone)) count++;
        return count;
    }
}
