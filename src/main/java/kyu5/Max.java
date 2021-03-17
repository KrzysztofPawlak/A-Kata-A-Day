package kyu5;

// Maximum subarray sum

// The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:

// Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
// should be 6: {4, -1, 2, 1}

import java.util.Arrays;
import java.util.stream.IntStream;

// Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
// If the list is made up of only negative numbers, return 0 instead.
// Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
public class Max {

    public static int sequence(int[] arr) {
        int max = 0;
        for (int length = 1; length <= arr.length; length++) {
            int start = 0;
            int end = length;
            int maxTimes = arr.length - length + 1;
            for (int times = 1; times <= maxTimes; times++) {
                int[] subarray = Arrays.copyOfRange(arr, start, end);
                int sum = IntStream.of(subarray).sum();
                if (sum > max) {
                    max = sum;
                }
                start++;
                end++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Max.sequence(new int[]{}));
        System.out.println(Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(Max.sequence(new int[]{7, 4, 11, -11, 39, 36, 10, -6, 37, -10, -32, 44, -26, -34, 43, 43}));
    }
}
