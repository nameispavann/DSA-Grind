package binarysearch.onanswers;

import static binarysearch.onanswers.SmallestDivisor.calculateSum;
import static binarysearch.onanswers.SmallestDivisor.findMax;

/**
 * The {@code KokoEatingBananas} class solves the well-known problem of determining the minimum eating rate
 * (bananas per hour) required for Koko to finish all banana piles within a given number of hours.
 * <p>
 * This is a classic application of the "binary search on answers" technique where the goal is to minimize
 * the maximum rate (optimization). Given an array representing the number of bananas in each pile and a
 * total time limit (in hours), the program computes the minimum integer rate at which Koko can eat such
 * that all piles are consumed within the time limit.
 * <p>
 * The search space lies between 1 and the size of the largest pile, and binary search is applied over
 * this range. For a given mid-point (rate), a helper method determines whether Koko can finish all bananas
 * within the limit. The algorithm recursively narrows the search range to find the optimal rate.
 * <p>
 * In this problem we try to <b>minimize the maximum</b>
 *
 * <p><b>Example Use Case:</b></p>
 * <pre>{@code
 * int[] piles = {1, 2, 3, 4, 5};
 * int timeLimit = 8;
 *
 * int result = minimumRateToEatBananas(piles, timeLimit, 1, findMax(piles));
 * System.out.println(result); // Outputs the minimum eating rate per hour
 * }</pre>
 *
 * @author Sai Pavan
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        int low = 1;
        int limit = 8;
        int[] input = new int[]{1, 2, 3, 4, 5};
        int high = findMax(input);
        System.out.println(minimumRateToEatBananas(input, limit, low, high));
    }

    private static int minimumRateToEatBananas(int[] input, int limit, int low, int high) {
        if(low > high) return low;

        int mid = low + (high - low)/2;

        int totalBananasEaten = calculateSum(input, mid);
        if(totalBananasEaten <= limit) return minimumRateToEatBananas(input, limit, low, mid - 1);
        else return minimumRateToEatBananas(input, limit, mid + 1, high);
    }
}
