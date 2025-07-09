package binarysearch.logicbuilding;

/**
 * The {@code SingleElementInSortedArray} class provides a recursive binary search-based solution
 * to find the single non-duplicate element in a sorted array where every other element appears exactly twice.
 *
 * <p>This implementation leverages the pattern of paired elements and the properties of binary search
 * to achieve a logarithmic time complexity of O(log n).
 *
 * <p>Key Highlights:
 * <ul>
 *     <li>Handles sorted arrays where all elements except one appear exactly twice.</li>
 *     <li>Efficiently identifies the unique element using a divide-and-conquer strategy.</li>
 *     <li>Includes boundary checks to prevent index-out-of-bounds errors.</li>
 *     <li>Uses index parity (even/odd) to determine which half of the array to search next.</li>
 * </ul>
 *
 * <p><b>Example:</b><br>
 * Input Array: [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7]<br>
 * Output: 7 (The single non-duplicate element)
 *
 * <p>This class demonstrates how binary search can be adapted to solve uniqueness-finding problems
 * in sorted arrays efficiently by leveraging structural properties of the input.
 *
 * @author Sai Pavan
 */
public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7};
        System.out.println(findSingleElementInSortedArrayRecursively(input, 0, input.length - 1));
    }

    private static int findSingleElementInSortedArrayRecursively(int[] input, int startIndex, int endIndex) {
        // Base case: only one element left, so that must be the single element.
        if (startIndex == endIndex) return input[startIndex];

        int midIndex = startIndex + (endIndex - startIndex) / 2;

        // Check if mid is the first index
        if (midIndex == 0) {
            return input[midIndex] != input[midIndex + 1] ? input[midIndex] : -1;
        }
        // Check if mid is the last index
        else if (midIndex == input.length - 1) {
            return input[midIndex] != input[midIndex - 1] ? input[midIndex] : -1;
        }
        // Check if mid is the unique element (not equal to neighbors)
        else if (input[midIndex] != input[midIndex - 1] && input[midIndex] != input[midIndex + 1]) {
            return input[midIndex];
        }

        // Decide the search direction based on the index pattern
        // If pair starts at mid and it's even -> go right
        // If pair ends at mid and it's odd -> go right
        if ((midIndex % 2 == 0 && input[midIndex] == input[midIndex + 1]) ||
                (midIndex % 2 == 1 && input[midIndex] == input[midIndex - 1])) {
            return findSingleElementInSortedArrayRecursively(input, midIndex + 1, endIndex);
        } else {
            return findSingleElementInSortedArrayRecursively(input, startIndex, midIndex - 1);
        }
    }

}
