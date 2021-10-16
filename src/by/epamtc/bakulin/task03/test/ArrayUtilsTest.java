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
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        PlainArray array1 = new Array(arr);
        System.out.println(String.format("Current Array: %s", array1.toString()));

        ArrayUtils.sortArrayBubble(array1);
        System.out.println(String.format("Sorted Array: %s", array1.toString()));

    }
}
