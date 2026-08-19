// 187. Repeated DNA Sequences
// The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
// For example, "ACGAATTCCG" is a DNA sequence.
// When studying DNA, it is useful to identify repeated sequences within the DNA.
// Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 
// Example 1:
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
// Output: ["AAAAACCCCC","CCCCCAAAAA"]

// Example 2:
// Input: s = "AAAAAAAAAAAAA"
// Output: ["AAAAAAAAAA"]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String DNA = s.substring(i, i + 10);
            
            if (!seen.add(DNA)) repeated.add(DNA);
        }
        return new ArrayList<>(repeated);
    }

    public List<String> findRepeatedDnaSequencesLazy(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> dna = new HashMap<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String DNA = s.substring(i, i + 10);
            dna.put(DNA, dna.getOrDefault(DNA, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry: dna.entrySet())
            if (entry.getValue() > 1) list.add(entry.getKey());

        return list;
    }
    
}