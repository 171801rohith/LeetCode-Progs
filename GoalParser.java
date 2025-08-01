// 1678. Goal Parser Interpretation
// You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.
// Given the string command, return the Goal Parser's interpretation of command.

// Example 1:
// Input: command = "G()(al)"
// Output: "Goal"
// Explanation: The Goal Parser interprets the command as follows:
// G -> G
// () -> o
// (al) -> al
// The final concatenated result is "Goal".

// Example 2:
// Input: command = "G()()()()(al)"
// Output: "Gooooal"

// Example 3:
// Input: command = "(al)G(al)()()G"
// Output: "alGalooG"

public class GoalParser {
    // public String interpret(String command) {
    // return command.replace("()", "o").replace("(al)", "al");
    // }

    public String interpret(String command) {
        StringBuilder goal = new StringBuilder(command);
        while (goal.indexOf("(") >= 0 && goal.indexOf(")") >= 0) {
            int open = goal.indexOf("(");
            int close = goal.indexOf(")");
            if (open + 1 == close) {
                goal.replace(open, close + 1, "o");
            } else {
                goal.replace(open, close + 1, "al");
            }
        }
        return goal.toString();
    }
}
