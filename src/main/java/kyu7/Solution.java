package kyu7;

// Regex validate PIN code

// ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.
// If the function is passed a valid PIN string, return true, else return false.

public class Solution {

    public static boolean validatePin(String pin) {
        return pin.matches("\\d{4}|\\d{6}");
    }

    public static void main(String[] args) {
        System.out.println(Solution.validatePin("1234"));
        System.out.println(Solution.validatePin("0000"));
        System.out.println(Solution.validatePin("1111"));
        System.out.println(Solution.validatePin("123456"));
        System.out.println(Solution.validatePin("098765"));
        System.out.println(Solution.validatePin("000000"));
        System.out.println(Solution.validatePin("000000"));
        System.out.println(Solution.validatePin("090909"));
        System.out.println();
        System.out.println(Solution.validatePin("a234"));
        System.out.println(Solution.validatePin(".234"));
        System.out.println();
        System.out.println(Solution.validatePin("1"));
        System.out.println(Solution.validatePin("12"));
        System.out.println(Solution.validatePin("123"));
        System.out.println(Solution.validatePin("12345"));
        System.out.println(Solution.validatePin("1234567"));
        System.out.println(Solution.validatePin("-1234"));
        System.out.println(Solution.validatePin("1.234"));
        System.out.println(Solution.validatePin("00000000"));
        System.out.println();
        System.out.println(Solution.validatePin("1234.0"));
    }
}
