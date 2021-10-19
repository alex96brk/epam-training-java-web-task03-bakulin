package by.epamtc.bakulin.task03.test;

import by.epamtc.bakulin.task03.entity.JaggedIntegerArray;
import by.epamtc.bakulin.task03.utils.ConsoleUtils;
import by.epamtc.bakulin.task03.utils.JaggedIntegerArrayUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JaggedIntArrayTest {

    @Test
    public void jaggedIntegerArrayClassTest() {
        ConsoleUtils.printConsoleMessage("Test: Base Class Functionality\n");
        int matrixDimension = 5;
        JaggedIntegerArray jaggedIntegerArray = new JaggedIntegerArray(matrixDimension);
        ConsoleUtils.printConsoleMessage("Populating array with random numerics:\n");
        jaggedIntegerArray.populateJaggedArrayRandomNumerics(5, 7);
        ConsoleUtils.printJaggedArray(jaggedIntegerArray);

        ConsoleUtils.printConsoleMessage("Test: Finished\n");
    }

    @Test
    public void jaggedIntegerArrayUtilsClassTest() {
        ConsoleUtils.printConsoleMessage("Test: Base Class Functionality\n");
        int matrixDimension = 5;
        JaggedIntegerArray jaggedIntegerArray = new JaggedIntegerArray(matrixDimension);
        ConsoleUtils.printConsoleMessage("Populating array with random numerics:\n");

        jaggedIntegerArray.populateJaggedArrayRandomNumerics(5, 7);
        ConsoleUtils.printJaggedArray(jaggedIntegerArray);

        int[] sums = JaggedIntegerArrayUtils.sortJaggedArrayByMaxSumRowsValues(jaggedIntegerArray);
        ConsoleUtils.printConsoleMessage("\nSorted jagged array ascending row sums:\n");
        System.out.println(String.format("sums: %s", Arrays.toString(sums)));
        ConsoleUtils.printJaggedArray(jaggedIntegerArray);

        ConsoleUtils.printConsoleMessage("Test: Finished\n");
    }

}
