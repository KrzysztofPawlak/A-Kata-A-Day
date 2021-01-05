// Vowel Count
// 7 kyu

// Return the number (count) of vowels in the given string.
// We will consider a, e, i, o, u as vowels for this Kata (but not y).
// The input string will only consist of lower case letters and/or spaces.

public class Vowels {

    public static int getCount(String str) {
        int vowelsCount = 0;
        vowelsCount = (int) str.chars().mapToObj(c -> (char) c).filter(Vowels::isVowel).count();
        return vowelsCount;
    }

    public static boolean isVowel(char character) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vowels.length; i++) {
            if (character == vowels[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Vowels.getCount("abracadabra"));
    }
}
