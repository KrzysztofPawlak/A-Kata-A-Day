package kyu6;

// CamelCase Method

// Write simple .camelCase method (camel_case function in PHP, CamelCase in C# or camelCase in Java) for strings.
// All words must have their first letter capitalized without spaces.

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static String camelCase(String str) {
        return Stream.of(str.split(" ")).filter(s -> !s.isBlank())
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(Solution.camelCase("test case"));
        System.out.println(Solution.camelCase("camel case method"));
        System.out.println(Solution.camelCase(" camel case word"));
        System.out.println(Solution.camelCase("say hello "));
        System.out.println(Solution.camelCase("z"));
        System.out.println(Solution.camelCase("ab  c"));
        System.out.println(Solution.camelCase(""));
    }
}
