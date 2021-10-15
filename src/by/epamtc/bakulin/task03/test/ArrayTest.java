package by.epamtc.bakulin.task03.test;

import by.epamtc.bakulin.task03.entity.Array;
import by.epamtc.bakulin.task03.entity.PlainArray;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArrayTest {

    @Test
    public void testAddElement() {
        PlainArray array1 = new Array();
        array1.add(17);
        array1.add(78);
        array1.add(23);

        PlainArray array2 = new Array();
        array2.add(17);
        array2.add(78);
        array2.add(23);
        boolean res = array1.equals(array2);
        System.out.println(res);
    }
}
