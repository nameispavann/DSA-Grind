package binarysearch.onanswers;

import static binarysearch.onanswers.SmallestDivisor.calculateSum;
import static binarysearch.onanswers.SmallestDivisor.findMax;

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
