package by.epamtc.bakulin.task03.entity;

import by.epamtc.bakulin.task03.utils.PlainRandomGenerator;

public class JaggedIntegerArray {

    /**
     * Двумерный массив
     */
    private int[][] arrayData;

    /**
     * Размер квадратной матрицы
     */
    private int matrixSize;

    /**
     * Конструктор для создания пустого зубчатого массива
     * @param matrixRange
     */
    public JaggedIntegerArray(int matrixRange) {
        this.matrixSize = matrixRange;
        this.arrayData = generateJaggedArray(matrixRange);
    }

    /**
     * Вызов двумерного массива
     * @return int[][] jagged
     */
    public int[][] getArrayData() {
        return this.arrayData;
    }

    /**
     * Присвоить данные зубчатому массиву
     * @return int[][] jagged
     */
    public void setArrayData(int[][] arrayData) {
        this.arrayData = arrayData;
    }

    /**
     * Возвращает размер квадратной матрицы
     * @return
     */
    public int getJaggedArraySize() {
        return matrixSize;
    }

    /**
     * Заполняет зубчатый массив случайными числами
     * @param randomStartValue начальный аргумент для генерации случайных числе
     * @param increment инкремент функции генерации случайных чисел
     */
    public void populateJaggedArrayRandomNumerics(int randomStartValue, int increment) {
        PlainRandomGenerator randomGenerator = new PlainRandomGenerator(31, increment, 127, randomStartValue);

        for (int i = 0; i < arrayData.length; i++) {

            for (int j = 0; j < arrayData[i].length; j++) {
                arrayData[i][(j)] = randomGenerator.calculateRandom();
            }
        }
    }

    /**
     * Генерирует зубчатый массив
     * @param matrixRange размер квадратной матрицы
     * @return зубчатый массив int[][]
     */
    private static int[][] generateJaggedArray(int matrixRange) {
        int[][] result = new int[matrixRange][];

        for (int i = 0; i < matrixRange; i++) {
            result[i] = new int[matrixRange - i];

            if (i == (matrixRange - 1)) {
                result[i] = new int[1];
            }
        }
        return result;
    }


}
