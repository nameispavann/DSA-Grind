package binarysearch.logicbuilding;

/**
 * The {@code FirstAndLastOccurence} class provides a solution to find the
 * first and last positions of a given target element in a sorted integer array.
 *
 * <p>This implementation uses a recursive variant of binary search to efficiently
 * locate both boundaries of the target element, with a time complexity of O(log n).
 *
 * <p>Key Highlights:
 * <ul>
 *     <li>Handles sorted arrays with duplicate elements.</li>
 *     <li>Returns -1 if the target is not found in the array.</li>
 *     <li>Uses tail-recursive binary search to find:
 *         <ul>
 *             <li>First occurrence: Keeps searching left after finding the target.</li>
 *             <li>Last occurrence: Keeps searching right after finding the target.</li>
 *         </ul>
 *     </li>
 * </ul>
 *
 * <p><b>Example:</b><br>
 * Input Array: [5, 7, 7, 8, 8, 10]<br>
 * Target: 8<br>
 * Output: [3, 4] (First at index 3, Last at index 4)
 *
 * <p>This class demonstrates how binary search can be adapted to solve boundary-finding problems
 * in sorted data structures efficiently.
 *
 * @author Sai Pavan
 */
public class FirstAndLastOccurence {

    public static void main(String[] args) {
        int[] result = findFirstAndLastOccurenceRecursively(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for(int r : result) {
            System.out.println(r);
        }
    }

    private static int[] findFirstAndLastOccurenceRecursively(int[] input, int target) {
        return new int[]{findFirstOccurence(input, target, 0, input.length - 1, -1),
                findLastOccurence(input, target, 0, input.length - 1, -1)};
    }

    private static int findFirstOccurence(int[] input, int target, int startIndex, int endIndex, int firstOccurence) {
        if(startIndex > endIndex) return firstOccurence;

        int midIndex = startIndex + (endIndex - startIndex)/2;
        if(input[midIndex] == target) {
            firstOccurence = midIndex;
            return findFirstOccurence(input, target, startIndex, midIndex - 1, firstOccurence);
        } else if(input[midIndex] < target) return findFirstOccurence(input, target, midIndex + 1, endIndex, firstOccurence);
        else return findFirstOccurence(input, target, startIndex, midIndex - 1, firstOccurence);
    }

    private static int findLastOccurence(int[] input, int target, int startIndex, int endIndex, int lastOccurence) {
        if(startIndex > endIndex) return lastOccurence;

        int midIndex = startIndex + (endIndex - startIndex)/2;
        if(input[midIndex] == target) {
            lastOccurence = midIndex;
           return findLastOccurence(input, target, midIndex + 1, endIndex, lastOccurence);
        } else if(input[midIndex] < target) return findLastOccurence(input, target, midIndex + 1, endIndex, lastOccurence);
        else return findLastOccurence(input, target, startIndex, midIndex - 1, lastOccurence);
    }

}
