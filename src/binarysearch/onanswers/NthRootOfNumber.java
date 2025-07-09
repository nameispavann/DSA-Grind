package binarysearch.onanswers;

/**
 * The {@code NthRootOfNumber} class provides a recursive binary search-based solution
 * to compute the integer nth root of a given positive number.
 *
 * <p>This implementation finds the integer value `x` such that {@code x^n == input},
 * using binary search in the range [1, input]. If no such integer root exists, it returns -1.
 *
 * <p>Key Highlights:
 * <ul>
 *     <li>Handles any positive integer {@code n} and {@code input} value.</li>
 *     <li>Uses binary search to efficiently check potential roots in logarithmic time.</li>
 *     <li>Leverages {@code Math.pow(mid, n)} to compute powers during the search.</li>
 *     <li>Returns the integer root if it exists, otherwise returns -1.</li>
 * </ul>
 *
 * <p><b>Example:</b><br>
 * Input: n = 4, input = 81<br>
 * Output: 3 (Since 3⁴ = 81)
 *
 * <p>This class demonstrates how binary search can be extended to solve root-finding problems
 * in integer domains with optimal performance.
 *
 * @author Sai Pavan
 */
public class NthRootOfNumber {
    public static void main(String[] args) {
        int nthRoot = 4;
        int input = 81;
        System.out.println(findNthRootRecursively(nthRoot, input, 1, input));
    }

    private static int findNthRootRecursively(int nthRoot, int input, int start, int end) {
        if(start > end) return -1;

        int mid = start + (end - start)/2;
        int midPowerN = (int)Math.pow(mid, nthRoot);

        if(midPowerN == input) return mid;
        else if (midPowerN < input) return findNthRootRecursively(nthRoot, input, mid + 1, end);
        else return findNthRootRecursively(nthRoot, input, start, mid - 1);
    }
}
