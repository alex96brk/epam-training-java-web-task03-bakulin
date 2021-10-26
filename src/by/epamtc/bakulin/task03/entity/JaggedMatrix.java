package by.epamtc.bakulin.task03.entity;

public class JaggedMatrix<E extends Number & Comparable> implements SquareMatrix<E> {

    private static final Object[][] EMPTY_MATRIX = new Object[0][0];

    private Object[][] matrixData;

    public JaggedMatrix(E[][] jaggedArray) {
        this.matrixData = jaggedArray;
    }
    public JaggedMatrix() {
        this.matrixData = EMPTY_MATRIX;
    }

    @Override
    public void setElement(int row, int col, E value) {
        checkPosition(row, col);
        this.matrixData[row][col] = value;
    }

    @Override
    public E getElement(int row, int col) {
        checkPosition(row, col);
        return (E) this.matrixData[row][col];
    }

    @Override
    public E[] getRow(int row) {
        checkPosition(row);
        return (E[]) this.matrixData[row];
    }

    @Override
    public E[][] getMatrixData() {
        return (E[][])this.matrixData;
    }

    @Override
    public void setMatrixData(E[][] matrixData) {
        this.matrixData = matrixData;
    }

    @Override
    public int getMatrixSize() {
        return 0;
    }

    private boolean checkPosition(int row, int col) {
        boolean result = false;
        if (row < 0 || row > matrixData.length) {
            throw new IndexOutOfBoundsException(String.format("Illegal row index: row = %d", row));
        }
        if (col < 0 || col > matrixData[row].length) {
            throw new IndexOutOfBoundsException(String.format("Illegal column index for row = %d: column = %d", row, col));
        }
        if ((row > 0 && row < matrixData.length) && (col > 0 && col < matrixData[row].length)) {
            result = true;
        }
        return result;
    }
    private boolean checkPosition(int row) {
        boolean result = false;
        if (row < 0 || row > matrixData.length) {
            throw new IndexOutOfBoundsException(String.format("Illegal row index: row = %d", row));
        }
        if ((row > 0 && row < matrixData.length)) {
            result = true;
        }
        return result;
    }


//    /**
//     * Заполняет зубчатый массив случайными числами
//     * @param randomStartValue начальный аргумент для генерации случайных числе
//     * @param increment инкремент функции генерации случайных чисел
//     */
//    public void populateJaggedArrayRandomNumerics(int randomStartValue, int increment) {
//        PlainRandomGenerator randomGenerator = new PlainRandomGenerator(31, increment, 127, randomStartValue);
//
//        for (int i = 0; i < arrayData.length; i++) {
//
//            for (int j = 0; j < arrayData[i].length; j++) {
//                arrayData[i][(j)] = randomGenerator.calculateRandom();
//            }
//        }
//    }



}
