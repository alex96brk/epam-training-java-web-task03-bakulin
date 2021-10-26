package by.epamtc.bakulin.task03.utils;

import by.epamtc.bakulin.task03.entity.SquareMatrix;

public class JaggedMatrixUtils<E extends Number & Comparable> {

    /**
     * Генерирует пустой зубчатый массив типа Integer
     *
     * @param matrixRange размер квадратной матрицы
     * @return зубчатый массив Object[][]
     */
    public static <E extends Number> Integer[][] generateJaggedArrayInteger(int matrixRange) {
        Integer[][] result = new Integer[matrixRange][];

        for (int i = 0; i < matrixRange; i++) {
            result[i] = new Integer[matrixRange - i];

            if (i == (matrixRange - 1)) {
                result[i] = new Integer[1];
            }
        }
        return result;
    }

    /**
     * Генерирует пустой зубчатый массив типа Double
     *
     * @param matrixRange размер квадратной матрицы
     * @return зубчатый массив Object[][]
     */
    public static <E extends Number> Double[][] generateJaggedArrayDouble(int matrixRange) {
        Double[][] result = new Double[matrixRange][];

        for (int i = 0; i < matrixRange; i++) {
            result[i] = new Double[matrixRange - i];

            if (i == (matrixRange - 1)) {
                result[i] = new Double[1];
            }
        }
        return result;
    }

    /**
     * Заполняет зубчатый массив случайными числами
     *
     * @param randomStartValue начальный аргумент для генерации случайных числе
     * @param increment        инкремент функции генерации случайных чисел
     */
    public static void populateJaggedMatrixRandomInteger(SquareMatrix<Integer> matrix, int randomStartValue, int increment) {
        Integer primeA = 31;
        Integer module = 127;
        IntegerRandomGenerator randomGenerator = new IntegerRandomGenerator(primeA, increment, module, randomStartValue);
        Integer[][] matrixData = (Integer[][]) matrix.getMatrixData();
        for (int i = 0; i < matrixData.length; i++) {

            for (int j = 0; j < matrixData[i].length; j++) {
                matrixData[i][j] = randomGenerator.calculateRandom();
            }
        }
    }

    /**
     * Сортирует зубчатый массив
     * в порядке возрастания сумм элементов строки.
     *
     * @param jaggedIntegerArray целевой зубчатый массив
     */
    public static <E extends Number & Comparable> void sortJaggedArrayBySumRowsElements(SquareMatrix<E> jaggedIntegerArray) {
        E[] sums = populateSumArrayGeneric(jaggedIntegerArray);
        E[][] jagged = jaggedIntegerArray.getMatrixData();

        for (int i = 0; i < (jagged.length - 1); i++) {
            for (int j = (jagged.length - 1); j > i; j--) {
                if (sums[j].compareTo(sums[(j - 1)]) < 0 ) {
                    E buffer = sums[j];
                    E[] bufferJag = jagged[j];

                    sums[j] = sums[(j - 1)];
                    jagged[j] = jagged[(j - 1)];

                    sums[(j - 1)] = buffer;
                    jagged[(j - 1)] = bufferJag;

                }
            }
        }
        jaggedIntegerArray.setMatrixData(jagged);
    }

    public static <E extends Number> E[] populateSumArrayGeneric(SquareMatrix<E> jaggedMatrix) {
        E[] sums = null;
        E[][] jagged = jaggedMatrix.getMatrixData();
        if (jagged instanceof Integer[][]) {
            sums = (E[]) new Integer[jagged.length];
        }
        if (jagged instanceof Double[][]) {
            sums = (E[]) new Double[jagged.length];
        }
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                sums[i] = calculateRowSum(jagged[i]);
            }
        }
        return sums;
    }

    /**
     * Вычисляет сумму элементов массива (строки в зубчатом массиве)
     *
     * @param row массив(строка в зубчатом массиве)
     * @return int sum - сумма элементов массива(строки)
     */
    public static <E extends Number> E calculateRowSum(E[] row) {
        E sum = null;
        if (row instanceof Integer[]) {
            Integer intSum = 0;
            for (int i = 0; i < row.length; i++) {
                intSum = intSum + (Integer) row[i];
            }
            sum = (E)intSum;
        }
        if (row instanceof Double[]) {
            Double doubleSum = 0.0;
            for (int i = 0; i < row.length; i++) {
                doubleSum = doubleSum + (Integer) row[i];
            }
            sum = (E)doubleSum;
        }
        return sum;
    }




//    /**
//     * Сортирует зубчатый массив
//     *
//     * @param jaggedMatrix целевой зубчатый массив
//     * @param isAscending {@code true} сортировать по возрастанию
//     */
//    public static void sortJaggedArrayRowElements(JaggedMatrix jaggedMatrix, boolean isAscending) {
//        int[][] jagged = jaggedMatrix.getArrayData();
//        for (int i = 0; i < jagged.length - 1; i++) {
//            sortArray(jagged[i], isAscending);
//        }
//        jaggedMatrix.setArrayData(jagged);
//    }
//
//    /**
//     * Сортировка массива 'Пузырьком'
//     * @param targetArray целевой одинарный массив
//     */
//    private static void sortArray(int[] targetArray, boolean isAscending) {
//        for (int i = (targetArray.length - 1); i >=0; i--) {
//            for (int j = 0; j < i; j++) {
//                if (isAscending) {
//                    if (targetArray[j] > targetArray[j + 1]) {
//                        int buffer = targetArray[j];
//                        targetArray[j] = targetArray[j + 1];
//                        targetArray[j + 1] = buffer;
//                    }
//                }
//                if (!isAscending) {
//                    if (targetArray[j] < targetArray[j + 1]) {
//                        int buffer = targetArray[j];
//                        targetArray[j] = targetArray[j + 1];
//                        targetArray[j + 1] = buffer;
//                    }
//                }
//
//            }
//        }
//    }
//
//    private static int[] populateSumArray(JaggedMatrix jaggedMatrix) {
//        int[][] jagged = jaggedMatrix.getArrayData();
//        int[] sums = new int[jagged.length];
//
//        for (int i = 0; i < jagged.length; i++) {
//            for (int j = 0; j < jagged[i].length; j++) {
//                sums[i] = calculateRowSum(jagged[i]);
//            }
//        }
//        return sums;
//    }
//
//    /**
//     * Вычисляет сумму элементов массива (строки в зубчатом массиве)
//     *
//     * @param row массив(строка в зубчатом массиве)
//     * @return int sum - сумма элементов массива(строки)
//     */
//    private static int calculateRowSum(int[] row) {
//        int sum = 0;
//        for (int i = 0; i < row.length; i++) {
//            sum = sum + row[i];
//        }
//        return sum;
//    }
}
