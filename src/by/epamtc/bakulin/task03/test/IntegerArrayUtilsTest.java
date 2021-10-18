package by.epamtc.bakulin.task03.test;

import by.epamtc.bakulin.task03.entity.DynamicIntegerArray;
import by.epamtc.bakulin.task03.entity.IntegerArray;
import by.epamtc.bakulin.task03.utils.IntegerArrayUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IntegerArrayUtilsTest {

    @Test
    public void testArrayUtilsA1() {
        System.out.println("Test1: Bubble sort Ascending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        IntegerArrayUtils.sortArrayBubbleAsc(array1);
        System.out.println(String.format("Sorted Array Ascending: %s", array1.toString()));

        System.out.println("Test1: Bubble sort - Finished\n");
    }

    @Test
    public void testArrayUtilsA2() {
        System.out.println("Test2: Bubble sort Descending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        IntegerArrayUtils.sortArrayBubbleDesc(array1);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test2: Bubble sort - Finished\n");
    }

    @Test
    public void testArrayUtilsB1() {
        System.out.println("Test3: Selection sort Ascending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        IntegerArrayUtils.sortArraySelectionAsc(array1);
        System.out.println(String.format("Sorted Array Ascending: %s", array1.toString()));

        System.out.println("Test3: Selection sort - Finished\n");
    }

    @Test
    public void testArrayUtilsB2() {
        System.out.println("Test4: Selection sort Descending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        IntegerArrayUtils.sortArraySelectionDesc(array1);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test4: Selection sort - Finished\n");
    }

    @Test
    public void testArrayUtilsC1() {
        System.out.println("Test5: Quick sort Ascending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        IntegerArrayUtils.sortArrayQuickAsc(array1);
        System.out.println(String.format("Sorted Array Ascending: %s", array1.toString()));

        System.out.println("Test5: Quick sort - Finished\n");
    }

    @Test
    public void testArrayUtilsC2() {
        System.out.println("Test6: Quick sort Descending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        IntegerArrayUtils.sortArrayQuickDesc(array1);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test6: Quick sort - Finished\n");
    }

    @Test
    public void testArrayUtilsD1() {
        System.out.println("Test7: Binary Search - Started");
        int[] arr = new int[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));
        int searchValue = 4;
        System.out.println(String.format("search value = %d", searchValue));
        int resIndex = IntegerArrayUtils.binarySearch(4, array1);
        System.out.println(String.format("result index = %d", resIndex));
        System.out.println(String.format("Sorted Array: %s", array1.toString()));
        System.out.println("Test7: Binary Search - Finished\n");
    }

    @Test
    public void testArrayUtilsE1() {
        System.out.println("Test8: Search Minimal value - Started");
        int[] arr = new int[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        int minimalValue = IntegerArrayUtils.findMinimalValue(array1);
        System.out.println(String.format("minimal value = %d", minimalValue));

        System.out.println("Test8: Search Minimal value - Finished\n");
    }

    @Test
    public void testArrayUtilsF1() {
        System.out.println("Test9: Search Maximal value - Started");
        int[] arr = new int[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        int maximalValue = IntegerArrayUtils.findMaximalValue(array1);
        System.out.println(String.format("maximal value = %d", maximalValue));

        System.out.println("Test9: Search Maximal value - Finished\n");
    }

    @Test
    public void testArrayUtilsG1() {
        System.out.println("Test10: Find All Prime Numbers - Started");
        int[] arr = new int[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        int[] primes = IntegerArrayUtils.findAllPrimes(array1);
        System.out.println(String.format("primes: = %s", Arrays.toString(primes)));

        System.out.println("Test10: Find All Prime Numbers - Finished\n");
    }

    @Test
    public void testArrayUtilsG2() {
        System.out.println("Test11: Find All Fibonacci Numbers - Started");
        int[] arr = new int[]{7, 3, 4, 6, 8, 5, 1};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);

        int[] resultFibonacci = IntegerArrayUtils.findAllFibonacci(array1);
        System.out.println(String.format("fibonacci values: %s", Arrays.toString(resultFibonacci)));
        System.out.println("Test10: Find All Fibonacci Numbers - Finished\n");
    }

    @Test
    public void testArrayUtilsG3() {
        System.out.println("Test12: Array Reverse - Started");
        int[] arr = new int[]{7, 3, 4, 6, 8, 5, 1, 4, 3};
        System.out.println(String.format("(array): %s", Arrays.toString(arr)));
        IntegerArrayUtils.arrayReverse(arr);
        System.out.println(String.format("(array) reverse: %s", Arrays.toString(arr)));

        IntegerArray array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("(Attempt to add(int[] array): %s", Arrays.toString(arr)));
        System.out.println(String.format("(Added array): %s", array1.toString()));
        IntegerArrayUtils.arrayReverse(array1);
        System.out.println(String.format("(Reversed array): %s", array1.toString()));
        System.out.println("Test12: Array Reverse - Finished");
    }

    @Test
    public void testArrayUtilsH1() {
        System.out.println("Test13: Find All Unique Values - Started");

        int[] arr = new int[]{775, 345, 447, 651, 977, 355, 181};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        IntegerArray array1 = new DynamicIntegerArray(arr);

        IntegerArray uniqueValues = IntegerArrayUtils.findAllUniqueValues(array1);
        System.out.println(String.format("Unique values: %s", uniqueValues));

        System.out.println("Test13: Find All Unique Values - Finished");

    }

    @Test
    public void testArrayUtilsI1() {
        System.out.println("Test13: Populate existing Array from TXT file - Started");
        int[] arr = new int[]{775, 345, 447, 651, 977, 355, 181};
        IntegerArray array = new DynamicIntegerArray(arr);
        IntegerArrayUtils.populateIntegerArrayFromTxtFile(array, "E:/EPAM Projects/epam-training-java-web-task03-bakulin/resources/array.txt", 0);
        System.out.println(array);
        System.out.println("Test13: Populate existing Array from TXT file - Started");
    }

    @Test
    public void testArrayUtilsI2() {
        System.out.println("Test13: Populate new Array from TXT file - Started");
        IntegerArray array = IntegerArrayUtils.populateIntegerArrayFromTxtFile("E:/EPAM Projects/epam-training-java-web-task03-bakulin/resources/array.txt", 1);
        System.out.println(array);
        System.out.println("Test13: Populate new Array from TXT file - Started");
    }



}
