package by.epamtc.bakulin.task03.utils;

import by.epamtc.bakulin.task03.entity.Array;
import by.epamtc.bakulin.task03.entity.PlainArray;

public class ArrayUtils {

    /**
     * Алгоритм сортировки массива "Сортировка Пузырьком"
     * По возрастанию
     * Временная сложность О(n^2)
     *
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
     *
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
     *
     * @param arrayToSort сортируемый массив
     */
    public static void sortArraySelectionAsc(PlainArray arrayToSort) {
        int[] array = arrayToSort.getArrayData();

        for (int step = 0; step < array.length; step++) {
            int minValueIndex = selectionSortMinimalValue(array, step);

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
     *
     * @param arrayToSort сортируемый массив
     */
    public static void sortArraySelectionDesc(PlainArray arrayToSort) {
        int[] array = arrayToSort.getArrayData();

        for (int step = 0; step < array.length; step++) {
            int minValueIndex = selectionSortMaximalValue(array, step);

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
     *
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
     *
     * @param arrayToSort сортируемый массив
     */
    public static void sortArrayQuickDesc(PlainArray arrayToSort) {
        int[] array = arrayToSort.getArrayData();
        int leftBorder = 0;
        int rightBorder = (array.length - 1);
        quickSortManageDesc(array, leftBorder, rightBorder);
        arrayToSort.setArrayData(array);
    }

    /**
     * Алгоритм поиска элемента в массиве "Бинарный поиск"
     * <p>
     * Временная сложность О(n)
     *
     * @param searchValue искомое значение
     * @param targetArray целевой массив
     */
    public static int binarySearch(int searchValue, PlainArray targetArray) {
        sortArrayQuickAsc(targetArray);
        int[] unboxedArray = targetArray.getArrayData();

        int leftBorder = 0;
        int rightBorder = unboxedArray.length - 1;

        while (leftBorder <= rightBorder) {
            int center = leftBorder + (rightBorder - leftBorder) / 2;

            if (unboxedArray[center] == searchValue) {
                return center;
            }

            if (unboxedArray[center] > searchValue) {
                rightBorder = center - 1;
            }
            if (unboxedArray[center] < searchValue) {
                leftBorder = center + 1;
            }
        }
        return -1;
    }

    /**
     * Поиск минимального значения в массиве.
     * Основан на Быстрой сортировке по возрастанию
     *
     * @param targetArray целевой массив
     * @return минимальное значение в массиве
     */
    public static int findMinimalValue(PlainArray targetArray) {
        sortArrayQuickAsc(targetArray);
        return targetArray.get(0);
    }

    /**
     * Поиск минимального значения в примитивном массиве
     *
     * @param targetArray целевой массив
     * @return минимальное значение в массиве
     */
    public static int findMinimalValue(int[] targetArray) {
        int result = targetArray[0];
        for (int i = 0; i < targetArray.length; i++) {
            if (result > targetArray[i]) {
                result = targetArray[i];
            }

        }
        return result;
    }

    /**
     * Поиск минимального значения в массиве.
     * Основан на Быстрой сортировке по убыванию
     *
     * @param targetArray целевой массив
     * @return максимальное значение в массиве
     */
    public static int findMaximalValue(PlainArray targetArray) {
        sortArrayQuickDesc(targetArray);
        return targetArray.get(0);
    }

    /**
     * Поиск минимального значения в примитивном массиве
     *
     * @param targetArray целевой массив
     * @return минимальное значение в массиве
     */
    public static int findMaximalValue(int[] targetArray) {
        int result = targetArray[0];
        for (int i = 0; i < targetArray.length; i++) {
            if (result < targetArray[i]) {
                result = targetArray[i];
            }

        }
        return result;
    }

    /**
     * Осуществляет поиск всех простых чисел в текущем массиве
     *
     * @param targetArray целевой массив
     * @return массив простых чисел
     */
    public static int[] findAllPrimes(PlainArray targetArray) {
        int[] unboxedArray = targetArray.getArrayData();
        PlainArray primes = new Array();
        int[] result = new int[0];

        for (int i = 0; i < unboxedArray.length; i++) {
            if (isPrimeNumeric(unboxedArray[i])) {
                primes.add(unboxedArray[i]);
            }
        }
        if (!primes.isEmpty()) {
            result = primes.getArrayData();
        }
        return result;
    }

    /**
     * Осуществляет поиск всех чисел Фибоначчи в текущем массиве
     *
     * @param targetArray целевой массив
     * @return массив чисел Фибоначчи в текущем массиве
     */
    public static int[] findAllFibonacci(PlainArray targetArray) {
        int[] result = new int[0];
        int[] unboxedArray = targetArray.getArrayData();
        int maxValue = findMaximalValue(unboxedArray);
        PlainArray cache = new Array();

        int[] fibonacciArray = populateFibonacciArray(maxValue);

        for (int i = 0; i < unboxedArray.length; i++) {
            int targetValue = unboxedArray[i];

            for (int j = 0; j < fibonacciArray.length; j++) {
                if (targetValue !=fibonacciArray[j]) {
                    continue;
                }
                if (targetValue == fibonacciArray[j]) {
                    cache.add(targetValue);
                    j = 0;
                }
                if(targetValue != fibonacciArray[(fibonacciArray.length-1)]) {
                    j = 0;
                    break;
                }

            }
        }

        if (!cache.isEmpty()) {
            result = cache.getArrayData();
        }

        return result;
    }

    /**
     * Выполняет реверс значений примитивного массива
     *
     * @param targetArray целевой массив
     * @return отраженный массив
     */
    public static void arrayReverse(int[] targetArray) {
        int cache = 0;
        int reverseIndex = 0;

        for (int i = 0; i < targetArray.length / 2; i++) {
            cache = targetArray[i];
            reverseIndex = targetArray.length - 1 - i;

            targetArray[i] = targetArray[reverseIndex];
            targetArray[reverseIndex] = cache;
        }

    }

    /**
     * Выполняет реверс значений PlainArray <- Array
     *
     * @param array целевой массив
     * @return отраженный массив
     */
    public static void arrayReverse(PlainArray array) {
        int[] targetArray = array.getArrayData();
        int cache = 0;
        int reverseIndex = 0;

        for (int i = 0; i < targetArray.length / 2; i++) {
            cache = targetArray[i];
            reverseIndex = targetArray.length - 1 - i;

            targetArray[i] = targetArray[reverseIndex];
            targetArray[reverseIndex] = cache;
        }
        array.setArrayData(targetArray);

    }

    private static int[] populateFibonacciArray(int border) {
        int[] result = new int[border];

        for (int i = 0; i < border; i++) {
            result[i] = calculateFibonacci(i);
        }
        return result;
    }

    private static int calculateFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

    private static boolean isPrimeNumeric(int targetValue) {
        boolean result = true;
        int startValue = 2;

        for (int i = startValue; i < targetValue; i++) {
            if (targetValue % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static void quickSortManage(int[] array, int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) {
            int divideIndex = quickSortArraySeparator(array, leftBorder, rightBorder);

            quickSortManage(array, leftBorder, (divideIndex - 1));
            quickSortManage(array, divideIndex, rightBorder);
        }
    }

    private static void quickSortManageDesc(int[] array, int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) {
            int divideIndex = quickSortArraySeparatorDesc(array, leftBorder, rightBorder);

            quickSortManageDesc(array, leftBorder, (divideIndex - 1));
            quickSortManageDesc(array, divideIndex, rightBorder);
        }
    }


    private static int quickSortArraySeparator(int[] incomingArray, int leftBorder, int rightBorder) {
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

    private static int quickSortArraySeparatorDesc(int[] incomingArray, int leftBorder, int rightBorder) {
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

    private static int selectionSortMinimalValue(int[] array, int startIndex) {
        int minimalValueIndex = startIndex;
        int minimalValue = array[startIndex];

        for (int i = (startIndex + 1); i < array.length; i++) {
            if (array[i] < minimalValue) {
                minimalValue = array[i];
                minimalValueIndex = i;
            }
        }
        return minimalValueIndex;
    }

    private static int selectionSortMaximalValue(int[] array, int startIndex) {
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
