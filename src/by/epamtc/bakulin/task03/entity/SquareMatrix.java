package by.epamtc.bakulin.task03.entity;

public interface SquareMatrix <E> {
    void setElement(int row, int col, E value);

    E getElement(int row, int col);

    E[] getRow(int row);

    E[][] getMatrixData();

    void setMatrixData(E[][] matrixData);

    int getMatrixSize();
}
