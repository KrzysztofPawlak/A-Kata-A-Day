package kyu6;

import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

// Find the odd int

// Given an array of integers, find the one that appears an odd number of times.
// There will always be only one integer that appears an odd number of times.

public class FindOdd {

    public static int findIt(int[] a) {

        return IntStream.range(0, a.length)
                .boxed()
                .collect(groupingBy(i -> a[i], counting()))
                .entrySet()
                .stream()
                .filter(key -> key.getValue() % 2 == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(FindOdd.findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        System.out.println(FindOdd.findIt(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
        System.out.println(FindOdd.findIt(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
        System.out.println(FindOdd.findIt(new int[]{10}));
        System.out.println(FindOdd.findIt(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
        System.out.println(FindOdd.findIt(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    }
}
