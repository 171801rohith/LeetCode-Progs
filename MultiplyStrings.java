// 43. Multiply Strings
// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

// Example 1:
// Input: num1 = "2", num2 = "3"
// Output: "6"

// Example 2:
// Input: num1 = "123", num2 = "456"
// Output: "56088"
 

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] arr = new int[m + n];

        for (int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = i + j + 1;

                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + arr[p2];

                arr[p2] = sum % 10;
                arr[p1] += sum / 10; 
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i: arr) 
            if (!(sb.length() == 0 && i == 0)) 
                sb.append(i);

        return sb.toString();
    }
}
