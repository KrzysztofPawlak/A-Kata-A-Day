package kyu4;

// Pyramid Slide Down

// Lyrics...
// Pyramids are amazing! Both in architectural and mathematical sense. If you have a computer,
// you can mess with pyramids even if you are not in Egypt at the time. For example, let's consider the following problem.
// Imagine that you have a pyramid built of numbers, like this one here:
//    /3/
//   \7\ 4
//  2 \4\ 6
// 8 5 \9\ 3
// Here comes the task...
// Let's say that the 'slide down' is the maximum sum of consecutive numbers from the top to the bottom of the pyramid.
// As you can see, the longest 'slide down' is 3 + 7 + 4 + 9 = 23
// Your task is to write a function longestSlideDown (in ruby/crystal/julia: longest_slide_down)
// that takes a pyramid representation as argument and returns its' largest 'slide down'. For example,
// longestSlideDown [[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]] => 23
// By the way...
// My tests include some extraordinarily high pyramids so as you can guess, brute-force method is a bad idea
// unless you have a few centuries to waste. You must come up with something more clever than that.

public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {
        for (int row = pyramid.length - 2; row >= 0; row--) {
            for (int column = 0; column < pyramid[row].length; column++) {
                int leftCandidate = pyramid[row][column] + pyramid[row + 1][column];
                int rightCandidate = pyramid[row][column] + pyramid[row + 1][column + 1];
                pyramid[row][column] = Math.max(leftCandidate, rightCandidate);
            }
        }
        return pyramid[0][0];
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{3},
                {7, 4},
                {2, 4, 6},
                {8, 5, 9, 3}
        };
        System.out.println(LongestSlideDown.longestSlideDown(test));
    }

}
