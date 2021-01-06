package kyu_7;

// Exes and Ohs

// Check to see if a string has the same amount of 'x's and 'o's.
// The method must return a boolean and be case insensitive.
// The string can contain any char.

public class XO {
    public static boolean getXO (String str) {
        long xOccurences = str.toLowerCase().chars().filter(ch -> ch == 'x').count();
        long oOccurences = str.toLowerCase().chars().filter(ch -> ch == 'o').count();
        return xOccurences == oOccurences;
    }

    public static void main(String[] args) {
        System.out.println(XO.getXO("xxxooo"));
        System.out.println(XO.getXO("xxxXooOo"));
        System.out.println(XO.getXO("xxx23424esdsfvxXXOOooo"));
        System.out.println(XO.getXO("xXxxoewrcoOoo"));
        System.out.println(XO.getXO("XxxxooO"));
        System.out.println(XO.getXO("zssddd"));
        System.out.println(XO.getXO("Xxxxertr34"));
    }
}
