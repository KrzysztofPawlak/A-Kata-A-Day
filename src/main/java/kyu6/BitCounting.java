package kyu6;

// Bit Counting

// Write a function that takes an integer as input,
// and returns the number of bits that are equal to one in the binary representation of that number.
// You can guarantee that input is non-negative.
// Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case

public class BitCounting {

    public static int countBits(int n){
        return (int) Integer.toBinaryString(n).chars()
                .filter(ch -> ch == '1')
                .count();
    }

    public static void main(String[] args) {
        System.out.println(BitCounting.countBits(1234));
        System.out.println(BitCounting.countBits(4));
        System.out.println(BitCounting.countBits(7));
        System.out.println(BitCounting.countBits(9));
        System.out.println(BitCounting.countBits(10));
    }
}
