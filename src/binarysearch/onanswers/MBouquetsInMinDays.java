package binarysearch.onanswers;

import static binarysearch.onanswers.SmallestDivisor.findMax;

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

    private static int findMin(int[] input) {
        int min = Integer.MAX_VALUE;

        for(int i : input) {
            min = Math.min(min, i);
        }

        return min;
    }
}
