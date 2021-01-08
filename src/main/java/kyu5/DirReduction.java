package kyu5;

// Directions Reduction

// … a man was given directions to go from one point to another.
// The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.
// Going to one direction and coming back the opposite direction right away is a needless effort.
// Since this is the wild west, with dreadfull weather and not much water,
// it's important to save yourself some energy, otherwise you might die of thirst!
// How I crossed a mountainous desert the smart way.
// Write a function dirReduc which will take an array of strings and returns an array of strings
// with the needless directions removed (W<->E or S<->N side by side).

import java.util.Arrays;
import java.util.Objects;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        boolean isReducted = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (direction.valueOf(arr[i]) == direction.opposite(direction.valueOf(arr[i + 1]))) {
                arr[i] = null;
                arr[i + 1] = null;
                i++;
                isReducted = true;
            }
        }
        arr = Arrays.stream(arr).filter(Objects::nonNull).toArray(String[]::new);
        return isReducted ? dirReduc(arr) : arr;
    }

    enum direction {
        NORTH,
        SOUTH,
        WEST,
        EAST;

        public static direction opposite(direction direction) {
            switch (direction) {
                case NORTH:
                    return SOUTH;
                case SOUTH:
                    return NORTH;
                case WEST:
                    return EAST;
                case EAST:
                    return WEST;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
        System.out.println(Arrays.toString(DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"})));
    }
}
