package binarysearch.onanswers;

import static binarysearch.onanswers.SmallestDivisor.findMax;

/**
 * The {@code MBouquetsInMinDays} class provides a solution to the classic binary search problem
 * of finding the minimum number of days required to make a given number of bouquets, where each
 * bouquet consists of a fixed number of adjacent flowers.
 * <p>
 * Given an array representing the bloom days of flowers in a garden, the goal is to determine
 * the earliest possible day on which it is feasible to collect the required number of bouquets
 * such that each bouquet is made of contiguous flowers that have all bloomed by that day.
 * <p>
 * This class applies binary search on the answer space (days) to efficiently determine the
 * minimum viable day. The approach is often referred to as "binary search on answers" and is
 * well-suited to optimization problems where a monotonic condition can be applied to shrink
 * the search range.
 * <p>
 * In this problem we try to <b>minimize the maximum</b>
 *
 * <p><b>Example Use Case:</b></p>
 * <pre>{@code
 * int[] bloomDays = {7, 7, 7, 7, 13, 11, 12, 7};
 * int m = 2;  // number of bouquets
 * int k = 3;  // flowers per bouquet
 * int limit = 8;  // number of flowers available
 *
 * int result = findMinDaysToMakeMBouquets(bloomDays, limit, m, k, findMin(bloomDays), findMax(bloomDays));
 * System.out.println(result); // Outputs the minimum number of days needed
 * }</pre>
 *
 * @author  Sai Pavan
 */
public class MBouquetsInMinDays {
    public static void main(String[] args) {
        int limit = 8;
        int[] input = new int[]{7, 7, 7, 7, 13, 11, 12, 7};
        int low = findMin(input);
        int high = findMax(input);
        int noOfBouquets = 2;
        int flowersPerBouquet = 3;
        System.out.println(findMinDaysToMakeMBouquets(input, limit, noOfBouquets, flowersPerBouquet, low, high));
    }

    private static int findMinDaysToMakeMBouquets(int[] input, int limit, int noOfBouquets, int flowersPerBouquet, int low, int high) {
        if(limit < flowersPerBouquet*noOfBouquets) return -1;
        if(low > high) return low;

        int mid = low + (high-low)/2;

        if(bouquetsPossible(input, noOfBouquets, flowersPerBouquet, mid)) {
            return findMinDaysToMakeMBouquets(input, limit, noOfBouquets, flowersPerBouquet, low, mid - 1);
        } else {
            return findMinDaysToMakeMBouquets(input, limit, noOfBouquets, flowersPerBouquet, mid + 1, high);
        }
    }

    private static boolean bouquetsPossible(int[] input, int noOfBouquets, int flowersPerBouquet, int currentDay) {
        int count = 0;

        for(int i : input) {
            if(i <= currentDay) {
                count += 1;
            } else {
                noOfBouquets = noOfBouquets - count/flowersPerBouquet;
                count = 0;
            }
        }

        noOfBouquets = noOfBouquets - count/flowersPerBouquet;

        return noOfBouquets <= 0;
    }

    public static int findMin(int[] input) {
        int min = Integer.MAX_VALUE;

        for(int i : input) {
            min = Math.min(min, i);
        }

        return min;
    }
}
