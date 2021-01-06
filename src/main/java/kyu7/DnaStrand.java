package kyu7;

// Complementary DNA

// Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.
// If you want to know more http://en.wikipedia.org/wiki/DNA
// In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G".
// You have function with one side of the DNA (string, except for Haskell);
// you need to get the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).

public class DnaStrand {

    public static String makeComplement(String dna) {
        return dna.chars().map(c -> complement((char) c)).collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public static char complement(char character) {
        switch (character) {
            case 'A':
                return 'T';
            case 'T':
                return 'A';
            case 'C':
                return 'G';
            case 'G':
                return 'C';
            default:
                return character;
        }
    }

    public static void main(String[] args) {
        System.out.println(DnaStrand.makeComplement("AAAA"));
        System.out.println(DnaStrand.makeComplement("ATTGC"));
        System.out.println(DnaStrand.makeComplement("GTAT"));
    }
}
