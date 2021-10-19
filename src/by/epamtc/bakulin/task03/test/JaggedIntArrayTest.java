package by.epamtc.bakulin.task03.test;

import by.epamtc.bakulin.task03.entity.JaggedIntegerArray;
import by.epamtc.bakulin.task03.utils.ConsoleUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JaggedIntArrayTest {

    @Test
    public void jaggedIntegerArrayClassTest() {
        ConsoleUtils.printConsoleMessage("Test: Base Class Functionality\n");
        int matrixDimension = 5;
        JaggedIntegerArray jaggedIntegerArray = new JaggedIntegerArray(matrixDimension);
        ConsoleUtils.printConsoleMessage("Populating array with random numerics:\n");
        jaggedIntegerArray.populateJaggedArrayRandomNumerics(5, 14);
        ConsoleUtils.printJaggedArray(jaggedIntegerArray);

        ConsoleUtils.printConsoleMessage("Test: Finished\n");
    }
}
