package binarysearch.faqs;

import java.util.Arrays;


/**
 * The {@code AggressiveCows} class solves a classic binary search on answers problem: placing cows
 * in stalls such that the minimum distance between any two cows is maximized.
 * <p>
 * Given the positions of stalls on a number line and a number of cows to place, the goal is to
 * place the cows in the stalls such that the smallest distance between any two cows is as large as possible.
 * This is achieved by performing a binary search over the range of possible distances (from 1 to
 * the maximum stall gap), and checking at each step if a given minimum distance is feasible.
 * <p>
 * This problem demonstrates how to apply binary search not on the array itself, but on the range of
 * possible answers — a technique commonly known as "binary search on answers."
 * <p>
 * In this problem we try to <b>maximize the minimum</b>
 *
 * <p><b>Example Use Case:</b></p>
 * <pre>{@code
 * int[] stallPositions = {0, 3, 4, 7, 10, 9};
 * int cows = 4;
 *
 * Arrays.sort(stallPositions); // Ensure the stall positions are sorted
 * int low = 1; // Low in binary search on answers always starts from 1. because in this problem, distance between cows cannot be zero
 * int high = stallPositions[stallPositions.length - 1] - stallPositions[0]; // high is nothing but max possible distance i.e.., last element - first element is the max possible distance between to cows. this is done to reduce the search range
 *
 * int result = findMaxPossibleMinDistance(stallPositions, cows, low, high);
 * System.out.println(result); // Outputs the maximum possible minimum distance
 * }</pre>
 *
 * @author Sai Pavan
 */
public class AggressiveCows {
    public static void main(String[] args) {
        int cows = 4;
        int[] stallPositions = new int[]{0, 3, 4, 7, 10, 9};
        Arrays.sort(stallPositions);
        int low = 1;
        int high = stallPositions[stallPositions.length - 1] - stallPositions[0];

        int result = findMaxPossibleMinDistance(stallPositions, cows, low, high);

        System.out.println(result);

    }

    private static int findMaxPossibleMinDistance(int[] stallPositions, int cows, int low, int high) {

        if(low > high) return high;

        int mid = low + (high - low)/2;

        if(isValidDistance(stallPositions, mid, cows)) {
            return findMaxPossibleMinDistance(stallPositions, cows, mid + 1, high);
        } else {
            return findMaxPossibleMinDistance(stallPositions, cows, low, mid - 1);
        }
    }

    private static boolean isValidDistance(int[] stallPositions, int mid, int cows) {
        int prevPosition = 0;
        cows -= 1;

        for(int currentPosition  = 1; currentPosition < stallPositions.length; currentPosition++){
            if(stallPositions[currentPosition] - stallPositions[prevPosition] >= mid) {
                prevPosition = currentPosition;
                cows--;
            }
            if(cows == 0) return true;
        }

        return false;
    }
}
