package kyu6;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static long[] generate(int numRows) {
        List<Long> result = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    result.add(1L);
                } else {
                    result.add(sumPreviousRowNeighbours(result, row));
                }
            }
        }
        return result.stream()
                .mapToLong(l -> l).toArray();
    }

    static long sumPreviousRowNeighbours(List<Long> result, int row) {
        int indexPreviousRowLeft = result.size() - row - 1;
        int indexPreviousRowRight = result.size() - row;
        return result.get(indexPreviousRowLeft) + result.get(indexPreviousRowRight);
    }
}