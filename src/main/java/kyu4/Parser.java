package kyu4;

import java.util.Map;
import java.util.Stack;

// parseInt() reloaded

// In this kata we want to convert a string into an integer. The strings simply represent the numbers in words.
// Examples:
// "one" => 1
// "twenty" => 20
// "two hundred forty-six" => 246
// "seven hundred eighty-three thousand nine hundred and nineteen" => 783919
// Additional Notes:
// The minimum number is "zero" (inclusively)
// The maximum number, which must be supported is 1 million (inclusively)
// The "and" in e.g. "one hundred and twenty-four" is optional, in some cases it's present and in others it's not
// All tested numbers are valid, you don't need to validate them

public class Parser {

    static Map<String, Integer> keywords = Map.ofEntries(
            Map.entry("one", 1), Map.entry("two", 2), Map.entry("three", 3),
            Map.entry("four", 4), Map.entry("five", 5), Map.entry("six", 6),
            Map.entry("seven", 7), Map.entry("eight", 8), Map.entry("nine", 9),
            Map.entry("eleven", 11), Map.entry("twelve", 12), Map.entry("thirteen", 13),
            Map.entry("fourteen", 14), Map.entry("fifteen", 15), Map.entry("sixteen", 16),
            Map.entry("seventeen", 17), Map.entry("eighteen", 18), Map.entry("nineteen", 19),
            Map.entry("ten", 10), Map.entry("twenty", 20), Map.entry("thirty", 30),
            Map.entry("forty", 40), Map.entry("fifty", 50), Map.entry("sixty", 60),
            Map.entry("seventy", 70), Map.entry("eighty", 80), Map.entry("ninety", 90),
            Map.entry("hundred", 100), Map.entry("thousand", 1000), Map.entry("million", 1000000),
            Map.entry("zero", 0), Map.entry("and", 0));

    public static int parseInt(String numStr) {
        var stack = new Stack<Integer>();
        String[] strings = numStr.split(" ");
        for (String string : strings) {
            var tmpResult = 0;
            if (string.contains("-")) {
                String[] dashSeparatedStrings = string.split("-");
                for (String tmpString : dashSeparatedStrings) {
                    tmpResult += keywords.get(tmpString);
                }
            } else if (string.equals("hundred") || (string.equals("thousand"))) {
                while (!stack.isEmpty()) {
                    if (string.equals("hundred") && stack.peek() > 999) {
                        break;
                    }
                    tmpResult += stack.pop();
                }
                tmpResult = tmpResult * keywords.get(string);
            } else if (string.equals("million")) {
                stack.pop();
                tmpResult = keywords.get(string);
            } else {
                tmpResult = keywords.get(string);
            }
            if (tmpResult > 0) {
                stack.push(tmpResult);
            }
        }
        return stack.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println(Parser.parseInt("zero"));
        System.out.println(Parser.parseInt("one"));
        System.out.println(Parser.parseInt("twenty"));
        System.out.println(Parser.parseInt("two hundred forty-six"));
        System.out.println(Parser.parseInt("five hundred ninety-nine thousand seven hundred fifty-nine"));
        System.out.println(Parser.parseInt("six hundred sixty-six thousand six hundred sixty-six"));
        System.out.println(Parser.parseInt("one million"));
    }

}
