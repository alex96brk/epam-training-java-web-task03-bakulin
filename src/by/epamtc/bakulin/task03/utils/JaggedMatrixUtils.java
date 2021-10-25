package by.epamtc.bakulin.task03.utils;

import by.epamtc.bakulin.task03.entity.JaggedMatrix;

public class JaggedIntegerArrayUtils {

//    /**
//     * Сортирует зубчатый массив
//     * в порядке возрастания сумм элементов строки.
//     *
//     * @param jaggedMatrix целевой зубчатый массив
//     */
//    public static void sortJaggedArrayByMaxSumRowsElementsAsc(JaggedMatrix jaggedMatrix) {
//        int[] sums = populateSumArray(jaggedMatrix);
//        int[][] jagged = jaggedMatrix.getArrayData();
//
//        for (int i = 0; i < (jagged.length - 1); i++) {
//            for (int j = (jagged.length - 1); j > i; j--) {
//                if (sums[j] < sums[(j - 1)]) {
//                    int buffer = sums[j];
//                    int[] bufferJag = jagged[j];
//
//                    sums[j] = sums[(j - 1)];
//                    jagged[j] = jagged[(j - 1)];
//
//                    sums[(j - 1)] = buffer;
//                    jagged[(j - 1)] = bufferJag;
//
//                }
//            }
//        }
//        jaggedMatrix.setArrayData(jagged);
//    }
//
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
