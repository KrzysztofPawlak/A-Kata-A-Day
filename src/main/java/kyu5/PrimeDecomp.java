package kyu5;

// Primes in numbers

// Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :
// "(p1**n1)(p2**n2)...(pk**nk)"
// where a ** b means a to the power of b
// with the p(i) in increasing order and n(i) empty if n(i) is 1.
// Example: n = 86240 should return "(2**5)(5)(7**2)(11)"

public class PrimeDecomp {

    public static String factors(int n) {
        double value = n;
        int divider = 2;
        int power = 0;
        String numbers = "";
        while (value / divider != 1) {
            if (value / divider % 1 == 0) { // no decimal point
                value = value / divider;
                power++;
            } else {
                if (power > 0) {
                    numbers += "(" + (power > 1 ? divider + "**" + power : divider) + ")";
                }
                power = 0;
                divider++;
            }
        }
        numbers += "(" + divider + ")";
        return numbers;
    }

    public static void main(String[] args) {
        System.out.println(PrimeDecomp.factors(7775460)); // (2**2)(3**3)(5)(7)(11**2)(17)
    }
}
