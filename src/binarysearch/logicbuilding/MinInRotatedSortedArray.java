package binarysearch.logicbuilding;

import java.util.ArrayList;

/**
 * The {@code MinInRotatedSortedArray} class provides a recursive binary search implementation
 * to efficiently find the minimum (or pivot) element in a rotated sorted array.
 *
 * <p><b>Problem Context:</b><br>
 * A rotated sorted array is an array originally sorted in ascending order but rotated
 * at some unknown pivot. For example:
 * <pre>
 *     Original: [0, 1, 2, 4, 5, 6, 7]
 *     Rotated:  [4, 5, 6, 7, 0, 1, 2]
 * </pre>
 * The goal is to find the minimum element (which is also the point of rotation) in
 * <b>O(log n)</b> time using a modified binary search.
 *
 * <p><b>Core Approach:</b><br>
 * The recursive method leverages binary search principles to discard one half of the array
 * at every recursive call by identifying which portion (left or right) is properly sorted.
 * The algorithm works as follows:
 * <ul>
 *   <li>If the left half (from start to mid) is sorted, then the minimum must lie in the
 *       unsorted half — i.e., the right side — so we move right.</li>
 *   <li>If the left half is not sorted, then the pivot lies in that region — so we move left.</li>
 *   <li>At each step, the smallest of the current candidate (start or mid) and the known
 *       {@code minValue} is tracked.</li>
 * </ul>
 * This ensures the minimum value is always preserved during traversal, even if the pivot is at the edge.
 *
 * <p><b>Example Execution:</b><br>
 * <pre>
 * Input: [4, 5, 6, 7, 0, 1, 2, 3]
 * Steps:
 *     mid = 3 → input[mid] = 7 → left is sorted → min = min(∞, 4) = 4 → search right
 *     mid = 5 → input[mid] = 1 → left is sorted → min = min(4, 0) = 0 → search right
 *     ...
 * Result: 0
 * </pre>
 *
 * <p><b>Time Complexity:</b> O(log n) — since we halve the search space each time.<br>
 * <b>Space Complexity:</b> O(log n) — due to recursive stack depth in the worst case.
 *
 * <p><b>Assumptions:</b>
 * <ul>
 *   <li>No duplicate elements in the input array.</li>
 *   <li>Array is non-empty and contains at least one element.</li>
 * </ul>
 *
 * <p>This implementation demonstrates a classic application of binary search in a non-traditional
 * problem and is often asked in technical interviews to evaluate problem-solving and recursion skills.
 *
 * @author Sai Pavan
 */

public class MinInRotatedSortedArray {

    public static void main(String[] args) {
        int[] input = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i : input) {
            nums.add(i);
        }
        System.out.println(findMinInRotatedSortedArray(nums, 0, nums.size() - 1, Integer.MAX_VALUE));
    }

    private static int findMinInRotatedSortedArray(ArrayList<Integer> input, int startIndex, int endIndex, int minValue) {
        if(startIndex > endIndex) return minValue;

        int midIndex = startIndex + (endIndex - startIndex)/2;

        // check if left side of mid is sorted
        if(input.get(startIndex) <= input.get(midIndex)) {
            //consider value at startIndex as minValue and check smallest of minValue and input.get(startIndex)
            minValue = Math.min(input.get(startIndex), minValue);
            //post this move towards other side to check if there's any other element smaller than current minValue
            return findMinInRotatedSortedArray(input, midIndex + 1, endIndex, minValue);
        } else {
            //right side of mid is sorted
            minValue = Math.min(input.get(midIndex), minValue);
            return findMinInRotatedSortedArray(input, startIndex, midIndex - 1, minValue);
        }
    }
}
