package binarysearch.logicbuilding;

import java.util.ArrayList;


/**
 * The {@code SearchInRotatedSortedArrayII} class provides a recursive implementation
 * of binary search to determine whether a target exists in a rotated sorted array
 * that may contain duplicate elements.
 *
 * <p><b>Problem Context:</b><br>
 * A rotated sorted array is one that has been shifted around a pivot point.
 * For example, the sorted array [1, 2, 3, 4, 5] rotated could become [3, 4, 5, 1, 2].
 * The challenge increases when the array contains duplicate values, which can obscure
 * the determination of sorted halves during binary search.
 *
 * <p><b>Core Approach:</b><br>
 * This recursive implementation adapts binary search with additional checks for duplicates:
 * <ul>
 *     <li>If start, mid, and end elements are equal, it skips duplicates by shrinking the search space.</li>
 *     <li>Otherwise, it determines which half is sorted and whether the target lies within that half.</li>
 * </ul>
 *
 * <p><b>Time Complexity:</b><br>
 * - Average: O(log n)<br>
 * - Worst-case (with many duplicates): O(n) — due to inability to discard half the array
 *
 * <p><b>Example:</b><br>
 * Input Array: [7, 8, 1, 2, 3, 3, 3, 4, 5, 6]<br>
 * Target: -1<br>
 * Output: false (Target not present)
 *
 * <p>This class is useful for interview preparation and real-world scenarios involving rotated
 * arrays with non-unique values, such as searching in circularly sorted datasets.
 *
 * @author Sai Pavan
 */
public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] input = new int[]{7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        ArrayList<Integer> nums = new ArrayList<>(){};
        for(int i : input) {
            nums.add(i);
        }
        int target = -1;
        System.out.println(searchInRotatedSortedArrayRecursively(nums, target, 0, nums.size() - 1));
    }

    private static boolean searchInRotatedSortedArrayRecursively(ArrayList<Integer> input, int target, int startIndex, int endIndex) {
        if(startIndex > endIndex) return false;

        int midIndex = startIndex + (endIndex - startIndex)/2;
        if(input.get(midIndex) == target) return true;

        // If duplicates obscure sorted halves, shrink the search window from both ends
        if(input.get(startIndex) == input.get(midIndex) && input.get(midIndex) == input.get(endIndex)) {
            return searchInRotatedSortedArrayRecursively(input, target, startIndex + 1, endIndex - 1);
        }
        //check if left of mid is sorted
        if (input.get(startIndex) <= input.get(midIndex)) {
            //check if target comes in this range or not
            if(target >= input.get(startIndex) && target < input.get(midIndex)) {
                return searchInRotatedSortedArrayRecursively(input, target, startIndex, midIndex - 1);
            } else {
                //move to right side of mid
                return searchInRotatedSortedArrayRecursively(input, target, midIndex + 1, endIndex);
            }
        } else {
            if(target > input.get(midIndex) && target <= input.get(endIndex)) {
                return searchInRotatedSortedArrayRecursively(input, target, midIndex + 1, endIndex);
            } else {
                //move to left side of mid
                return searchInRotatedSortedArrayRecursively(input, target, startIndex, midIndex - 1);
            }
        }

    }

}
