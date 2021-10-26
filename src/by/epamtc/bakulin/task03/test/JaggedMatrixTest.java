package by.epamtc.bakulin.task03.test;

import by.epamtc.bakulin.task03.entity.JaggedMatrix;
import by.epamtc.bakulin.task03.entity.SquareMatrix;
import by.epamtc.bakulin.task03.utils.ConsoleUtils;
import by.epamtc.bakulin.task03.utils.JaggedMatrixUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JaggedMatrixTest {

    @Test
    public void jaggedIntegerArrayClassTest1() {
        ConsoleUtils.printConsoleMessage("Test: Base Class Functionality\n");
        SquareMatrix<Integer> jaggedMatrix = new JaggedMatrix(JaggedMatrixUtils.generateJaggedArrayInteger(5));

        ConsoleUtils.printConsoleMessage("Populating array with random numerics:\n");

        JaggedMatrixUtils.populateJaggedMatrixRandomInteger(jaggedMatrix, 5, 7);
        ConsoleUtils.printJaggedArray(jaggedMatrix);

        ConsoleUtils.printConsoleMessage("Test: Finished\n");
    }

    @Test
    public void jaggedIntegerArrayClassTest2() {
        ConsoleUtils.printConsoleMessage("Test: Base Class Functionality\n");
        ConsoleUtils.printConsoleMessage("Test: Set Element\n");
        SquareMatrix<Integer> jaggedMatrix = new JaggedMatrix(JaggedMatrixUtils.generateJaggedArrayInteger(5));
        ConsoleUtils.printJaggedArray(jaggedMatrix);
        jaggedMatrix.setElement(0, 0, 31);
        jaggedMatrix.setElement(0, 1, 23);
        jaggedMatrix.setElement(0, 2, 17);
        jaggedMatrix.setElement(0, 3, 81);
        jaggedMatrix.setElement(0, 4, 75);

        jaggedMatrix.setElement(1, 0, 31);
        jaggedMatrix.setElement(1, 1, 23);
        jaggedMatrix.setElement(1, 2, 17);
        jaggedMatrix.setElement(1, 3, 81);

        jaggedMatrix.setElement(2, 0, 31);
        jaggedMatrix.setElement(2, 1, 23);
        jaggedMatrix.setElement(2, 2, 17);

        jaggedMatrix.setElement(3, 0, 31);
        jaggedMatrix.setElement(3, 1, 23);

        jaggedMatrix.setElement(4, 0, 23);

        ConsoleUtils.printJaggedArray(jaggedMatrix);
    }

    @Test
    public void jaggedIntegerArrayClassTest3() {
        ConsoleUtils.printConsoleMessage("Test: Base Class Functionality\n");
        ConsoleUtils.printConsoleMessage("Test: Get Element\n");
        SquareMatrix<Integer> jaggedMatrix = new JaggedMatrix(JaggedMatrixUtils.generateJaggedArrayInteger(5));
        JaggedMatrixUtils.populateJaggedMatrixRandomInteger(jaggedMatrix, 32, 17);
        ConsoleUtils.printJaggedArray(jaggedMatrix);

        int row1 = 1;
        int col1 = 2;
        Integer value1 = jaggedMatrix.getElement(row1, col1);
        ConsoleUtils.printConsoleMessage(String.format("get element (row, col) = (%d, %d) = %d\n", row1, col1, value1));

        int row2 = 3;
        int col2 = 1;
        Integer value2 = jaggedMatrix.getElement(row2, col2);
        ConsoleUtils.printConsoleMessage(String.format("get element (row, col) = (%d, %d) = %d\n", row2, col2, value2));

        int row3 = 2;
        int col3 = 2;
        Integer value3 = jaggedMatrix.getElement(row3, col3);
        ConsoleUtils.printConsoleMessage(String.format("get element (row, col) = (%d, %d) = %d\n", row3, col3, value3));

    }

    @Test
    public void jaggedIntegerArrayClassTest4() {
        ConsoleUtils.printConsoleMessage("Test: Base Class Functionality\n");
        ConsoleUtils.printConsoleMessage("Test: Get Row\n");
        SquareMatrix<Integer> jaggedMatrix = new JaggedMatrix(JaggedMatrixUtils.generateJaggedArrayInteger(5));
        JaggedMatrixUtils.populateJaggedMatrixRandomInteger(jaggedMatrix, 32, 17);
        ConsoleUtils.printJaggedArray(jaggedMatrix);

        int rowNum0 = 0;
        Integer[] row0 = jaggedMatrix.getRow(rowNum0);
        ConsoleUtils.printConsoleMessage(String.format("get row num = %d:  %s\n", rowNum0, Arrays.toString(row0)));

        int rowNum1 = 1;
        Integer[] row1 = jaggedMatrix.getRow(rowNum1);
        ConsoleUtils.printConsoleMessage(String.format("get row num = %d:  %s\n", rowNum1, Arrays.toString(row1)));
    }


    @Test
    public void jaggedIntegerArrayUtilsClassTest1() {
        SquareMatrix<Integer> jaggedMatrix = new JaggedMatrix(JaggedMatrixUtils.generateJaggedArrayInteger(5));
        JaggedMatrixUtils.populateJaggedMatrixRandomInteger(jaggedMatrix, 5, 7);
        ConsoleUtils.printJaggedArray(jaggedMatrix);
        JaggedMatrixUtils.sortJaggedArrayBySumRowsElements(jaggedMatrix);
        ConsoleUtils.printConsoleMessage("After sort:\n");
        ConsoleUtils.printJaggedArray(jaggedMatrix);
    }

    @Test
    public void jaggedIntegerArrayUtilsClassTest2() {
        SquareMatrix<Integer> jaggedMatrix = new JaggedMatrix(JaggedMatrixUtils.generateJaggedArrayInteger(5));
        JaggedMatrixUtils.populateJaggedMatrixRandomInteger(jaggedMatrix, 5, 7);
        ConsoleUtils.printJaggedArray(jaggedMatrix);
        JaggedMatrixUtils.sortJaggedArrayRowElements(jaggedMatrix, false);
        ConsoleUtils.printConsoleMessage("Sorted:\n");
        ConsoleUtils.printJaggedArray(jaggedMatrix);
    }

    @Test
    public void jaggedIntegerArrayUtilsClassTest3() {
        SquareMatrix<Integer> jaggedMatrix = new JaggedMatrix(JaggedMatrixUtils.generateJaggedArrayInteger(5));
        JaggedMatrixUtils.populateJaggedMatrixRandomInteger(jaggedMatrix, 5, 7);
        ConsoleUtils.printJaggedArray(jaggedMatrix);
        ConsoleUtils.printConsoleMessage("Sorted:\n");
        JaggedMatrixUtils.sortJaggedArrayRowElements(jaggedMatrix, true);
        ConsoleUtils.printJaggedArray(jaggedMatrix);
    }

}
