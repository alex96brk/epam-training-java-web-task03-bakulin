package by.epamtc.bakulin.task03.utils;

import by.epamtc.bakulin.task03.entity.DynamicArray;
import by.epamtc.bakulin.task03.entity.Array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IntegerArrayUtils {

    /**
     * Алгоритм сортировки массива "Сортировка Пузырьком"
     * По возрастанию
     *
     * @param arrayToSort сортируемый массив
     */
    public static void sortArrayBubbleAsc(Array arrayToSort) {
        Integer[] array = (Integer[]) arrayToSort.getArrayData();
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
    public static void sortArrayBubbleDesc(Array arrayToSort) {
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
    public static void sortArraySelectionAsc(Array arrayToSort) {
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
    public static void sortArraySelectionDesc(Array arrayToSort) {
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
    public static void sortArrayQuickAsc(Array arrayToSort) {
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
    public static void sortArrayQuickDesc(Array arrayToSort) {
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
    public static int binarySearch(int searchValue, Array targetArray) {
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
    public static int findMinimalValue(Array targetArray) {
        int result = targetArray.get(0);

        for (int i = 0; i < targetArray.size(); i++) {
            int target = targetArray.get(i);

            if (result > target) {
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
    public static int findMaximalValue(Array targetArray) {
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
    public static int[] findAllPrimes(Array targetArray) {
        Array primes = new DynamicArray();
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
    public static int[] findAllFibonacci(Array targetArray) {
        int[] result = new int[0];
        int[] unboxedArray = targetArray.getArrayData();
        int maxValue = findMaximalValue(unboxedArray);
        Array cache = new DynamicArray();

        int[] fibonacciArray = populateFibonacciArray(maxValue);

        for (int i = 0; i < unboxedArray.length; i++) {
            int targetValue = unboxedArray[i];

            for (int j = 0; j < fibonacciArray.length; j++) {
                if (targetValue != fibonacciArray[j]) {
                    continue;
                }
                if (targetValue == fibonacciArray[j]) {
                    cache.add(targetValue);
                    j = 0;
                }
                if (targetValue != fibonacciArray[(fibonacciArray.length - 1)]) {
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
    public static void arrayReverse(Array array) {
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
    public static Array findAllUniqueValues(Array targetArray) {
        Array result = new DynamicArray();

        for (int i = 0; i < targetArray.size(); i++) {
            int value = targetArray.get(i);
            int[] dismemberedValue = dismemberNumeric(value);

            if (isNumericOrderUnique(dismemberedValue)) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Заполняет указанный массив случайными числами
     * На основе линейного конгруэнтного метода генерации случайных чисел
     *
     * @param incrementC  приращение функции
     * @param baseNumber  начальное значение для генерации случайных чисел
     * @param arraySize   количество генерируемых случайных чисел (arraySize - 1)
     * @param targetArray целевой массив для заполнения
     */
    public static void populateIntegerArrayRandom(int incrementC, int baseNumber, int arraySize, Array targetArray) {
        int primeValueA = 31;
        int naturalModule = 127;
        PlainRandomGenerator randomGenerator = new PlainRandomGenerator(primeValueA, incrementC, naturalModule, baseNumber);
        for (int i = 0; i < arraySize; i++) {
            targetArray.add(randomGenerator.calculateRandom());
        }

    }

    /**
     * Создает массив PlainArray, заполненный числами из файла.txt
     * @param path путь к файлу
     * @param lineIndex номер строки в текстовом документе, с которой будут считаны данные
     * @return новый PlainArray, заполненный числами из файла
     */
    public static Array populateIntegerArrayFromTxtFile(String path, int lineIndex) {
        Array array = new DynamicArray();
        String stringData = getDataFromFile(path).get(lineIndex);
        int[] integerArray = parseStringToIntegerArray(stringData);

        for (int i = 0; i < integerArray.length; i++) {
            array.add(integerArray[i]);
        }
        return array;
    }

    /**
     * Заполняет существующий массив числами из файла.txt
     * @param targetArray целевой массив
     * @param path путь к файлу
     * @param lineIndex номер строки в текстовом документе, с которой будут считаны данные
     */
    public static void populateIntegerArrayFromTxtFile(Array targetArray, String path, int lineIndex) {
        String stringData = getDataFromFile(path).get(lineIndex);
        int[] integerArray = parseStringToIntegerArray(stringData);

        for (int i = 0; i < integerArray.length; i++) {
            targetArray.add(integerArray[i]);
        }
    }

    private static int[] parseStringToIntegerArray(String targetValue) {
        String[] strings = targetValue.replaceAll("\\[", "").replaceAll(" ", "").replaceAll("\\]", "").split(",");
        int[] result = new int[strings.length];

        for(int i = 0; i < result.length; i++) {
            result[i] = Integer.valueOf(strings[i]);
        }
        return result;
    }


    private static List<String> getDataFromFile(String path) {
        BufferedReader bufferedReader = null;
        List<String> data = new ArrayList<>();
        try {
            File textFile = new File(path);
            if (!textFile.exists()) {
                throw new FileNotFoundException(String.format("File not found: %s", path));
            }
            bufferedReader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return data;
    }

    /**
     * Проверяет взаимное равенство элементов массива
     *
     * @param numericFrame массив, состоящий из чисел-элементов n-значного числа
     * @return {@code true} если все элементы массива уникальны
     */
    private static boolean isNumericOrderUnique(int[] numericFrame) {
        boolean result = false;
        int counter = 0;

        for (int i = 0; i < numericFrame.length; i++) {
            for (int j = i + 1; j < numericFrame.length; j++) {
                if (numericFrame[i] != numericFrame[j]) {
                    counter++;
                    continue;
                }
                if (numericFrame[i] == numericFrame[j]) {
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
     *
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
