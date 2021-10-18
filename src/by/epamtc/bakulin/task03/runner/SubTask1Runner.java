package by.epamtc.bakulin.task03.runner;

import by.epamtc.bakulin.task03.entity.Array;
import by.epamtc.bakulin.task03.entity.PlainArray;
import by.epamtc.bakulin.task03.utils.ArrayUtils;

import java.util.Arrays;

import static by.epamtc.bakulin.task03.utils.ConsoleUtils.*;

public class SubTask1Runner {
    public static void main(String[] args) {
        printConsoleMessage("Task03, SubTask01:\n" +
                "Создание типа Array, который является классом оболочкой над массивом целого типа.\n" +
                "В данном типе должны быть реализованы конструкторы (позволяющие несколькими способами создавать объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(), equals(), hasCode()).\n" +
                "Программа должна иметь следующие возможности:\n" +
                "1. Сортировать массив тремя способами.\n" +
                "2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска).\n" +
                "3. Нахождение максимального и минимального элемента массива.\n" +
                "4. Получить все простые числа находящиеся в массиве.\n" +
                "5. Получить все числа Фибонначчи находящиеся в массиве.\n" +
                "6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.\n" +
                "7. Заполнения элементов массива и с консоли, и с файла и с помощью генерации случайных чисел.");
        printConsoleMessage("[STARTED]:\n");
        //run1();
        //run2();
        run3();
        printConsoleMessage("[FINISHED];\n");
    }
    public static void run1() {
        printConsoleMessage("\t[START]: RUN1\n");
        printConsoleMessage("\t[ЗАПОЛНЕНИЕ МАССИВА ИЗ КОНСОЛИ]:\n");
        printConsoleMessage("\t[ВВЕДИТЕ РАЗМЕР МАССИВА]:\n");
        int arrayLength = enterPositiveInteger("arrayLength");
        if (arrayLength > 0) {
            printConsoleMessage(String.format("\t[ACCEPTED]: arrayLength = %d\n", arrayLength));
        }
        printConsoleMessage("\t[ЗАПОЛНИТЕ МАССИВ]:\n");
        PlainArray array1 = populateIntegerArray(arrayLength);
        printConsoleMessage(String.format("\t[ТЕКУЩИЙ МАССИВ]: %s\n", array1));

        int minValue = ArrayUtils.findMinimalValue(array1);
        printConsoleMessage(String.format("\t[МИНИМАЛЬНОЕ ЧИСЛО В МАССИВЕ]: value = %d\n", minValue));

        int maxValue = ArrayUtils.findMaximalValue(array1);
        printConsoleMessage(String.format("\t[МАКСИМАЛЬНОЕ ЧИСЛО В МАССИВЕ]: value = %d\n", maxValue));

        int[] primes = ArrayUtils.findAllPrimes(array1);
        printConsoleMessage(String.format("\t[ПРОСТЫЕ ЧИСЛА В МАССИВЕ]: value = %s\n", Arrays.toString(primes)));

        int[] fibonacci = ArrayUtils.findAllFibonacci(array1);
        printConsoleMessage(String.format("\t[ЧИСЛА Фибоначчи В МАССИВЕ]: value = %s\n", Arrays.toString(fibonacci)));

        PlainArray uniqueValues = ArrayUtils.findAllUniqueValues(array1);
        printConsoleMessage(String.format("\t[УНИКАЛЬНЫЕ 3-ЗНАЧНЫЕ ЧИСЛА В МАССИВЕ]: uniqueValues = %s\n", uniqueValues));

        printConsoleMessage("\t[ВВЕДИТЕ ИСКОМОЕ ЧИСЛО]:\n");
        int searchValue = enterInteger("searchValue");
        int result = ArrayUtils.binarySearch(searchValue, array1);
        printConsoleMessage(String.format("\t[ОТСОРТИРОВАННЫЙ МАССИВ]: %s\n", array1));
        printConsoleMessage(String.format("\t[ПОИСК]: 'БИНАРНЫЙ' index = %d\n", result));

        ArrayUtils.sortArrayQuickAsc(array1);
        printConsoleMessage(String.format("\t[СОРТИРОВКА МАССИВА ПО ВОЗРАСТАНИЮ]: 'БЫСТРАЯ' %s\n", array1));

        ArrayUtils.sortArrayQuickDesc(array1);
        printConsoleMessage(String.format("\t[СОРТИРОВКА МАССИВА ПО УБЫВАНИЮ]: 'БЫСТРАЯ' %s\n", array1));

        printConsoleMessage("\t[FINISH]: RUN1\n");
    }
    public static void run2() {
        printConsoleMessage("\t[START]: RUN2\n");
        printConsoleMessage("\t[ЗАПОЛНЕНИЕ МАССИВА НА ОСНОВЕ СУЩЕСТВУЮЩЕГО МАССИВА]: STARTED\n");
        int[] targetArray = new int[] {23,114,65,78,235,45,69,187,11,3,4};
        printConsoleMessage(String.format("\t[СУЩЕСТВУЮЩИЙ МАССИВ]: %s\n", Arrays.toString(targetArray)));

        PlainArray array1 = new Array(targetArray);
        printConsoleMessage(String.format("\t[ТЕКУЩИЙ МАССИВ]: %s\n", array1));

        int minValue = ArrayUtils.findMinimalValue(array1);
        printConsoleMessage(String.format("\t[МИНИМАЛЬНОЕ ЧИСЛО В МАССИВЕ]: value = %d\n", minValue));

        int maxValue = ArrayUtils.findMaximalValue(array1);
        printConsoleMessage(String.format("\t[МАКСИМАЛЬНОЕ ЧИСЛО В МАССИВЕ]: value = %d\n", maxValue));

        int[] primes = ArrayUtils.findAllPrimes(array1);
        printConsoleMessage(String.format("\t[ПРОСТЫЕ ЧИСЛА В МАССИВЕ]: value = %s\n", Arrays.toString(primes)));

        int[] fibonacci = ArrayUtils.findAllFibonacci(array1);
        printConsoleMessage(String.format("\t[ЧИСЛА Фибоначчи В МАССИВЕ]: value = %s\n", Arrays.toString(fibonacci)));

        PlainArray uniqueValues = ArrayUtils.findAllUniqueValues(array1);
        printConsoleMessage(String.format("\t[УНИКАЛЬНЫЕ 3-ЗНАЧНЫЕ ЧИСЛА В МАССИВЕ]: uniqueValues = %s\n", uniqueValues));

        printConsoleMessage("\t[ВВЕДИТЕ ИСКОМОЕ ЧИСЛО]:\n");
        int searchValue = enterInteger("searchValue");
        int result = ArrayUtils.binarySearch(searchValue, array1);
        printConsoleMessage(String.format("\t[ОТСОРТИРОВАННЫЙ МАССИВ]: %s\n", array1));
        printConsoleMessage(String.format("\t[ПОИСК]: 'БИНАРНЫЙ' index = %d\n", result));

        ArrayUtils.sortArraySelectionAsc(array1);
        printConsoleMessage(String.format("\t[СОРТИРОВКА МАССИВА ПО ВОЗРАСТАНИЮ]: 'ВЫБОРОМ' %s\n", array1));

        ArrayUtils.sortArraySelectionDesc(array1);
        printConsoleMessage(String.format("\t[СОРТИРОВКА МАССИВА ПО УБЫВАНИЮ]: 'ВЫБОРОМ' %s\n", array1));

        printConsoleMessage("\t[FINISH]: RUN2\n");
    }

    public static void run3() {
        printConsoleMessage("\t[START]: RUN3\n");
        printConsoleMessage("\t[ЗАПОЛНЕНИЕ МАССИВА СЛУЧАЙНЫМИ ЧИСЛАМИ]: STARTED\n");
        PlainArray array1 = new Array();
        printConsoleMessage(String.format("\t[ТЕКУЩИЙ МАССИВ]: %s\n", array1));

        ArrayUtils.populateIntegerArrayRandom(51, 5, 10, array1);
        printConsoleMessage(String.format("\t[ЗАПОЛНЕННЫЙ МАССИВ]: %s\n", array1));

        ArrayUtils.populateIntegerArrayRandom(45, 5, 10, array1);
        printConsoleMessage(String.format("\t[ЗАПОЛНЕННЫЙ МАССИВ]: %s\n", array1));
        printConsoleMessage("\t[FINISH]: RUN3\n");
    }
}
