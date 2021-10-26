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
    public void jaggedIntegerArrayClassTest() {
        ConsoleUtils.printConsoleMessage("Test: Base Class Functionality\n");
        SquareMatrix<Integer> jaggedMatrix = new JaggedMatrix(JaggedMatrixUtils.generateJaggedArrayInteger(5));

        ConsoleUtils.printConsoleMessage("Populating array with random numerics:\n");

        JaggedMatrixUtils.populateJaggedMatrixRandomInteger(jaggedMatrix, 5, 7);
        ConsoleUtils.printJaggedArray(jaggedMatrix);

        ConsoleUtils.printConsoleMessage("Test: Finished\n");
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

//
//    @Test
//    public void jaggedIntegerArrayUtilsClassTest1() {
//        int matrixDimension = 5;
//        JaggedMatrix jaggedMatrix = new JaggedMatrix(matrixDimension);
//        jaggedMatrix.populateJaggedArrayRandomNumerics(5, 7);
//        ConsoleUtils.printJaggedArray(jaggedMatrix);
//        System.out.println("Sorted rows ascending:");
//
//        JaggedIntegerArrayUtils.sortJaggedArrayRowElements(jaggedMatrix, false);
//        ConsoleUtils.printJaggedArray(jaggedMatrix);
//    }


}
