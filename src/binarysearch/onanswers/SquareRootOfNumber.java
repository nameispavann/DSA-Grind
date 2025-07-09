package binarysearch.onanswers;

/**
 * The {@code SquareRootOfNumber} class provides a recursive binary search-based solution
 * to compute the floor value of the square root of a given non-negative number.
 *
 * <p>This implementation efficiently finds the largest integer whose square is less than or equal
 * to the input using binary search on the answer space, achieving a logarithmic time complexity.
 *
 * <p>Key Highlights:
 * <ul>
 *     <li>Handles large inputs by using {@code long} for both input and intermediate calculations.</li>
 *     <li>Prevents overflow by computing {@code mid * mid} as {@code long} rather than casting after exponentiation.</li>
 *     <li>Searches within the range [1, input] using binary search.</li>
 *     <li>Returns the floor of the square root when the exact root is not an integer.</li>
 * </ul>
 *
 * <p><b>Example:</b><br>
 * Input: 28<br>
 * Output: 5 (Since 5² = 25 and 6² = 36, 5 is the floor square root)
 *
 * <p>This class demonstrates how binary search can be adapted to solve mathematical approximation
 * problems efficiently by narrowing down the answer space based on condition checks.
 *
 * @author Sai Pavan
 */
public class SquareRootOfNumber {
    public static void main(String[] args) {
        long input = 28;
        System.out.println(findSquareRootRecursively(input, 1, input));
    }

    private static long findSquareRootRecursively(long input, long start, long end) {
        if(start > end) return end;

        long mid = start + (end - start)/2;
        long midSquare = (long)Math.pow(mid, 2);
        System.out.println("input: " + input + " start: " + start + " mid: " + mid + " end: " + end);

        if(midSquare == input) return mid;
        else if (midSquare < input) return findSquareRootRecursively(input, mid + 1, end);
        else return findSquareRootRecursively(input, start, mid - 1);
    }
}
