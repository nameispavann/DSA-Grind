package binarysearch.logicbuilding;

/**
 * The {@code FloorAndCeiling} class provides a recursive binary search-based solution
 * to find the floor and ceiling of a given target value in a sorted array.
 *
 * <p><b>Definitions:</b>
 * <ul>
 *     <li><b>Floor:</b> The greatest element in the array that is less than or equal to the target.</li>
 *     <li><b>Ceiling:</b> The smallest element in the array that is greater than or equal to the target.</li>
 * </ul>
 *
 * <p>This implementation ensures:
 * <ul>
 *     <li>Efficient search using recursive binary search (O(log n) time complexity).</li>
 *     <li>Correct handling of edge cases where floor or ceiling may not exist in the array (returns -1).</li>
 *     <li>Works on sorted arrays and handles duplicates correctly.</li>
 * </ul>
 *
 * <p><b>Example:</b><br>
 * Input Array: [3, 4, 4, 7, 8, 10]<br>
 * Target: 5<br>
 * Output: [4, 7] (4 is the floor, 7 is the ceiling)
 *
 * <p>This class is a good demonstration of how binary search can be adapted to locate
 * boundary-based values like floor and ceiling in a sorted dataset.
 *
 * @author Sai Pavan
 */
public class FloorAndCeiling {

    public static void main(String[] args) {
        int[] result = findFloorAndCeilingRecursively(new int[]{3, 4, 4, 7, 8, 10}, 5);
        for(int i : result) {
            System.out.println(i);
        }
    }

    private static int[] findFloorAndCeilingRecursively(int[] input, int target) {
        return findFloorAndCeiling(input, target, 0, input.length - 1);
    }

    private static int[] findFloorAndCeiling(int[] input, int target, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            startIndex = (startIndex < 0 || startIndex > input.length -1) ? -1 : startIndex;
            endIndex = (endIndex < 0 || endIndex > input.length -1) ? -1 : endIndex;
            return new int[]{endIndex != -1 ? input[endIndex] : endIndex, startIndex != -1 ? input[startIndex] : startIndex};
        }

        int midIndex = startIndex + (endIndex - startIndex)/2;
        if(input[midIndex] == target) return new int[]{input[midIndex], input[midIndex]};
        else if(input[midIndex] < target) return findFloorAndCeiling(input, target, midIndex + 1, endIndex);
        else return findFloorAndCeiling(input, target, startIndex, midIndex -1);
    }
}
