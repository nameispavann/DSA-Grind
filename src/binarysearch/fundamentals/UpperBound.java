package binarysearch.fundamentals;

/**
 * Finds the upper bound index of a target element in a sorted array.
 * <p>
 * The upper bound is the index of the first element in the array
 * that is strictly greater than the given target.
 * <p>
 * Assumes the input array is sorted in non-decreasing order.
 * <p>
 * Input:  int[] input - sorted array
 * int target  - value to search for
 * Output: int - index of the upper bound (or input.length if target is greater than or equal to all elements)
 * <p>
 * Problem Statement: Given a sorted array of nums and an integer x, write a program to find the upper bound of x.
 * The upper bound algorithm finds the first and smallest index in a sorted array where the value at that index is strictly greater than a given key i.e. x.
 * If no such index is found, return the size of the array.
 */
public class UpperBound {
    //case 1: duplicate target elements - input = [1,2,2,3,4], target = 2
    //case 2: no matching target element but upper bound exists - input = [1,2,4,5,6], target = 3
    //case 3: no matching target element - input = [1,2,4,5,6], target = 9
    public static void main(String[] args) {
        System.out.println(findUpperBound(new int[]{1, 2, 4, 4, 5}, 4));
        System.out.println(findUpperBoundRecursively(new int[]{1, 2, 4, 4, 5}, 4));
    }

    private static int findUpperBound(int[] input, int target) {
        int startIndex = 0;
        int endIndex = input.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (input[midIndex] <= target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        return startIndex;
    }

    private static int findUpperBoundRecursively(int[] input, int target) {
        return findUpperBound(input, target, 0, input.length - 1);
    }

    private static int findUpperBound(int[] input, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) return startIndex;

        int midIndex = startIndex + (endIndex - startIndex) / 2;

        if (input[midIndex] <= target) return findUpperBound(input, target, midIndex + 1, endIndex);
        else return findUpperBound(input, target, startIndex, midIndex - 1);
    }
}
