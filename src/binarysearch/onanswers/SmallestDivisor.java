package binarysearch.onanswers;

/**
 * The {@code SmallestDivisor} class provides a recursive binary search-based solution
 * to find the smallest divisor such that the sum of the ceiling of each array element
 * divided by the divisor is less than or equal to a given target.
 *
 * <p>This problem models a classic binary search on the answer space, where the goal is to
 * minimize the divisor while satisfying the constraint on the transformed sum.
 * <p>
 * In this problem we try to <b>minimize the maximum</b>
 *
 * <p>Key Highlights:
 * <ul>
 *     <li>Performs binary search in the range [1, max(input array)].</li>
 *     <li>At each step, calculates the sum of {@code ceil(num / divisor)} for all elements.</li>
 *     <li>If the sum is within the threshold, it tries smaller divisors (left half).</li>
 *     <li>If the sum exceeds the threshold, it tries larger divisors (right half).</li>
 *     <li>Returns the smallest divisor that satisfies the condition.</li>
 * </ul>
 *
 * <p><b>Example:</b><br>
 * Input: [1, 2, 3, 4, 5], target = 14<br>
 * Output: 1 (Since using divisor = 1, ceil sum = 15, which is > 14; smallest valid divisor is 2)
 *
 * <p>This class demonstrates how binary search can be adapted to efficiently search over
 * potential answers rather than array indices or values directly.
 *
 * @author Sai Pavan
 */
public class SmallestDivisor {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5};
        int target = 14;
        int start = 1;
        int end = findMax(input);
        System.out.println(findSmallestDivisorRecursively(input, target, start, end));
    }

    public static int findMax(int[] input) {
        int max = Integer.MIN_VALUE;
        for(int i : input) {
            max = Math.max(i, max);
        }

        return max;
    }

    private static int findSmallestDivisorRecursively(int[] input, int target, int start, int end) {
        if(start > end) return start;

        int mid = start + (end - start)/2;
        int sum = calculateSum(input, mid);
        if(sum <= target) return findSmallestDivisorRecursively(input, target, start, mid - 1);
        else return findSmallestDivisorRecursively(input, target, mid + 1, end);
    }

    static int calculateSum(int[] input, int mid) {
        int result = 0;

        for(int i : input) {
            result += Math.ceil((double)i/(double)mid);
        }
        return result;
    }
}

