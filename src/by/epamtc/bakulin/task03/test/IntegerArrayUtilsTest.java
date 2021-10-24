package by.epamtc.bakulin.task03.test;

import by.epamtc.bakulin.task03.entity.DynamicArray;
import by.epamtc.bakulin.task03.entity.Array;
import by.epamtc.bakulin.task03.utils.ArrayUtils;
import by.epamtc.bakulin.task03.utils.SortType;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IntegerArrayUtilsTest {

    @Test
    public void testArrayUtilsA1() {
        System.out.println("Test1: Bubble sort Ascending - Started");
        Integer[] arr = new Integer[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array<Integer> array1 = new DynamicArray<>(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sort(array1, SortType.BUBBLE);
        System.out.println(String.format("Sorted Array Ascending: %s", array1.toString()));

        System.out.println("Test1: Bubble sort - Finished\n");
    }

    @Test
    public void testArrayUtilsA2() {
        System.out.println("Test1: Bubble sort Descending - Started");
        Integer[] arr = new Integer[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array<Integer> array1 = new DynamicArray<>(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sort(array1, SortType.BUBBLE, false);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test1: Bubble sort - Finished\n");
    }

    @Test
    public void testArrayUtilsB1() {
        System.out.println("Test3: Selection sort Ascending - Started");
        Integer[] arr = new Integer[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array<Integer> array1 = new DynamicArray<>(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sort(array1, SortType.SELECTION);
        System.out.println(String.format("Sorted Array Ascending: %s", array1.toString()));

        System.out.println("Test3: Selection sort - Finished\n");
    }

    @Test
    public void testArrayUtilsB2() {
        System.out.println("Test3: Selection sort Descending - Started");
        Integer[] arr = new Integer[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array<Integer> array1 = new DynamicArray<>(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sort(array1, SortType.SELECTION, false);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test3: Selection sort - Finished\n");
    }

    @Test
    public void testArrayUtilsC1() {
        System.out.println("Test5: Quick sort Ascending - Started");
        Integer[] arr = new Integer[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array<Integer> array1 = new DynamicArray<>(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sort(array1, SortType.QUICK);
        System.out.println(String.format("Sorted Array Ascending: %s", array1.toString()));

        System.out.println("Test5: Quick sort - Finished\n");
    }

    @Test
    public void testArrayUtilsC2() {
        System.out.println("Test5: Quick sort Descending - Started");
        Integer[] arr = new Integer[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array<Integer> array1 = new DynamicArray<>(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sort(array1, SortType.QUICK, false);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test5: Quick sort - Finished\n");
    }

    @Test
    public void testArrayUtilsD1() {
        System.out.println("Test7: Binary Search - Started");
        Integer[] arr = new Integer[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array<Integer> array1 = new DynamicArray<>(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));
        int searchValue = 4;
        System.out.println(String.format("search value = %d", searchValue));
        int resIndex = ArrayUtils.binarySearch(4, array1);
        System.out.println(String.format("result index = %d", resIndex));
        System.out.println(String.format("Sorted Array: %s", array1.toString()));
        System.out.println("Test7: Binary Search - Finished\n");
    }
    @Test
    public void testArrayUtilsD2() {
        System.out.println("Test7.1: Binary Search Pre-sorted array - Started");
        Integer[] arr = new Integer[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));

        Array<Integer> array1 = new DynamicArray<>(arr);
        ArrayUtils.sort(array1, SortType.QUICK);
        System.out.println(String.format("Current sorted Array: %s", array1.toString()));

        int searchValue = 4;
        System.out.println(String.format("search value = %d", searchValue));
        int resIndex = ArrayUtils.binarySearch(4, array1, true);
        System.out.println(String.format("result index = %d", resIndex));
        System.out.println("Test7: Binary Search - Finished\n");
    }

    @Test
    public void testArrayUtilsE1() {
        System.out.println("Test8: Search Minimal value - Started");
        Integer[] arr = new Integer[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array<Integer> array1 = new DynamicArray<>(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        int minimalValue = ArrayUtils.findMinimalValue(array1);
        System.out.println(String.format("minimal value = %d", minimalValue));

        System.out.println("Test8: Search Minimal value - Finished\n");
    }

    @Test
    public void testArrayUtilsF1() {
        System.out.println("Test9: Search Maximal value - Started");
        Integer[] arr = new Integer[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array<Integer> array1 = new DynamicArray<>(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        int maximalValue = ArrayUtils.findMaximalValue(array1);
        System.out.println(String.format("maximal value = %d", maximalValue));

        System.out.println("Test9: Search Maximal value - Finished\n");
    }
/**
    @Test
    public void testArrayUtilsG1() {
        System.out.println("Test10: Find All Prime Numbers - Started");
        int[] arr = new int[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array array1 = new DynamicArray(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        int[] primes = ArrayUtils.findAllPrimes(array1);
        System.out.println(String.format("primes: = %s", Arrays.toString(primes)));

        System.out.println("Test10: Find All Prime Numbers - Finished\n");
    }

    @Test
    public void testArrayUtilsG2() {
        System.out.println("Test11: Find All Fibonacci Numbers - Started");
        int[] arr = new int[]{7, 3, 4, 6, 8, 5, 1};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array array1 = new DynamicArray(arr);

        int[] resultFibonacci = ArrayUtils.findAllFibonacci(array1);
        System.out.println(String.format("fibonacci values: %s", Arrays.toString(resultFibonacci)));
        System.out.println("Test10: Find All Fibonacci Numbers - Finished\n");
    }

    @Test
    public void testArrayUtilsG3() {
        System.out.println("Test12: Array Reverse - Started");
        int[] arr = new int[]{7, 3, 4, 6, 8, 5, 1, 4, 3};
        System.out.println(String.format("(array): %s", Arrays.toString(arr)));
        ArrayUtils.arrayReverse(arr);
        System.out.println(String.format("(array) reverse: %s", Arrays.toString(arr)));

        Array array1 = new DynamicArray(arr);
        System.out.println(String.format("(Attempt to add(int[] array): %s", Arrays.toString(arr)));
        System.out.println(String.format("(Added array): %s", array1.toString()));
        ArrayUtils.arrayReverse(array1);
        System.out.println(String.format("(Reversed array): %s", array1.toString()));
        System.out.println("Test12: Array Reverse - Finished");
    }

    @Test
    public void testArrayUtilsH1() {
        System.out.println("Test13: Find All Unique Values - Started");

        int[] arr = new int[]{775, 345, 447, 651, 977, 355, 181};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array array1 = new DynamicArray(arr);

        Array uniqueValues = ArrayUtils.findAllUniqueValues(array1);
        System.out.println(String.format("Unique values: %s", uniqueValues));

        System.out.println("Test13: Find All Unique Values - Finished");

    }

    @Test
    public void testArrayUtilsI1() {
        System.out.println("Test13: Populate existing Array from TXT file - Started");
        int[] arr = new int[]{775, 345, 447, 651, 977, 355, 181};
        Array array = new DynamicArray(arr);
        ArrayUtils.populateIntegerArrayFromTxtFile(array, "E:/EPAM Projects/epam-training-java-web-task03-bakulin/resources/array.txt", 0);
        System.out.println(array);
        System.out.println("Test13: Populate existing Array from TXT file - Started");
    }

    @Test
    public void testArrayUtilsI2() {
        System.out.println("Test13: Populate new Array from TXT file - Started");
        Array array = ArrayUtils.populateIntegerArrayFromTxtFile("E:/EPAM Projects/epam-training-java-web-task03-bakulin/resources/array.txt", 1);
        System.out.println(array);
        System.out.println("Test13: Populate new Array from TXT file - Started");
    }


*/
}
