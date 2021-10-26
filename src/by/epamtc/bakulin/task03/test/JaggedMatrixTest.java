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
    public void jaggedIntegerArrayUtilsClassTest() {
        SquareMatrix<Integer> jaggedMatrix = new JaggedMatrix(JaggedMatrixUtils.generateJaggedArrayInteger(5));
        JaggedMatrixUtils.populateJaggedMatrixRandomInteger(jaggedMatrix, 5, 7);
        ConsoleUtils.printJaggedArray(jaggedMatrix);
        JaggedMatrixUtils.sortJaggedArrayBySumRowsElements(jaggedMatrix);
        ConsoleUtils.printConsoleMessage("After sort:\n");
        ConsoleUtils.printJaggedArray(jaggedMatrix);
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
    }
    @Test
    public void test() {
//        Integer[] nums = new Integer[] {23, 15, 32, 41};
//        Integer sum = JaggedMatrixUtils.calculateRowSum(nums);
//        System.out.println(sum);
        SquareMatrix<Integer> jaggedMatrix = new JaggedMatrix(JaggedMatrixUtils.generateJaggedArrayInteger(5));
        JaggedMatrixUtils.populateJaggedMatrixRandomInteger(jaggedMatrix, 5, 7);
        ConsoleUtils.printJaggedArray(jaggedMatrix);
        JaggedMatrixUtils.sortJaggedArrayBySumRowsElements(jaggedMatrix);
        ConsoleUtils.printConsoleMessage("Sorted");
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
