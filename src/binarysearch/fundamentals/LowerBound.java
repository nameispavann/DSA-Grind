package binarysearch.fundamentals;

/**
 * The {@code LowerBound} class provides both iterative and recursive implementations
 * of binary search to compute the lower bound index of a target value in a sorted array.
 *
 * <p><b>Definition:</b><br>
 * The <b>lower bound</b> of a target in a sorted array is the index of the first element
 * that is greater than or equal to the target. If no such element exists, it returns the
 * index where the target could be inserted to maintain the sorted order (i.e., the position
 * just beyond the last element).
 *
 * <p>This class includes:
 * <ul>
 *     <li><b>Iterative Method:</b> Uses a loop to perform binary search and return the lower bound.</li>
 *     <li><b>Recursive Method:</b> Performs the same logic recursively, useful for learning and elegance.</li>
 * </ul>
 *
 * <p><b>Example:</b><br>
 * Input Array: [1, 2, 4, 4, 5]<br>
 * Target: 0<br>
 * Output: 0 (0 would be inserted before 1, hence lower bound index is 0)
 *
 * <p>This class demonstrates how binary search can be modified to find positional bounds
 * rather than exact matches — a key concept in solving range-based or boundary-based problems
 * in sorted arrays.
 *
 * @author Sai Pavan
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
