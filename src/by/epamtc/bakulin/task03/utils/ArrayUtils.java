package by.epamtc.bakulin.task03.utils;

import by.epamtc.bakulin.task03.entity.Array;
import by.epamtc.bakulin.task03.entity.DynamicArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ArrayUtils {

    public static <E extends Number & Comparable> void sort(Array<E> array, SortType sortType) {
        sort(array, sortType, true);
    }

    public static <E extends Number & Comparable> void sort(Array<E> array, SortType sortType, boolean isAscending) {
        if (sortType == SortType.BUBBLE) {
            bubbleSort(array, isAscending);
        }
        if (sortType == SortType.SELECTION) {
            selectionSort(array, isAscending);
        }
        if (sortType == SortType.QUICK) {
            quickSort(array, isAscending);
        }
    }

    /**
     * Алгоритм поиска элемента в массиве "Бинарный поиск"
     * Перегруженный метод для сортированного массива
     *
     * @param searchValue искомое значение
     * @param targetArray целевой массив
     */
    public static <E extends Number & Comparable> int binarySearch(E searchValue, Array<E> targetArray) {
        return binarySearch(searchValue, targetArray, false);
    }

    /**
     * Алгоритм поиска элемента в массиве "Бинарный поиск"
     * Перегруженный метод для не сортированного массива
     *
     * @param searchValue искомое значение
     * @param targetArray целевой массив
     */
    public static <E extends Number & Comparable> int binarySearch(E searchValue, Array<E> targetArray, boolean isSorted) {
        if (!isSorted) {
            sort(targetArray, SortType.QUICK);
        }
        E[] unboxedArray = targetArray.getArrayData();
        int leftBorder = 0;
        int rightBorder = unboxedArray.length - 1;

        while (leftBorder <= rightBorder) {
            int center = leftBorder + (rightBorder - leftBorder) / 2;

            if (unboxedArray[center].compareTo(searchValue) == 0) {
                return center;
            }

            if (unboxedArray[center].compareTo(searchValue) > 0) {
                rightBorder = center - 1;
            }
            if (unboxedArray[center].compareTo(searchValue) < 0) {
                leftBorder = center + 1;
            }
        }
        return -1;
    }

    /**
     * Выполняет реверс элементов массива
     *
     * @param array целевой массив
     * @return отраженный массив
     */
    public static <E extends Number & Comparable> void arrayReverse(Array<E> array) {
        E[] targetArray = array.getArrayData();
        int reverseIndex = 0;

        for (int i = 0; i < targetArray.length / 2; i++) {
            E cache = targetArray[i];
            reverseIndex = targetArray.length - 1 - i;
            targetArray[i] = targetArray[reverseIndex];
            targetArray[reverseIndex] = cache;
        }
        array.setArrayData(targetArray);

    }

    /**
     * Осуществляет поиск всех простых чисел в текущем массиве
     *
     * @param targetArray целевой массив
     * @return массив простых чисел
     */
    public static Array<Integer> findAllPrimes(Array<Integer> targetArray) {
        Array<Integer> primes = new DynamicArray<>();
        for (int i = 0; i < targetArray.size(); i++) {
            Integer value = targetArray.get(i);
            if (isPrimeNumeric(value)) {
                primes.add(value);
            }
        }
        return primes;
    }

    /**
     * Поиск минимального значения в массиве.
     *
     * @param targetArray целевой массив
     * @return минимальное значение в массиве
     */
    public static <E extends Number & Comparable> E findMinimalValue(Array<E> targetArray) {
        E result = targetArray.get(0);

        for (int i = 0; i < targetArray.size(); i++) {
            E target = targetArray.get(i);

            if (result.compareTo(target) > 0) {
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
    public static <E extends Number & Comparable> E findMaximalValue(Array<E> targetArray) {
        E result = targetArray.get(0);

        for (int i = 0; i < targetArray.size(); i++) {
            E target = targetArray.get(i);

            if (result.compareTo(target) < 0) {
                result = target;
            }
        }
        return result;
    }

    /**
     * Осуществляет поиск всех чисел Фибоначчи в текущем массиве
     *
     * @param targetArray целевой массив
     * @return массив чисел Фибоначчи в текущем массиве
     */
    public static Array<Integer> findAllFibonacci(Array<Integer> targetArray) {
        Array<Integer> result = new DynamicArray<>();
        Integer maxValue = findMaximalValue(targetArray);
        Integer[] fibonacciArray = populateFibonacciArray(maxValue);

        for (int i = 0; i < targetArray.size(); i++) {
            Integer targetValue = targetArray.get(i);

            for (int j = 0; j < fibonacciArray.length; j++) {
                if (targetValue != fibonacciArray[j]) {
                    continue;
                }
                if (targetValue == fibonacciArray[j]) {
                    result.add(targetValue);
                    j = 0;
                }
                if (targetValue != fibonacciArray[(fibonacciArray.length - 1)]) {
                    j = 0;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Выполняет поиск уникальных элементов по критерию:
     * Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр
     *
     * @param targetArray целевой массив
     * @return Array
     */
    public static Array<Integer> findAllUniqueValues(Array<Integer> targetArray) {
        Array<Integer> result = new DynamicArray<>();

        for (int i = 0; i < targetArray.size(); i++) {
            int value = targetArray.get(i);
            int[] dismemberedValue = dismemberNumeric(value);

            if (isNumericOrderUnique(dismemberedValue)) {
                result.add(value);
            }
        }
        return result;
    }

    public static void populateIntegerArrayRandom(int incrementC, int baseNumber, int arraySize, Array<Integer> targetArray) {
        int primeValueA = 31;
        int naturalModule = 127;
        IntegerRandomGenerator randomGenerator = new IntegerRandomGenerator(primeValueA, incrementC, naturalModule, baseNumber);
        for (int i = 0; i < arraySize; i++) {
            targetArray.add(randomGenerator.calculateRandom());
        }
    }

    /**
     * Создает массив Array, заполненный числами из файла.txt
     *
     * @param path      путь к файлу
     * @param lineIndex номер строки в текстовом документе, с которой будут считаны данные
     * @return новый Array, заполненный числами из файла
     */
    public static Array<Integer> populateIntegerArrayFromTxtFile(String path, int lineIndex) {
        Array<Integer> array = new DynamicArray<>();
        String stringData = getDataFromFile(path).get(lineIndex);
        int[] integerArray = parseStringToIntegerArray(stringData);

        for (int i = 0; i < integerArray.length; i++) {
            array.add(integerArray[i]);
        }
        return array;
    }

    /**
     * Заполняет существующий массив числами из файла.txt
     *
     * @param targetArray целевой массив
     * @param path        путь к файлу
     * @param lineIndex   номер строки в текстовом документе, с которой будут считаны данные
     */
    public static void populateIntegerArrayFromTxtFile(Array targetArray, String path, int lineIndex) {
        String stringData = getDataFromFile(path).get(lineIndex);
        int[] integerArray = parseStringToIntegerArray(stringData);

        for (int i = 0; i < integerArray.length; i++) {
            targetArray.add(integerArray[i]);
        }
    }

    /**
     * Алгоритм сортировки массива "Сортировка Пузырьком"
     *
     * @param array       сортируемый массив
     * @param isAscending boolean аргумент true, если сортировка по возрастанию
     */
    private static <E extends Number & Comparable> void bubbleSort(Array<E> array, boolean isAscending) {
        E[] elementArray = array.getArrayData();
        for (int i = elementArray.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isAscending) {
                    if (elementArray[j].compareTo(elementArray[j + 1]) > 0) {
                        E buffer = elementArray[j];
                        elementArray[j] = elementArray[j + 1];
                        elementArray[j + 1] = buffer;
                    }
                } else {
                    if (elementArray[j].compareTo(elementArray[j + 1]) < 0) {
                        E buffer = elementArray[j];
                        elementArray[j] = elementArray[j + 1];
                        elementArray[j + 1] = buffer;
                    }
                }
            }
        }
        array.setArrayData(elementArray);
    }

    /**
     * Алгоритм сортировки массива "Сортировка Выбором"
     *
     * @param array       сортируемый массив
     * @param isAscending boolean аргумент true, если сортировка по возрастанию
     */
    private static <E extends Number & Comparable> void selectionSort(Array<E> array, boolean isAscending) {
        E[] elementArray = array.getArrayData();
        for (int step = 0; step < elementArray.length; step++) {
            if (isAscending) {
                int minValueIndex = selectionSortIndex(elementArray, step, isAscending);
                E tempValue = elementArray[step];
                elementArray[step] = elementArray[minValueIndex];
                elementArray[minValueIndex] = tempValue;
            }
            if (!isAscending) {
                int maxValueIndex = selectionSortIndex(elementArray, step, isAscending);
                E tempValue = elementArray[step];
                elementArray[step] = elementArray[maxValueIndex];
                elementArray[maxValueIndex] = tempValue;
            }

        }
        array.setArrayData(elementArray);
    }

    private static <E extends Number & Comparable> int selectionSortIndex(E[] targetArray, int startIndex, boolean isAscending) {
        int valueIndex = startIndex;
        E value = targetArray[startIndex];

        for (int i = (startIndex + 1); i < targetArray.length; i++) {
            if (isAscending) {
                if (targetArray[i].compareTo(value) < 0) {
                    value = targetArray[i];
                    valueIndex = i;
                }
            }
            if (!isAscending) {
                if (targetArray[i].compareTo(valueIndex) > 0) {
                    value = targetArray[i];
                    valueIndex = i;
                }
            }
        }
        return valueIndex;
    }

    /**
     * Алгоритм сортировки массива "Быстрая сортировка"
     *
     * @param array       сортируемый массив
     * @param isAscending boolean аргумент true, если сортировка по возрастанию
     */
    private static <E extends Number & Comparable> void quickSort(Array<E> array, boolean isAscending) {
        E[] elementArray = array.getArrayData();
        int leftBorder = 0;
        int rightBorder = elementArray.length - 1;
        quickSortManage(elementArray, leftBorder, rightBorder, isAscending);
        array.setArrayData(elementArray);
    }

    private static <E extends Number & Comparable> void quickSortManage(E[] targetArray, int leftBorder, int rightBorder, boolean isAscending) {
        if (leftBorder < rightBorder) {
            int divideIndex = quickSortArraySeparator(targetArray, leftBorder, rightBorder, isAscending);
            quickSortManage(targetArray, leftBorder, (divideIndex - 1), isAscending);
            quickSortManage(targetArray, divideIndex, rightBorder, isAscending);
        }
    }

    private static <E extends Number & Comparable> int quickSortArraySeparator(E[] targetArray, int leftBorder, int rightBorder, boolean isAscending) {
        E divideElement = targetArray[leftBorder + (rightBorder - leftBorder) / 2];
        while (leftBorder <= rightBorder) {
            if (isAscending) {
                while (targetArray[leftBorder].compareTo(divideElement) < 0) {
                    leftBorder++;
                }
                while ((targetArray[rightBorder].compareTo(divideElement)) > 0) {
                    rightBorder--;
                }
            }
            if (!isAscending) {
                while (targetArray[leftBorder].compareTo(divideElement) > 0) {
                    leftBorder++;
                }
                while ((targetArray[rightBorder].compareTo(divideElement)) < 0) {
                    rightBorder--;
                }
            }
            if (leftBorder <= rightBorder) {
                quickSortArraySwapper(targetArray, rightBorder, leftBorder);
                leftBorder++;
                rightBorder--;
            }
        }
        return leftBorder;
    }

    private static <E extends Number & Comparable> void quickSortArraySwapper(E[] targetArray, int swapIndex1, int swapIndex2) {
        E temp = targetArray[swapIndex1];
        targetArray[swapIndex1] = targetArray[swapIndex2];
        targetArray[swapIndex2] = temp;
    }

    private static int[] parseStringToIntegerArray(String targetValue) {
        String[] strings = targetValue.replaceAll("\\[", "").replaceAll(" ", "").replaceAll("\\]", "").split(",");
        int[] result = new int[strings.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.valueOf(strings[i]);
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

    private static Integer[] populateFibonacciArray(Integer n) {
        Integer[] fibonacci = new Integer[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }

    private static <E extends Number & Comparable> boolean isPrimeNumeric(Integer targetValue) {
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
}
