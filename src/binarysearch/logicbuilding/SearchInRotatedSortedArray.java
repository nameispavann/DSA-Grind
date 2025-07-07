package binarysearch.logicbuilding;

/**
 * The {@code SearchInRotatedSortedArray} class provides a recursive implementation
 * of binary search to locate a target value in a rotated sorted array.
 *
 * <p><b>Problem Context:</b><br>
 * A rotated sorted array is an array that was originally sorted in ascending order,
 * but then rotated at some pivot unknown to us beforehand.
 * For example, [0, 1, 2, 4, 5, 6, 7] could become [4, 5, 6, 7, 0, 1, 2].
 *
 * <p><b>Core Approach:</b><br>
 * This implementation recursively determines which half of the array is sorted,
 * and checks if the target lies within that sorted half. Based on this:
 * <ul>
 *     <li>If the left half is sorted and the target lies in it, recurse into the left half.</li>
 *     <li>If the right half is sorted and the target lies in it, recurse into the right half.</li>
 *     <li>Otherwise, recurse into the unsorted half accordingly.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b> O(log n)<br>
 * <b>Space Complexity:</b> O(log n) (due to recursive stack)
 *
 * <p><b>Example:</b><br>
 * Input Array: [4, 5, 6, 7, 0, 1, 2]<br>
 * Target: 5<br>
 * Output: 1 (Target found at index 1)
 *
 * <p>This class demonstrates an important variant of binary search,
 * commonly asked in technical interviews and competitive coding.
 *
 * @author Sai Pavan
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(searchInRotatedSortedArrayRecursively(new int[]{39,45,48,52,74,-82,-81,-77,-74,-70,-46,-37,-29,-28,-15,15,19,27,33}, 52));
    }

    private static int searchInRotatedSortedArrayRecursively(int[] input, int target) {
        return searchInRotatedSortedArray(input, target, 0, input.length - 1);
    }

    private static int searchInRotatedSortedArray(int[] input, int target, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return -1;
        }

        int midIndex = startIndex + (endIndex - startIndex)/2;

        if(input[midIndex] == target) return midIndex;

        //check if left part from mid is sorted
        if(input[startIndex] <= input[midIndex]) {
            //if yes, check if the target element exists in this range
            if(target >= input[startIndex] && target < input[midIndex]) {
                //go further into left side
                return searchInRotatedSortedArray(input, target, startIndex, midIndex - 1);
            } else {
                //go to right side from mid
                return searchInRotatedSortedArray(input, target, midIndex + 1, endIndex);
            }
        }
        //if left part from mid is not sorted then check if right part is sorted
        else {
            //if yes, check if target element exists in this range
            if(target > input[midIndex] && target <= input[endIndex]) {
                //move further into right side
                return searchInRotatedSortedArray(input, target, midIndex + 1, endIndex);
            } else {
                // move towards left side of mid
                return searchInRotatedSortedArray(input, target, startIndex, midIndex - 1);
            }
        }
    }
}
