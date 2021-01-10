package kyu6;

// Persistent Bugger.

// Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
// which is the number of times you must multiply the digits in num until you reach a single digit.

import java.util.stream.IntStream;

public class Persist {

    public static int persistence(long n) {
        if (n < 10) {
            return 0;
        }
        int multiplicationResult = Long.toString(n).chars().map(Character::getNumericValue).reduce(1, (a, b) -> a * b);
        return (multiplicationResult > 9) ? persistence(multiplicationResult) + 1 : 1;
    }

    public static void main(String[] args) {
        System.out.println(Persist.persistence(39));
        System.out.println(Persist.persistence(4));
        System.out.println(Persist.persistence(25));
        System.out.println(Persist.persistence(999));
    }
}
