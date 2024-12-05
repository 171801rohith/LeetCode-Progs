// Add Binary
// Given two binary strings a and b, return their sum as a binary string.
// Example 1:
// Input: a = "11", b = "1"
// Output: "100"

// Example 2:
// Input: a = "1010", b = "1011"
// Output: "10101"

// Constraints:
// 1 <= a.length, b.length <= 104
// a and b consist only of '0' or '1' characters.
// Each string does not contain leading zeros except for the zero itself

public class AddBinary {
    public String addBinary(String a, String b) {
        String zero = "0";
        String one = "1";
        while (a.length() > b.length()) {
            b = zero + b;
        }
        while (a.length() < b.length()) {
            a = zero + a;
        }
        String result = "";
        String carry = "0";
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '1' && b.charAt(i) == '1' && carry == one) {
                result = one + result;
                carry = one;
            } else if ((a.charAt(i) == '1' && b.charAt(i) == '1' && carry == zero)
                    || (a.charAt(i) == '1' && b.charAt(i) == '0' && carry == one)
                    || (a.charAt(i) == '0' && b.charAt(i) == '1' && carry == one)) {
                result = zero + result;
                carry = one;
            } else if ((a.charAt(i) == '1' && b.charAt(i) == '0' && carry == zero)
                    || (a.charAt(i) == '0' && b.charAt(i) == '1' && carry == zero)
                    || (a.charAt(i) == '0' && b.charAt(i) == '0' && carry == one)) {
                result = one + result;
                carry = zero;
            } else if ((a.charAt(i) == '0' && b.charAt(i) == '0' || carry == zero)) {
                result = zero + result;
                carry = zero;
            }
        }
        if (carry.equals(one)) {
            result = one + result;
        }
        // System.out.println(a);
        // System.out.println(b);
        return result;
    }
}
