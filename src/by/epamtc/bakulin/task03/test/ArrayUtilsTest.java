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
        System.out.println("Test1: Bubble sort Descending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArrayBubbleDesc(array1);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test1: Bubble sort - Finished\n");
    }

    @Test
    public void testArrayUtilsB1() {
        System.out.println("Test2: Selection sort Ascending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArraySelectionAsc(array1);
        System.out.println(String.format("Sorted Array Ascending: %s", array1.toString()));

        System.out.println("Test2: Selection sort - Finished\n");
    }

    @Test
    public void testArrayUtilsB2() {
        System.out.println("Test2: Selection sort Descending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArraySelectionDesc(array1);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test2: Selection sort - Finished\n");
    }

    @Test
    public void testArrayUtilsC1() {
        System.out.println("Test3: Quick sort Ascending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArrayQuickAsc(array1);
        System.out.println(String.format("Sorted Array Ascending: %s", array1.toString()));

        System.out.println("Test3: Quick sort - Finished\n");
    }

    @Test
    public void testArrayUtilsC2() {
        System.out.println("Test3: Quick sort Descending - Started");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArrayQuickDesc(array1);
        System.out.println(String.format("Sorted Array Descending: %s", array1.toString()));

        System.out.println("Test3: Quick sort - Finished\n");
    }

}
