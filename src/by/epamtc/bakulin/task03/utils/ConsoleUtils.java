package by.epamtc.bakulin.task03.utils;

import by.epamtc.bakulin.task03.entity.JaggedMatrix;
import by.epamtc.bakulin.task03.entity.SquareMatrix;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleUtils {
    private static Scanner sc = new Scanner(System.in);

    public static final String ERROR_INCORRECT_VALUE_ENTER = "\t[ERROR]: Incorrect value. Enter: ";
    public static final String ENTER_INTEGER = "\t[enter integer]: %s = ";

    public static Integer enterInteger(String parameterName) {
        Integer inputValue = null;
        printConsoleMessage(ENTER_INTEGER, parameterName);

        do {
            while (!sc.hasNextInt()) {
                printConsoleMessage(ERROR_INCORRECT_VALUE_ENTER + "integer\n");
                printConsoleMessage(String.format(ENTER_INTEGER, parameterName));

                sc.next();
            }
            inputValue = sc.nextInt();

        } while (inputValue == null);
        return inputValue;
    }

    public static Integer enterPositiveInteger(String parameterName) {
        Integer inputValue = null;
        printConsoleMessage(ENTER_INTEGER, parameterName);

        do {
            while (!sc.hasNextInt()) {
                printConsoleMessage(ERROR_INCORRECT_VALUE_ENTER + "integer");
                printConsoleMessage(String.format(ENTER_INTEGER, parameterName));

                sc.next();
            }
            inputValue = sc.nextInt();
            if(inputValue < 0) {
                inputValue = null;
                printConsoleMessage(ERROR_INCORRECT_VALUE_ENTER + "positive integer");
                printConsoleMessage(String.format(ENTER_INTEGER, parameterName));
                continue;
            }

        } while (inputValue == null);
        return inputValue;
    }

    public static Integer[] populateIntegerArray(int arraySize) {
        Integer[] ints = new Integer[arraySize];
        printConsoleMessage(String.format("\tPopulate integer array[] of size = %d\n", arraySize));
        for (int i = 0; i < arraySize; i++) {
            Integer userValue = enterInteger(String.format("array[%d]", i));
            ints[i] = userValue;
        }
        return ints;
    }

    public static <E extends Number> void printJaggedArray(SquareMatrix<E> jaggedMatrix) {
        E[][] jagged = jaggedMatrix.getMatrixData();
        for (int i = 0; i < jagged.length; i++) {
            System.out.println(Arrays.toString(jagged[i]));
        }
    }

    public static void printConsoleMessage(String message, String variableParameterName) {
        System.out.print(String.format(message, variableParameterName));
    }

    public static void printConsoleMessage(String message) {
        System.out.print(message);
    }

    public static void printConsoleMessage(int message) {
        System.out.println(message + "");
    }

    public static void printConsoleMessage(long message) {
        System.out.println(message + "");
    }

    public static void printConsoleMessage(double message) {
        System.out.println(message + "");
    }

    public static void close() {
        sc.close();
    }
}
