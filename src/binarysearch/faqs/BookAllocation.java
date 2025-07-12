package binarysearch.faqs;

import static binarysearch.onanswers.SmallestDivisor.findMax;

public class BookAllocation {
    public static void main(String[] args) {
        int[] input = new int[]{15, 17, 20};
        int students = 2;
        int low = findMax(input);
        int high = findSum(input);
        int result = findMaxPossibleMinPages(input, students, low, high);

        System.out.println(result);
    }

    private static int findMaxPossibleMinPages(int[] input, int students, int low, int high) {
        if(low > high) return high;

        int mid = low + (high - low)/2;
        if(isValidPages(input, mid, students)) {
            return findMaxPossibleMinPages(input, students, mid + 1, high);
        } else {
            return findMaxPossibleMinPages(input, students, low, mid - 1);
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
