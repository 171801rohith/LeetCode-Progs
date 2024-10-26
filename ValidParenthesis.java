// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.

// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "()[]{}"
// Output: true

// Example 3:
// Input: s = "(]"
// Output: false

// Example 4:
// Input: s = "([])"
// Output: true

import java.util.ArrayList;

public class ValidParenthesis {
    public int setValue(char ch) {
        switch (ch) {
            case '(':
                return 1;
            case ')':
                return 2;
            case '[':
                return 3;
            case ']':
                return 4;
            case '{':
                return 5;
            case '}':
                return 6;
            default:
                return -1;
        }
    }

    public boolean isValid(String s) {
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        boolean check = false;

        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            values.add(setValue(s.charAt(i)));
        }

        System.out.println(values);
        if (values.indexOf(2) < values.indexOf(1)
                || values.indexOf(4) < values.indexOf(3)
                || values.indexOf(6) < values.indexOf(5)
                || values.lastIndexOf(2) < values.lastIndexOf(1)
                || values.lastIndexOf(4) < values.lastIndexOf(3)
                || values.lastIndexOf(6) < values.lastIndexOf(5)) {
            return false;
        }

        if (values.size() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) == 1) {
                counter1++;
            } else if (values.get(i) == 2) {
                counter2++;
            } else if (values.get(i) == 3) {
                counter3++;
            } else if (values.get(i) == 4) {
                counter4++;
            } else if (values.get(i) == 5) {
                counter5++;
            } else if (values.get(i) == 6) {
                counter6++;
            }
        }

        if (counter1 == counter2 && counter3 == counter4 && counter5 == counter6) {
            check = true;
        }

        if (check) {

            if (values.size() == 4) {
                if (values.get(0) == values.get(2) - 1) {
                    if (values.get(1) != values.get(0)) {
                        check = false;
                    }
                }
            }

            if (values.size() == 6) {
                if (values.get(0) == values.get(3) - 1) {
                    if (values.get(1) != values.get(0)) {
                        if (values.get(2) != values.get(1) + 1) {
                            check = false;
                        }
                    }
                }
            }

            if (values.size() == 8) {
                if (values.get(0) == values.get(4) - 1) {
                    if (values.get(1) != values.get(0)) {
                        if (values.get(2) != values.get(1) + 1) {
                            if (values.get(3) != values.get(2) + 1) {
                                check = false;
                            }
                        }
                    }
                }
            }

        }

        return check;
    }
}
