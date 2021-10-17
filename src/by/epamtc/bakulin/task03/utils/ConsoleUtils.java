package by.epamtc.bakulin.task03.utils;

import java.util.Scanner;

public class ConsoleUtils {
    private static Scanner sc = new Scanner(System.in);

    public static final String ERROR_INCORRECT_VALUE_ENTER = "\t[ERROR]: Incorrect value. Enter: ";
    public static final String ENTER_INTEGER = "\t[enter integer]: %s = ";
    public static final String ENTER_LONG = "\t[enter long]: %s = ";
    public static final String ENTER_DOUBLE = "\t[enter double]: %s = ";
    public static final String ENTER_STRING = "\t[enter string]: %s = ";

    public static int enterInteger(String parameterName) {
        Integer inputValue = null;
        printConsoleMessage(ENTER_INTEGER, parameterName);

        do {
            while (!sc.hasNextInt()) {
                printConsoleMessage(ERROR_INCORRECT_VALUE_ENTER + "integer");
                printConsoleMessage(String.format(ENTER_INTEGER, parameterName));

                sc.next();
            }
            inputValue = sc.nextInt();

        } while (inputValue == null);
        return inputValue;
    }

    public static int enterPositiveInteger(String parameterName) {
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

    public static long enterLong(String parameterName) {
        Long inputValue = null;
        printConsoleMessage(ENTER_LONG, parameterName);

        do {
            while (!sc.hasNextInt()) {
                printConsoleMessage(ERROR_INCORRECT_VALUE_ENTER + "long");
                printConsoleMessage(String.format(ENTER_LONG, parameterName));

                sc.next();
            }
            inputValue = sc.nextLong();

        } while (inputValue == null);
        return inputValue;
    }

    public static long enterPositiveLong(String parameterName) {
        Long inputValue = null;
        printConsoleMessage(ENTER_LONG, parameterName);

        do {
            while (!sc.hasNextInt()) {
                printConsoleMessage(ERROR_INCORRECT_VALUE_ENTER + "long");
                printConsoleMessage(String.format(ENTER_LONG, parameterName));

                sc.next();
            }
            inputValue = sc.nextLong();
            if(inputValue < 0) {
                inputValue = null;
                printConsoleMessage(ERROR_INCORRECT_VALUE_ENTER + "positive long");
                printConsoleMessage(String.format(ENTER_LONG, parameterName));
                continue;
            }

        } while (inputValue == null);
        return inputValue;
    }

    public static double enterDouble(String parameterName) {
        Double inputValue = null;
        printConsoleMessage(ENTER_DOUBLE, parameterName);

        do {
            while (!sc.hasNextDouble()) {
                printConsoleMessage(ERROR_INCORRECT_VALUE_ENTER + "double");
                printConsoleMessage(String.format(ENTER_DOUBLE, parameterName));

                sc.next();
            }
            inputValue = sc.nextDouble();

        } while (inputValue == null);
        return inputValue;
    }

    public static double enterPositiveDouble(String parameterName) {
        Double inputValue = null;
        printConsoleMessage(ENTER_DOUBLE, parameterName);

        do {
            while (!sc.hasNextDouble()) {
                printConsoleMessage(ERROR_INCORRECT_VALUE_ENTER + "double");
                printConsoleMessage(String.format(ENTER_DOUBLE, parameterName));

                sc.next();
            }
            inputValue = sc.nextDouble();
            if(inputValue < 0) {
                inputValue = null;
                printConsoleMessage(ERROR_INCORRECT_VALUE_ENTER + "positive double");
                printConsoleMessage(String.format(ENTER_DOUBLE, parameterName));
                continue;
            }


        } while (inputValue == null);
        return inputValue;
    }


    public static String enterString(String parameterName) {
        String inputValue = null;
        printConsoleMessage(ENTER_STRING, parameterName);

        do {
            while (!sc.hasNext()) {
                printConsoleMessage(ERROR_INCORRECT_VALUE_ENTER + "double");
                printConsoleMessage(String.format(ENTER_STRING, parameterName));

                sc.next();
            }
            inputValue = sc.next();


        } while (inputValue == null);
        return inputValue;
    }

    public static int[] populateIntegerArray(int arraySize) {
        int[] ints = new int[arraySize];
        printConsoleMessage(String.format("Populate integer array[] of size = %d", arraySize));
        for (int i = arraySize - 1; i >= 0; i--) {
            ints[i] = enterInteger(String.format("array[%d]", i));
        }
        return ints;
    }

    public static double[] populateDoubleArrayInRange(double leftBorder, double rightBorder, double step) {
        double arrayLengthDouble = ((rightBorder - leftBorder) / step) + 1;
        int arrayLength = (int)arrayLengthDouble;
        double[] array = new double[(int)arrayLength];

        for (int i = 0; i < arrayLength; i++, leftBorder = leftBorder + step) {
            array[i] = leftBorder;
        }
        return array;
    }

    public static void printConsoleMessage(String message, String variableParameterName) {
        System.out.print(String.format(message, variableParameterName));
    }

    public static void printConsoleMessage(String message) {
        System.out.println(message);
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
