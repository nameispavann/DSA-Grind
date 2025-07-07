package binarysearch.fundamentals;

/**
 * The {@code UpperBound} class provides both iterative and recursive implementations
 * of binary search to compute the upper bound index of a target value in a sorted array.
 *
 * <p><b>Definition:</b><br>
 * The <b>upper bound</b> of a target in a sorted array is the index of the first element
 * that is strictly greater than the target. If all elements are less than or equal to the target,
 * the upper bound is the index at which the target could be inserted to maintain the sorted order.
 *
 * <p>This class includes:
 * <ul>
 *     <li><b>Iterative Method:</b> Efficient binary search loop to find the upper bound index.</li>
 *     <li><b>Recursive Method:</b> Recursive binary search implementation of the same logic.</li>
 * </ul>
 *
 * <p><b>Example:</b><br>
 * Input Array: [1, 2, 4, 4, 5]<br>
 * Target: 4<br>
 * Output: 4 (Element just after the last 4 is 5 at index 4)
 *
 * <p>This class demonstrates how binary search can be adapted to solve boundary-based queries
 * in sorted datasets, which is essential in range queries, insertion problems, and frequency calculations.
 *
 * @author Sai Pavan
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
