package by.epamtc.bakulin.task03.entity;

import by.epamtc.bakulin.task03.utils.ConsoleUtils;
import by.epamtc.bakulin.task03.utils.PlainRandomGenerator;

public class JaggedIntegerArray {

    private int[][] arrayData;
    private int matrixSize;


    public static void main(String[] args) {

    }

    public JaggedIntegerArray(int matrixRange) {
        this.matrixSize = matrixRange;
        this.arrayData = generateJaggedArray(matrixRange);
    }

    public int[][] getArrayData() {
        return this.arrayData;
    }

    public int getRows() {
        return matrixSize;
    }

    public int getColumns() {
        return matrixSize;
    }

    public void populateJaggedArrayRandomNumerics(int randomStartValue, int increment) {
        PlainRandomGenerator randomGenerator = new PlainRandomGenerator(31, increment, 127, randomStartValue);

        for (int i = 0; i < arrayData.length; i++) {

            for (int j = 0; j < arrayData[i].length; j++) {
                arrayData[i][(j)] = randomGenerator.calculateRandom();
            }
        }
    }

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
