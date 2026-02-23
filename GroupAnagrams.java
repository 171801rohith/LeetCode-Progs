// 49. Group Anagrams
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Explanation:
// There is no string in strs that can be rearranged to form "bat".
// The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
// Example 2:
// Input: strs = [""]
// Output: [[""]]

// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        String s;
        char[] c;
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            c = str.toCharArray();
            Arrays.sort(c);
            s = new String(c);

            anagrams.computeIfAbsent(s, k -> new ArrayList<>()).add(str);

        }

        return new ArrayList<>(anagrams.values());
    }
}


// class Solution {
//     char[] a, b, c;
//     StringBuilder sb;
//     String s;
//     List<List<String>> result = new ArrayList<>();

//     public boolean isAnagram(String s, String t) {
//         a = s.toCharArray();
//         b = t.toCharArray();
//         Arrays.sort(a);
//         Arrays.sort(b);
//         return Arrays.equals(a, b);

//     }

//     public List<List<String>> groupAnagrams(String[] strs) {
//         HashMap<String, List<String>> anagrams = new HashMap<>();
//         for (String str : strs) {
//             c = str.toCharArray();
//             Arrays.sort(c);
//             sb = new StringBuilder(new String(c));
//             s = sb.toString();

//             if (anagrams.containsKey(s)) {
//                 List<String> list = anagrams.get(s);
//                 if (isAnagram(s, str))
//                     list.add(str);
//             } else {
//                 anagrams.putIfAbsent(s, new ArrayList<>());
//                 anagrams.get(s).add(str);
//             }

//         }
//         // for (Map.Entry<String, List<String>> entry : anagrams.entrySet())
//             // result.add(entry.getValue());
            
//         result.addAll(anagrams.values());

//         System.out.println(anagrams);
//         return result;
//     }
// }