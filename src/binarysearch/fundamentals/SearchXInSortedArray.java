package binarysearch.fundamentals;

public class SearchXInSortedArray {
    public static void main(String[] args) {
        //Using single method Binary search
        System.out.println(findX(new int[]{1, 2, 3, 4, 5}, 20));

        //Using recursive Binary search
        System.out.println(findXRecursively(new int[]{1, 2, 3, 4, 5}, 20));
    }

    private static int findX(int[] input, int target) {
        int startIndex = 0;
        int endIndex = input.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (input[midIndex] == target) {
                return midIndex;
            } else if (input[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        return -1;
    }

    private static int findXRecursively(int[] input, int target) {
        return findX(input, target, 0, input.length - 1);
    }

    private static int findX(int[] input, int target, int startIndex, int endIndex) {
        //pre-condition
        if (startIndex > endIndex) return -1;

        //calculating mid index
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        if (input[midIndex] == target) return midIndex;
        else if (input[midIndex] < target) return findX(input, target, midIndex + 1, endIndex);
        else return findX(input, target, startIndex, endIndex - 1);
    }
}
