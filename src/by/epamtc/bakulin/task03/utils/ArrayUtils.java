package by.epamtc.bakulin.task03.utils;

import by.epamtc.bakulin.task03.entity.Array;
import by.epamtc.bakulin.task03.entity.PlainArray;

public class ArrayUtils {

    /**
     * Алгоритм сортировки массива "Сортировка Пузырьком"
     * По возрастанию
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
     *
     * @param targetArray целевой массив
     * @return минимальное значение в массиве
     */
    public static int findMinimalValue(PlainArray targetArray) {
        int result = targetArray.get(0);

        for (int i = 0; i < targetArray.size(); i++) {
            int target = targetArray.get(i);

            if(result > target) {
                result = target;
            }
        }
        return result;
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
            int target = targetArray[i];

            if (result > target) {
                result = target;
            }
        }
        return result;
    }

    /**
     * Поиск максимального значения в массиве.
     *
     * @param targetArray целевой массив
     * @return максимального значение в массиве
     */
    public static int findMaximalValue(PlainArray targetArray) {
        int result = targetArray.get(0);

        for (int i = 0; i < targetArray.size(); i++) {
            int target = targetArray.get(i);

            if (result < target) {
                result = target;
            }
        }
        return result;
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
            int target = targetArray[i];

            if (result < target) {
                result = target;
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
        PlainArray primes = new Array();
        int[] result = new int[0];

        for (int i = 0; i < targetArray.size(); i++) {
            int value = targetArray.get(i);

            if (isPrimeNumeric(value)) {
                primes.add(value);
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

    /**
     * Выполняет поиск уникальных элементов по критерию:
     * Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр
     *
     * @param targetArray целевой массив
     * @return PlainArray
     */
    public static PlainArray findAllUniqueValues(PlainArray targetArray) {
        PlainArray result = new Array();

        for (int i = 0; i < targetArray.size(); i++) {
            int value = targetArray.get(i);
            int[] dismemberedValue = dismemberNumeric(value);

            if(isNumericOrderUnique(dismemberedValue)) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Проверяет взаимное равенство элементов массива
     * @param numericFrame массив, состоящий из чисел-элементов n-значного числа
     * @return {@code true} если все элементы массива уникальны
     */
    private static boolean isNumericOrderUnique(int[] numericFrame) {
        boolean result = false;
        int counter = 0;

        for (int i = 0; i < numericFrame.length; i++) {
            for (int j = i + 1; j < numericFrame.length; j++) {
                if(numericFrame[i] != numericFrame[j]) {
                    counter++;
                    continue;
                }
                if(numericFrame[i] == numericFrame[j]) {
                    break;
                }
            }
        }
        if (counter == numericFrame.length) {
            result = true;
        }
        return result;
    }

    /**
     * Выполняет расчленение числа на единицы и помещает их в массив
     * Например 365 -> {5,6,3}
     * @param targetNumeric целевое значение
     * @return int[]
     */
    private static int[] dismemberNumeric(int targetNumeric) {
        int numericOrder = Integer.toString(targetNumeric).length();
        int[] result = new int[numericOrder];

        int cache = targetNumeric;

        for (int i = 0; i < result.length; i++) {
            result[i] = cache % 10;
            cache = (cache - result[i]) / 10;
        }
        return result;
    }

    private static int[] populateFibonacciArray(int n) {
        int[] fibonacci = new int[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
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

    private static void quickSortManage(int[] targetArray, int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) {
            int divideIndex = quickSortArraySeparator(targetArray, leftBorder, rightBorder);

            quickSortManage(targetArray, leftBorder, (divideIndex - 1));
            quickSortManage(targetArray, divideIndex, rightBorder);
        }
    }

    private static void quickSortManageDesc(int[] targetArray, int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) {
            int divideIndex = quickSortArraySeparatorDesc(targetArray, leftBorder, rightBorder);

            quickSortManageDesc(targetArray, leftBorder, (divideIndex - 1));
            quickSortManageDesc(targetArray, divideIndex, rightBorder);
        }
    }


    private static int quickSortArraySeparator(int[] targetArray, int leftBorder, int rightBorder) {
        int divideIndex = targetArray[leftBorder + (rightBorder - leftBorder) / 2];

        while (leftBorder <= rightBorder) {
            while (targetArray[leftBorder] < divideIndex) {
                leftBorder++;
            }
            while ((targetArray[rightBorder] > divideIndex)) {
                rightBorder--;
            }
            if (leftBorder <= rightBorder) {
                quickSortArraySwapper(targetArray, rightBorder, leftBorder);

                leftBorder++;
                rightBorder--;
            }
        }
        return leftBorder;
    }

    private static int quickSortArraySeparatorDesc(int[] targetArray, int leftBorder, int rightBorder) {
        int divideIndex = targetArray[leftBorder + (rightBorder - leftBorder) / 2];

        while (leftBorder <= rightBorder) {
            while (targetArray[leftBorder] > divideIndex) {
                leftBorder++;
            }
            while ((targetArray[rightBorder] < divideIndex)) {
                rightBorder--;
            }
            if (leftBorder <= rightBorder) {
                quickSortArraySwapperDesc(targetArray, rightBorder, leftBorder);

                leftBorder++;
                rightBorder--;
            }
        }
        return leftBorder;
    }

    private static void quickSortArraySwapper(int[] targetArray, int swapIndex1, int swapIndex2) {
        int temp = targetArray[swapIndex1];

        targetArray[swapIndex1] = targetArray[swapIndex2];
        targetArray[swapIndex2] = temp;
    }

    private static void quickSortArraySwapperDesc(int[] targetArray, int swapIndex1, int swapIndex2) {
        int temp = targetArray[swapIndex2];

        targetArray[swapIndex2] = targetArray[swapIndex1];
        targetArray[swapIndex1] = temp;
    }

    private static int selectionSortMinimalValue(int[] targetArray, int startIndex) {
        int minimalValueIndex = startIndex;
        int minimalValue = targetArray[startIndex];

        for (int i = (startIndex + 1); i < targetArray.length; i++) {
            if (targetArray[i] < minimalValue) {
                minimalValue = targetArray[i];
                minimalValueIndex = i;
            }
        }
        return minimalValueIndex;
    }

    private static int selectionSortMaximalValue(int[] targetArray, int startIndex) {
        int maxValueIndex = startIndex;
        int maxValue = targetArray[startIndex];

        for (int i = (startIndex + 1); i < targetArray.length; i++) {
            if (targetArray[i] > maxValue) {
                maxValue = targetArray[i];
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }
}
