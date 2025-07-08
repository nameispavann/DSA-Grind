package binarysearch.logicbuilding;

import java.util.ArrayList;

/**
 * The {@code FindHowManyTimeArrayIsRotated} class determines how many times
 * a sorted array has been rotated. This is equivalent to finding the index
 * of the minimum (pivot) element in a rotated sorted array without duplicates.
 *
 * <p><b>Problem Context:</b><br>
 * A sorted array that has been rotated `k` times appears as:
 * <pre>
 * Original (sorted):  [0, 1, 2, 3, 4, 5]
 * Rotated 2 times:    [4, 5, 0, 1, 2, 3] → Answer: 2
 * Rotated 0 times:    [0, 1, 2, 3, 4, 5] → Answer: 0
 * Rotated 5 times:    [1, 2, 3, 4, 5, 0] → Answer: 5
 * </pre>
 *
 * The task is to return the number of rotations, which is the index
 * of the smallest element (pivot) in the rotated array.
 *
 * <p><b>Core Approach:</b><br>
 * This implementation uses a modified binary search algorithm to find
 * the minimum element efficiently in O(log n) time. The minimum element
 * indicates the number of rotations.
 *
 * <ul>
 *   <li>At each step, determine if the left half is sorted. If yes, compare its starting
 *       element with the current minimum to possibly update the pivot index.</li>
 *   <li>If the left half is not sorted, the minimum must lie in the left half,
 *       so the search continues there, again updating the pivot index if a smaller
 *       element is found.</li>
 *   <li>The process continues recursively until the entire array has been searched.</li>
 * </ul>
 *
 * <p><b>Assumptions:</b>
 * <ul>
 *   <li>The array contains no duplicate elements.</li>
 *   <li>Array is non-empty and initially sorted in ascending order before rotation.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(log n) — Binary search reduces the space in half every step.<br>
 * <b>Space Complexity:</b> O(log n) — Due to recursive calls on the stack.
 *
 * <p><b>Example:</b>
 * <pre>
 * Input:  [4, 5, 6, 7, 8, -1, 0, 1, 2, 3]
 * Output: 5  // because -1 is the minimum and occurs at index 5
 * </pre>
 *
 * <p>This problem is often asked in coding interviews to assess the understanding
 * of binary search in modified contexts (rotated arrays, inflection points, etc.).
 *
 * @author Sai Pavan
 */

public class FindHowManyTimeArrayIsRotated {
    public static void main(String[] args) {
        int[] input = new int[]{4, 5, 6, 7, 8, -1, 0, 1, 2, 3};
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i : input) {
            nums.add(i);
        }
        System.out.println(findNoOfRotations(nums, 0, nums.size() - 1, -1, Integer.MAX_VALUE));
    }

    private static int findNoOfRotations(ArrayList<Integer> input, int startIndex, int endIndex, int pivotIndex, int minValue) {
        if(startIndex > endIndex) return  pivotIndex;

        int midIndex = startIndex + (endIndex - startIndex)/2;

        if(input.get(startIndex) <= input.get(midIndex)) {
            if (input.get(startIndex) <= minValue) {
                pivotIndex = startIndex;
                minValue = input.get(startIndex);
            }
            return findNoOfRotations(input, midIndex + 1, endIndex, pivotIndex, minValue);
        } else {
            if (input.get(midIndex) <= minValue) {
                pivotIndex = midIndex;
                minValue = input.get(midIndex);
            }
            return findNoOfRotations(input, startIndex, midIndex - 1, pivotIndex, minValue);
        }
    }
}
