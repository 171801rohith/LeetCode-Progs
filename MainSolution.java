// import java.util.*;

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
        // RemoveDuplicates removeDups = new RemoveDuplicates();
        // int[] nums = { 0,0,1,1,1,2,2,3,3,4};
        // removeDups.removeDuplicates(nums);

        // 7
        // RemoveElement removeElements = new RemoveElement();
        // int[] nums = { 3,2,2,3 };
        // int val = 3;
        // removeElements.removeElement(nums, val);

        // 8
        // FirstOccurance firstOccurance = new FirstOccurance();
        // String haystack = "leetcode";
        // String needle = "leeto";
        // System.out.println("Index : " + firstOccurance.strStr(haystack, needle));

        // 9
        // InsertPosition insertPosition = new InsertPosition();
        // int nums[] = { 1}, target = 1;
        // System.out.println("Index : " + insertPosition.searchInsert(nums, target));

        // 10
        // LengthOfWord lengthOfWord = new LengthOfWord();
        // String s = " fly me to the moon ";
        // System.out.println("Length of the last word = " +
        // lengthOfWord.lengthOfLastWord(s));

        // 11
        // PlusOne plusOne = new PlusOne();
        // int[] digits = { 7, 9, 9 };
        // int[] result = plusOne.plusOne(digits);
        // for (int i = 0; i < result.length; i++) {
        // System.out.print(result[i] + " ");
        // }

        // 12
        // AddBinary addbinary = new AddBinary();
        // String b1 = "0";
        // String b2 = "0";
        // System.out.println("Result = " + addbinary.addBinary(b1, b2));

        // 13
        // ValidPalindrome valid = new ValidPalindrome();
        // String s = "A man, a plan, a canal: Panama";
        // System.out.println("is Palindrome : " + valid.isPalindrome(s));

        // 14
        // SingleNumber single = new SingleNumber();
        // int[] nums = { 2, 2, 1 };
        // System.out.println("Single Number : " + single.singleNumber(nums));

        // 15
        // MergeSortedArray sort = new MergeSortedArray();
        // int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        // int[] nums2 = { 2, 5, 6 };
        // int m = 3;
        // int n = 3;
        // sort.merge(nums1, m, nums2, n);
        // System.out.println(Arrays.toString(nums1));

        // 16
        // StockBuySell stock = new StockBuySell();
        // int[] prices = { 7, 1, 5, 3, 6, 4 };
        // System.out.println("Profit = " + stock.maxProfit(prices));

        // 17
        // ContainsDuplicate dup = new ContainsDuplicate();
        // int[] a = { 1, 2, 4, 1, 6 };
        // System.out.println("ContainsDuplicate = " + dup.containsDuplicate(a));

        // 18
        // SortedAndRotated sort = new SortedAndRotated();
        // int[] nums = { 3, 4, 5, 1, 2 };
        // System.out.println("Result = " + sort.check(nums));

        // 19
        // StringToNums s = new StringToNums();
        // String str = "iiii";
        // int k = 2;
        // System.out.println("Result = " + s.getLucky(str, k));

        // 20
        // SameTree same = new SameTree();
        // // check 100th leetcode easy problem

        // 21
        // InorderTraversal inorder = new InorderTraversal();
        // // check 94th leetcode easy problem

        // 22
        // PreorderTraversal preorder = new PreorderTraversal();
        // // check 144th leetcode easy problem

        // 23
        // PostorderTraversal postorder = new PostorderTraversal();
        // // check 145th leetcode easy problem

        // 24
        // AddDigits add = new AddDigits();
        // System.out.println(add.addDigits(34));

        // 25
        // BinarySearch search = new BinarySearch();
        // int[] nums = { -1, 0, 3, 5, 9, 12 };
        // System.out.println(search.search(nums, 9));

        // 26
        HappyNumber num = new HappyNumber();
        System.out.println(num.isHappy(19));


    }
}
