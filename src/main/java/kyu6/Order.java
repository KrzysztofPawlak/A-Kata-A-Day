package kyu6;

// Your order, please

// Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.
// Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
// If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Order {

    public static String order(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparingInt(c -> c.replaceAll("[^0-9]+", "").toCharArray()[0]))
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(Order.order("is2 Thi1s T4est 3a"));
        System.out.println(Order.order("4of Fo1r pe6ople g3ood th5e the2"));
        System.out.println(Order.order(""));
    }
}
