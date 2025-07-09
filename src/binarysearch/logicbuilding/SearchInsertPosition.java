package binarysearch.logicbuilding;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 5, 6};
        System.out.println(searchInsertPositionRecursively(input, 7, 0, input.length - 1));
    }

    private static int searchInsertPositionRecursively(int[] input, int target, int startIndex, int endIndex) {
        if(startIndex > endIndex) return startIndex;

        int midIndex = startIndex + (endIndex - startIndex)/2;
        if(input[midIndex] == target) return midIndex;
        else if (input[midIndex] < target) return searchInsertPositionRecursively(input, target, midIndex + 1, endIndex);
        else return searchInsertPositionRecursively(input, target, startIndex, midIndex - 1);
    }
}
