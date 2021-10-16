package by.epamtc.bakulin.task03.utils;

import by.epamtc.bakulin.task03.entity.PlainArray;

public class ArrayUtils {

    /**
     * Алгоритм сортировки массива "Сортировка Пузырьком"
     * По возрастанию
     * Временная сложность О(n^2)
     * @param arrayToSort сортируемый массив
     */
    public static void sortArrayBubbleAsc(PlainArray arrayToSort) {
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

    /**
     * Алгоритм сортировки массива "Сортировка Пузырьком"
     * По убыванию
     * Временная сложность О(n^2)
     * @param arrayToSort сортируемый массив
     */
    public static void sortArrayBubbleDesc(PlainArray arrayToSort) {
        int[] array = arrayToSort.getArrayData();
        for (int i = 0; i <= (array.length - 1); i++) {
            for (int j = (array.length - 1); j > i; j--) {
                if (array[j] > array[j - 1]) {
                    int buffer = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = buffer;
                }
            }
        }
        arrayToSort.setArrayData(array);
    }

    /**
     * Алгоритм сортировки массива "Сортировка Выбором"
     * По возрастанию
     * Временная сложность О(n^2)
     * @param arrayToSort сортируемый массив
     */
    public static void sortArraySelectionAsc(PlainArray arrayToSort) {
        int[] array = arrayToSort.getArrayData();

        for (int step = 0; step < array.length; step++) {
            int minValueIndex = selectionSortMinValueSearcher(array, step);

            int tempValue = array[step];
            array[step] = array[minValueIndex];

            array[minValueIndex] = tempValue;
        }
        arrayToSort.setArrayData(array);
    }

    /**
     * Алгоритм сортировки массива "Сортировка Выбором"
     * По убыванию
     * Временная сложность О(n^2)
     * @param arrayToSort сортируемый массив
     */
    public static void sortArraySelectionDesc(PlainArray arrayToSort) {
        int[] array = arrayToSort.getArrayData();

        for (int step = 0; step < array.length; step++) {
            int minValueIndex = selectionSortMaxValueSearcher(array, step);

            int tempValue = array[step];
            array[step] = array[minValueIndex];

            array[minValueIndex] = tempValue;
        }
        arrayToSort.setArrayData(array);
    }

    /**
     * Алгоритм сортировки массива "Быстрая сортировка"
     * По возрастанию
     * Временная сложность О(n log(n))
     * @param arrayToSort сортируемый массив
     */
    public static void sortArrayQuickAsc(PlainArray arrayToSort) {
        int[] array = arrayToSort.getArrayData();
        int leftBorder = 0;
        int rightBorder = (array.length - 1);
        quickSortManage(array, leftBorder, rightBorder);
        arrayToSort.setArrayData(array);
    }
    /**
     * Алгоритм сортировки массива "Быстрая сортировка"
     * По убыванию
     * Временная сложность О(n log(n))
     * @param arrayToSort сортируемый массив
     */
    public static void sortArrayQuickDesc(PlainArray arrayToSort) {
        int[] array = arrayToSort.getArrayData();
        int leftBorder = 0;
        int rightBorder = (array.length - 1);
        quickSortManageDesc(array, leftBorder, rightBorder);
        arrayToSort.setArrayData(array);
    }

    private static void quickSortManage(int[] array, int leftBorder, int rightBorder) {
        if(leftBorder < rightBorder) {
            int divideIndex = quickSortArrayDivider(array, leftBorder, rightBorder);

            quickSortManage(array, leftBorder, (divideIndex - 1));
            quickSortManage(array, divideIndex, rightBorder);
        }
    }

    private static void quickSortManageDesc(int[] array, int leftBorder, int rightBorder) {
        if(leftBorder < rightBorder) {
            int divideIndex = quickSortArrayDividerDesc(array, leftBorder, rightBorder);

            quickSortManageDesc(array, leftBorder, (divideIndex - 1));
            quickSortManageDesc(array, divideIndex, rightBorder);
        }
    }


    private static int quickSortArrayDivider(int[] incomingArray, int leftBorder, int rightBorder) {
        int divideIndex = incomingArray[leftBorder + (rightBorder - leftBorder) / 2];

        while (leftBorder <= rightBorder) {
            while (incomingArray[leftBorder] < divideIndex) {
                leftBorder++;
            }
            while ((incomingArray[rightBorder] > divideIndex)) {
                rightBorder--;
            }
            if (leftBorder <= rightBorder) {
                quickSortArraySwapper(incomingArray, rightBorder, leftBorder);

                leftBorder++;
                rightBorder--;
            }
        }
        return leftBorder;
    }

    private static int quickSortArrayDividerDesc(int[] incomingArray, int leftBorder, int rightBorder) {
        int divideIndex = incomingArray[leftBorder + (rightBorder - leftBorder) / 2];

        while (leftBorder <= rightBorder) {
            while (incomingArray[leftBorder] > divideIndex) {
                leftBorder++;
            }
            while ((incomingArray[rightBorder] < divideIndex)) {
                rightBorder--;
            }
            if (leftBorder <= rightBorder) {
                quickSortArraySwapperDesc(incomingArray, rightBorder, leftBorder);

                leftBorder++;
                rightBorder--;
            }
        }
        return leftBorder;
    }

    private static void quickSortArraySwapper(int[] incomingArray, int swapIndex1, int swapIndex2) {
        int temp = incomingArray[swapIndex1];

        incomingArray[swapIndex1] = incomingArray[swapIndex2];
        incomingArray[swapIndex2] = temp;
    }

    private static void quickSortArraySwapperDesc(int[] incomingArray, int swapIndex1, int swapIndex2) {
        int temp = incomingArray[swapIndex2];

        incomingArray[swapIndex2] = incomingArray[swapIndex1];
        incomingArray[swapIndex1] = temp;
    }

    private static int selectionSortMinValueSearcher(int[] array, int startIndex) {
        int minimalValueIndex = startIndex;
        int minimalValue = array[startIndex];

        for (int i = startIndex + 1; i < array.length; i++) {
            if (array[i] < minimalValue) {
                minimalValue = array[i];
                minimalValueIndex = i;
            }
        }
        return minimalValueIndex;
    }
    private static int selectionSortMaxValueSearcher(int[] array, int startIndex) {
        int maxValueIndex = startIndex;
        int maxValue = array[startIndex];

        for (int i = (startIndex + 1); i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }
}
