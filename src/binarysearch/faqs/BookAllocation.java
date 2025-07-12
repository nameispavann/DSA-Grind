package binarysearch.faqs;

import static binarysearch.onanswers.SmallestDivisor.findMax;

/**
 * The {@code BookAllocation} class solves the classic "Book Allocation Problem"
 * using Binary Search on the answer space.
 *
 * <p>The problem involves distributing a set of books (represented by an array of page counts)
 * to a fixed number of students such that:
 * <ul>
 *     <li>Each student receives a contiguous sequence of books</li>
 *     <li>Each book is assigned to exactly one student</li>
 *     <li>The goal is to minimize the maximum number of pages assigned to any student</li>
 * </ul>
 *
 * <p>This implementation performs a binary search in the range [max(book), sum(books)]
 * to find the smallest possible "maximum pages" value for a valid allocation.
 * <p>
 * In this problem we try to <b>minimize the maximum</b>
 *
 * <p><strong>Use Case:</strong> Efficiently partition books among students to minimize workload disparity.
 *
 * <p><strong>Example:</strong>
 * <pre>{@code
 * Input: books = [25, 46, 28, 49, 24], students = 4
 * Output: 71
 * Explanation: One optimal allocation is [25,46], [28], [49], [24] → max pages = 71
 * }</pre>
 *
 * <p>This approach works in O(N * log(sum - max)) time, where N is the number of books.
 *
 * @author Sai Pavan
 */
public class BookAllocation {
    public static void main(String[] args) {
        int[] input = new int[]{25, 46, 28, 49, 24};
        int students = 4;
        int low = findMax(input); // should be max as the least possible maximum pages per student is the max element in the give array.
        int high = findSum(input);
        int result = minimizeTheMaximumPagesPerStudent(input, students, low, high);

        System.out.println(result);
    }

    private static int minimizeTheMaximumPagesPerStudent(int[] input, int students, int low, int high) {
        if(low > high) return low;

        int mid = low + (high - low)/2;
        if(isValidPages(input, mid, students)) {
            return minimizeTheMaximumPagesPerStudent(input, students, low, mid - 1);
        } else {
            return minimizeTheMaximumPagesPerStudent(input, students, mid + 1, high);
        }
    }

    private static boolean isValidPages(int[] input, int mid, int students) {
        int previousCount = 0;
        int studentCount = 1;

        for(int i : input) {
            if(previousCount + i <= mid) {
                previousCount += i;
            } else {
                previousCount = i;
                studentCount++;
            }
        }

        return studentCount <= students;
    }

    private static int findSum(int[] input) {
        int result = 0;

        for(int i : input) {
            result += i;
        }

        return result;
    }
}
