import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class task003 {
    public static void main(String[] args) {
        int [] exampleArray = {91,2,43,4,5,132,4,3,23,13,4,35,1,24,1,2,324,5,3};
        System.out.println(Arrays.toString(exampleArray));
        System.out.println(Arrays.toString(SortArray(exampleArray)));
        
        Integer[] someNumbers = { 1, 2, 3, 4, 5, 2, 1, 3, 24, 543, 5, 345, 23, 52, 45, 23, 42, 34, 234, 23 };
        System.out.println(Arrays.toString(someNumbers));
        System.out.println(Arrays.toString(RemoveEven(someNumbers)));
        
        ArrayList<Integer> integerList = new ArrayList(
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 54, 45, 64, 3, 5, 53, 32, 4, 45, 6, 5, 34, 1));
        System.out.println("Max element " + MaxElement(integerList));
        System.out.println("Min element " + MinElement(integerList));
        System.out.println("Average " + Average(integerList));
    }

    public static int[] SortArray(int[] someArray) {
        if (someArray.length == 0 || someArray.length == 1) {
            return someArray;
        }
        int[] leftArray = Arrays.copyOfRange(someArray, 0, someArray.length / 2);
        int[] rightArray = Arrays.copyOfRange(someArray, someArray.length / 2, someArray.length);

        leftArray = SortArray(leftArray);
        rightArray = SortArray(rightArray);

    
        return MergeTwoArrays(leftArray, rightArray);
    }
        
    public static int[] MergeTwoArrays(int[] leftArray, int[] rightArray) {
        int[] mergedArray = new int[leftArray.length + leftArray.length];
        int positionLeft = 0;
        int positionRight = 0;

        for (int i = 0; i < mergedArray.length; i++) {
            if (positionLeft == leftArray.length)
                mergedArray[i] = rightArray[positionRight++];
            else if (positionRight == rightArray.length)
                mergedArray[i] = leftArray[positionLeft++];
            else if (leftArray[positionLeft] > rightArray[positionRight])
                mergedArray[i] = rightArray[positionRight++];
            else
                mergedArray[i] = leftArray[positionLeft++];
        }
        return mergedArray;
    }

    private static Integer[] RemoveEven(Integer[] numberArray) {
        ArrayList<Integer> initialArray = new ArrayList<>();
        for (Integer number : numberArray) {
            if (number % 2 != 0) {
                initialArray.add(number);
            }
        }
        Integer[] oddOnly = new Integer[initialArray.size()];
        for (int i = 0; i < oddOnly.length; i++) {
            oddOnly[i] = initialArray.get(i);
        }
        return oddOnly;

    }

    public static Integer MaxElement(ArrayList<Integer> numbersList) {
        Integer max = numbersList.get(0);
        for (Integer element : numbersList) {
            if (element > max) {
                max = element;
            }

        }
        return max;
    }

    public static Integer MinElement(ArrayList<Integer> numbersList) {
        Integer min = numbersList.get(0);
        for (Integer element : numbersList) {
            if (element <min) {
                min = element;
            }

        }
        return min;
    }
    public static Float Average(ArrayList<Integer> numbersList) {
        Float average = 0f;
        for (Integer element : numbersList) {
            average += element;
        }
        return average/numbersList.size();    
    }
}
