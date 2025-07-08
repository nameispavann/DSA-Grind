package binarysearch.logicbuilding;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7};
        System.out.println(findSingleElementInSortedArrayRecursively(input, 0, input.length - 1));
    }

    private static int findSingleElementInSortedArrayRecursively(int[] input, int startIndex, int endIndex) {
        if(startIndex == endIndex) return input[startIndex];

        int midIndex = startIndex + (endIndex - startIndex)/2;

        if(input[midIndex] != input[midIndex - 1] && input[midIndex] != input[midIndex + 1]) return input[midIndex];

        if((midIndex%2 == 0 && input[midIndex] == input[midIndex + 1]) || (midIndex%2 == 1 && input[midIndex] == input[midIndex -1])) {
            return findSingleElementInSortedArrayRecursively(input, midIndex + 1, endIndex);
        } else {
            return findSingleElementInSortedArrayRecursively(input, startIndex, midIndex - 1);
        }
    }
}
