package kyu6;

import java.util.Map;
import java.util.Stack;

// Valid Braces

// Write a function that takes a string of braces, and determines if the order of the braces is valid.
// It should return true if the string is valid, and false if it's invalid.
// All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
// What is considered Valid?
// A string of braces is considered valid if all braces are matched with the correct brace.

public class BraceChecker {

    public boolean isValid(String braces) {
        Map<Character, Character> startEndBracers = Map.of(
                '(', ')',
                '{', '}',
                '[', ']');
        var stack = new Stack<Character>();
        for (var currentChar : braces.toCharArray()) {
            if (startEndBracers.containsKey(currentChar)) {
                stack.push(currentChar);
            }
            if (startEndBracers.containsValue(currentChar)) {
                if (stack.isEmpty()) {
                    return false;
                }
                var poppedChar = stack.pop();
                var closedCharToPopped = startEndBracers.get(poppedChar);
                if (currentChar != closedCharToPopped) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        BraceChecker checker = new BraceChecker();
        System.out.println(checker.isValid("()"));
        System.out.println(checker.isValid("[(])"));
        System.out.println(checker.isValid("(){}[]")); // True
        System.out.println(checker.isValid("([{}])")); // True
        System.out.println(checker.isValid("(}")); // False
        System.out.println(checker.isValid("[(])")); // False
        System.out.println(checker.isValid("[({})](]")); // False
    }
}
