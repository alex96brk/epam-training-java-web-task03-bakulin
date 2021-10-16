package by.epamtc.bakulin.task03.utils;

import by.epamtc.bakulin.task03.entity.PlainArray;

public class ArrayUtils {

    public static void sortArrayBubble(PlainArray arrayToSort) {
        int[] array = arrayToSort.getArrayData();
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                }
            }
        }
        arrayToSort.setArrayData(array);
    }
}
