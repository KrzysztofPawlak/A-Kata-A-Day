package kyu7;

// Growth of a Population

// In a small town the population is p0 = 1000 at the beginning of a year.
// The population regularly increases by 2 percent per year and moreover 50 new inhabitants per year come to live in the town.
// How many years does the town need to see its population greater or equal to p = 1200 inhabitants?

public class Arge {

    public static int nbYear(int p0, double percent, int aug, int p) {
        int year = 0;
        int amount = p0;
        while(amount < p) {
            amount = (int) (amount + amount * percent / 100 + aug);
            year++;
        }
        return year;
    }

    public static void main(String[] args) {
        System.out.println(Arge.nbYear(1000, 2, 50, 1200));
        System.out.println(Arge.nbYear(1500, 5, 100, 5000));
        System.out.println(Arge.nbYear(1500000, 2.5, 10000, 2000000));
        System.out.println(Arge.nbYear(1500000, 0.25, 1000, 2000000));
    }
}
