package by.epamtc.bakulin.task03.test;

import by.epamtc.bakulin.task03.entity.Array;
import by.epamtc.bakulin.task03.entity.PlainArray;
import by.epamtc.bakulin.task03.utils.ArrayUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArrayUtilsTest {

    @Test
    public void testArrayUtilsA1() {
        System.out.println("Test1: Bubble sort Ascending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArrayBubbleAsc(array1);
        System.out.println(String.format("Sorted Array Ascending: %s", array1.toString()));

        System.out.println("Test1: Bubble sort - Finished\n");
    }

    @Test
    public void testArrayUtilsA2() {
        System.out.println("Test2: Bubble sort Descending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArrayBubbleDesc(array1);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test2: Bubble sort - Finished\n");
    }

    @Test
    public void testArrayUtilsB1() {
        System.out.println("Test3: Selection sort Ascending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArraySelectionAsc(array1);
        System.out.println(String.format("Sorted Array Ascending: %s", array1.toString()));

        System.out.println("Test3: Selection sort - Finished\n");
    }

    @Test
    public void testArrayUtilsB2() {
        System.out.println("Test4: Selection sort Descending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArraySelectionDesc(array1);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test4: Selection sort - Finished\n");
    }

    @Test
    public void testArrayUtilsC1() {
        System.out.println("Test5: Quick sort Ascending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArrayQuickAsc(array1);
        System.out.println(String.format("Sorted Array Ascending: %s", array1.toString()));

        System.out.println("Test5: Quick sort - Finished\n");
    }

    @Test
    public void testArrayUtilsC2() {
        System.out.println("Test6: Quick sort Descending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArrayQuickDesc(array1);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test6: Quick sort - Finished\n");
    }

    @Test
    public void testArrayUtilsD1() {
        System.out.println("Test7: Binary Search - Started");
        int[] arr = new int[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));
        int searchValue = 4;
        System.out.println(String.format("search value = %d", searchValue));
        int resIndex = ArrayUtils.binarySearch(4, array1);
        System.out.println(String.format("result index = %d", resIndex));
        System.out.println(String.format("Sorted Array: %s", array1.toString()));
        System.out.println("Test7: Binary Search - Finished\n");
    }

    @Test
    public void testArrayUtilsE1() {
        System.out.println("Test8: Search Minimal value - Started");
        int[] arr = new int[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        int minimalValue = ArrayUtils.findMinimalValue(array1);
        System.out.println(String.format("minimal value = %d", minimalValue));

        System.out.println("Test8: Search Minimal value - Finished\n");
    }

    @Test
    public void testArrayUtilsF1() {
        System.out.println("Test9: Search Maximal value - Started");
        int[] arr = new int[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        int maximalValue = ArrayUtils.findMaximalValue(array1);
        System.out.println(String.format("maximal value = %d", maximalValue));

        System.out.println("Test9: Search Maximal value - Finished\n");
    }

    @Test
    public void testArrayUtilsG1() {
        System.out.println("Test10: Find All Prime Numbers - Started");
        int[] arr = new int[]{7, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
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
        PlainArray array1 = new Array(arr);

        int[] resultFibonacci = ArrayUtils.findAllFibonacci(array1);
        System.out.println(String.format("fibonacci values: %s", Arrays.toString(resultFibonacci)));
        System.out.println("Test10: Find All Fibonacci Numbers - Finished\n");
    }


}
