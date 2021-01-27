package kyu5;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Common Denominators

// You will have a list of rationals in the form
// { {numer_1, denom_1} , ... {numer_n, denom_n} }  or
// [ [numer_1, denom_1] , ... [numer_n, denom_n] ] or
// [ (numer_1, denom_1) , ... (numer_n, denom_n) ]
// where all numbers are positive ints. You have to produce a result in the form:
// (N_1, D) ... (N_n, D) or
// [ [N_1, D] ... [N_n, D] ] or
// [ (N_1', D) , ... (N_n, D) ] or
// {{N_1, D} ... {N_n, D}} or
// "(N_1, D) ... (N_n, D)"
// in which D is as small as possible and
// N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.
// Example: convertFracs [(1, 2), (1, 3), (1, 4)] `shouldBe` [(6, 12), (4, 12), (3, 12)]
// Note: Due to the fact that the first translations were written long ago - more than 6 years - these first
// translations have only irreducible fractions.
// Newer translations have some reducible fractions. To be on the safe side it is better to do
// a bit more work by simplifying fractions even if they don't have to be.

public class Fracts {

    public static String convertFrac(long[][] lst) {
        if (lst.length == 0) {
            return "";
        }
        long[] denominators = Stream.of(lst)
                .map(Fracts::lowestFractionEuclidean)
                .mapToLong(e -> e[1])
                .toArray();
        long lcm = leastCommonMultiple(denominators);
        return Stream.of(lst)
                .peek(fraction -> {
                    fraction[0] = fraction[0] * lcm / fraction[1];
                    fraction[1] = lcm;
                })
                .map(fraction -> "(" + fraction[0] + "," + fraction[1] + ")")
                .collect(Collectors.joining(""));
    }

    public static long[] lowestFractionEuclidean(long[] value) {
        long rest;
        long bigger = Math.max(value[0], value[1]);
        long lower = Math.min(value[0], value[1]);
        while ((rest = bigger % lower) != 0) {
            bigger = lower;
            lower = rest;
        }
        return new long[]{Math.toIntExact(value[0] / lower), Math.toIntExact(value[1] / lower)};
    }

    public static long leastCommonMultiple(long[] values) {
        long[] copiedArray = Arrays.copyOf(values, values.length);
        int lowestIndex;
        boolean isEquals = false;
        while (!isEquals) {
            isEquals = true;
            lowestIndex = 0;
            for (int i = 1; i < values.length; i++) {
                if (values[i] != values[i - 1]) {
                    isEquals = false;
                }
                lowestIndex = values[i] < values[lowestIndex] ? i : lowestIndex;
            }
            if (!isEquals) {
                values[lowestIndex] = values[lowestIndex] + copiedArray[lowestIndex];
            }
        }
        return values[0];
    }

    public static void main(String[] args) {
        long[][] lst;
        lst = new long[][]{{1, 2}, {1, 3}, {10, 40}};
        System.out.println(Fracts.convertFrac(lst));
        lst = new long[][]{{69, 130}, {87, 1310}, {30, 40}}; // (18078,34060)(2262,34060)(25545,34060)
        System.out.println(Fracts.convertFrac(lst));
    }
}
