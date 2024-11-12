public class MainSolution {
    public static void main(String[] args) {
        // 1
        // Two_Sum sum = new Two_Sum();
        // int[] nums = { 2, 5, 5, 4 };
        // int target = 9;
        // int[] result = sum.twoSum(nums, target);
        // for (int i = 0; i < result.length; i++) {
        // System.out.print(result[i] + " ");
        // }

        // 2
        // Palindrome_Num palindrome = new Palindrome_Num();
        // // int x = 121;
        // int x = -121;
        // if (palindrome.isPalindrome(x)) {
        // System.out.println("Yes, It's a Palindrome");
        // } else{
        // System.out.println("No, It's not a Palindrome");
        // }

        // 3
        // RomanToNum roman = new RomanToNum();
        // // String s = "III";
        // // String s = "MDCXCV";
        // String s = "D";
        // System.out.println(roman.romanToInt(s));

        // 4
        // LongestPrefix prefix = new LongestPrefix();
        // String[] strs = { "flower", "flow", "flight" };
        // // String[] strs = {"flower","flow","flight", "abd"};
        // // String[] strs = {"ab", "a"};
        // // String[] strs = {"a"};
        // System.out.println("Longest Prefix = " + prefix.longestCommonPrefix(strs));

        // 5
        // ValidParenthesis vParenthesis = new ValidParenthesis();
        // // String s = "()[]{}";
        // // String s = "()";
        // // String s = "(]";
        // // String s = "([])";
        // // String s = "((";
        // String s = "([([]]])";
        // System.out.println("IsValid = " + vParenthesis.isValid(s));

        // 6
        RemoveDuplicates removeDups = new RemoveDuplicates();
        int[] nums = { 0,0,1,1,1,2,2,3,3,4};
        removeDups.removeDuplicates(nums);
    }
}
