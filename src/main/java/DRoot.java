// Sum of Digits / Digital Root
// 6 kyu

// Given n, take the sum of the digits of n.
// If that value has more than one digit, continue reducing in this way until a single-digit number is produced.
// The input will be a non-negative integer.

public class DRoot {
    public static int digital_root(int n) {
        int digit = n;
        int sum = 0;
        while (digit > 0) {
            sum += digit % 10;
            digit = digit / 10;
        }

        if (sum / 10 > 0) {
            return digital_root(sum);
        } else {
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(DRoot.digital_root(456));
        System.out.println(DRoot.digital_root(16));
        System.out.println(DRoot.digital_root(493193));
    }
}
