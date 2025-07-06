package binarysearch.fundamentals;

/**
 * Finds the lower bound index of a target element in a sorted array.
 * <p>
 * The lower bound is the index of the first element in the array
 * that is greater than or equal to the given target.
 * <p>
 * Assumes the input array is sorted in non-decreasing order.
 * <p>
 * Input:  int[] input - sorted array
 * int target  - value to search for
 * Output: int - index of the lower bound (or input.length if target is greater than all elements)
 * <p>
 * Problem statement: Given a sorted array of nums and an integer x, write a program to find the lower bound of x.
 * The lower bound algorithm finds the first and smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.
 * If no such index is found, return the size of the array.
 */
public class LowerBound {
    //case 1: duplicate target elements - input = [1,2,2,3,4], target = 2
    //case 2: no matching target element but lower bound exists - input = [1,2,4,5,6], target = 3
    //case 3: no matching target element - input = [1,2,4,5,6], target = 9
    public static void main(String[] args) {
        //Using single method Binary search
        System.out.println(findLowerBound(new int[]{1, 2, 4, 4, 5}, 0));

        //Using recursive Binary search
        System.out.println(findLowerBoundRecursively(new int[]{1, 2, 4, 4, 5}, 0));
    }

    private static int findLowerBound(int[] input, int target) {
        int startIndex = 0;
        int endIndex = input.length - 1;
        int midIndex = -1;
        while (startIndex <= endIndex) {
            midIndex = startIndex + (endIndex - startIndex) / 2;
            if (input[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return startIndex;
    }

    private static int findLowerBoundRecursively(int[] input, int target) {
        return findLowerBound(input, target, 0, input.length - 1);
    }

    private static int findLowerBound(int[] input, int target, int startIndex, int endIndex) {
        //pre condition
        if (startIndex > endIndex) return startIndex;

        int midIndex = startIndex + (endIndex - startIndex) / 2;
        if (input[midIndex] < target) return findLowerBound(input, target, midIndex + 1, endIndex);
        else return findLowerBound(input, target, startIndex, midIndex - 1);
    }
}
