package by.epamtc.bakulin.task03.utils;

import by.epamtc.bakulin.task03.entity.JaggedIntegerArray;

public class JaggedIntegerArrayUtils {

    public static void main(String[] args) {
        int[] array = new int[] {2,4,5};
        System.out.println(calculateRowSum(array));
    }

    /**
     * Сортирует зубчатый массив
     * в порядке возрастания сумм элементов строки.
     * @param jaggedIntegerArray целевой зубчатый массив
     * @return int[][] массив отсортированных сумм строк
     */
    public static int[] sortJaggedArrayByMaxSumRowsValues(JaggedIntegerArray jaggedIntegerArray) {
        int[] sums = populateSumArray(jaggedIntegerArray);
        int[][] jagged = jaggedIntegerArray.getArrayData();

        for (int i = 0; i < (jagged.length - 1 ); i++) {
            for (int j = (jagged.length - 1); j > i; j--) {
                if (sums[j] < sums[(j - 1)]) {
                    int buffer = sums[j];
                    int[] bufferJag = jagged[j];

                    sums[j] = sums[(j - 1)];
                    jagged[j] = jagged[(j - 1)];

                    sums[(j - 1)] = buffer;
                    jagged[(j - 1)] = bufferJag;

                }
            }
        }
        jaggedIntegerArray.setArrayData(jagged);
        return sums;
    }

    private static int[] populateSumArray(JaggedIntegerArray jaggedIntegerArray) {
        int[][] jagged = jaggedIntegerArray.getArrayData();
        int[] sums = new int[jagged.length];

        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                sums[i] = calculateRowSum(jagged[i]);
            }
        }
        return sums;
    }

    /**
     * Вычисляет сумму элементов массива (строки в зубчатом массиве)
     * @param row массив(строка в зубчатом массиве)
     * @return int sum - сумма элементов массива(строки)
     */
    private static int calculateRowSum(int[] row) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum = sum + row[i];
        }
        return sum;
    }
}
