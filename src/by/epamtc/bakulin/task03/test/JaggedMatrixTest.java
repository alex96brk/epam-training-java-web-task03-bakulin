package by.epamtc.bakulin.task03.test;

import by.epamtc.bakulin.task03.entity.JaggedMatrix;
import by.epamtc.bakulin.task03.entity.SquareMatrix;
import by.epamtc.bakulin.task03.utils.ConsoleUtils;
import by.epamtc.bakulin.task03.utils.JaggedMatrixUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JaggedArrayTest {

    @Test
    public void jaggedIntegerArrayClassTest() {
        ConsoleUtils.printConsoleMessage("Test: Base Class Functionality\n");
        int matrixDimension = 5;
        SquareMatrix<Integer> jaggedMatrix = new JaggedMatrix<>(matrixDimension);
        ConsoleUtils.printConsoleMessage("Populating array with random numerics:\n");
        //jaggedMatrix.populateJaggedArrayRandomNumerics(5, 7);
        JaggedMatrixUtils.populateJaggedMatrixRandomInteger(jaggedMatrix, 5, 7);
        ConsoleUtils.printJaggedArray(jaggedMatrix);

        ConsoleUtils.printConsoleMessage("Test: Finished\n");
    }
//
//    @Test
//    public void jaggedIntegerArrayUtilsClassTest() {
//        ConsoleUtils.printConsoleMessage("Test: Base Class Functionality\n");
//        int matrixDimension = 5;
//        JaggedMatrix jaggedMatrix = new JaggedMatrix(matrixDimension);
//        ConsoleUtils.printConsoleMessage("Populating array with random numerics:\n");
//
//        jaggedMatrix.populateJaggedArrayRandomNumerics(5, 7);
//        ConsoleUtils.printJaggedArray(jaggedMatrix);
//
//        JaggedIntegerArrayUtils.sortJaggedArrayByMaxSumRowsElementsAsc(jaggedMatrix);
//        ConsoleUtils.printConsoleMessage("\nSorted jagged array ascending row sums:\n");
//        ConsoleUtils.printJaggedArray(jaggedMatrix);
//
//        ConsoleUtils.printConsoleMessage("Test: Finished\n");
//    }
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
