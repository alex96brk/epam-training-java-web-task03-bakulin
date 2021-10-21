package by.epamtc.bakulin.task03.test;

import by.epamtc.bakulin.task03.entity.DynamicIntegerArray;
import by.epamtc.bakulin.task03.entity.Array;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IntegerArrayTest {

    @Test
    public void testArrayA1() {
        System.out.println("Test01: Started");
        System.out.println("Reason: проверка создания динамического массива на основе работы метода add() с добавлением в конец");
        int a = 78;
        Integer b = 23;

        Array array1 = new DynamicIntegerArray();
        array1.add(17);
        array1.add(a);
        array1.add(b);
        array1.add(45);
        System.out.println(String.format("Attempt to add(int val): %d, %d, %d, %d", 17, a, b, 45));
        System.out.println(String.format("Result: %s", array1.toString()));
        System.out.println("Test01: Finished\n");

    }

    @Test
    public void testArrayB2() {
        System.out.println("Test02: Started");
        System.out.println("Reason: проверка создания динамического массива на основе примитивного");
        System.out.println("Reason: проверка расширения динамического массива после создания на основе примитивного массива");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        System.out.println(String.format("Attempt to add(int[] array): %s", Arrays.toString(arr)));
        Array array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Result: %s\n", array1.toString()));

        int a = 15;
        System.out.println(String.format("Attempt to add(int val) to recent array: %d", a));
        array1.add(a);
        System.out.println(String.format("Result: %s", array1.toString()));
        int b = 48;
        System.out.println(String.format("Attempt to add(int val) to recent array: %d", a));
        array1.add(b);
        System.out.println(String.format("Result: %s", array1.toString()));
        System.out.println("Test02: Finished\n");
    }

    @Test
    public void testArrayC3() {
        System.out.println("Test03: Started");
        System.out.println("Reason: проверка создания динамического массива на основе примитивного");
        System.out.println("Reason: проверка добавления новых элементов в начало, середину, конец динамического массива");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};

        Array array1 = new DynamicIntegerArray(arr);

        int a = 81;
        int index1 = 3;
        System.out.println(String.format("Attempt to add(%d) into index = %d: %s", a, index1, array1.toString()));
        array1.add(3, a);
        System.out.println(String.format("Result: %s\n", array1.toString()));

        int b = 79;
        System.out.println(String.format("Attempt to add(int %d) into start: %s", b, array1.toString()));
        array1.add(0, b);
        System.out.println(String.format("Result: %s\n", array1.toString()));

        int c = 97;
        System.out.println(String.format("Attempt to add(int %d) into end: %s", c, array1.toString()));
        array1.add(array1.size(), c);
        System.out.println(String.format("Result: %s\n", array1.toString()));

        int d = 43;
        int index2 = 5;
        System.out.println(String.format("Attempt to add(%d) into index = %d: %s", d, index2, array1.toString()));
        array1.add(index2, d);
        System.out.println(String.format("Result: %s\n", array1.toString()));

        int e = 69;
        int index3 = 8;
        System.out.println(String.format("Attempt to add(%d) into index = %d: %s", e, index3, array1.toString()));
        array1.add(index3, e);
        System.out.println(String.format("Result: %s\n", array1.toString()));

        int f = 79;
        System.out.println(String.format("Attempt to add(int %d) into start: %s", f, array1.toString()));
        array1.add(0, f);
        System.out.println(String.format("Result: %s\n", array1.toString()));


        System.out.println("Test03: Finished\n");
    }

    @Test
    public void testArrayD4() {
        System.out.println("Test04: Started");
        System.out.println("Reason: проверка создания динамического массива на основе примитивного");
        System.out.println("Reason: проверка работы метода set() -> замена существующего элемента в массиве\n");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        Array array1 = new DynamicIntegerArray(arr);

        int a = 81;
        int index1 = 0;
        System.out.println(String.format("Attempt to add(%d) into index = %d: %s", a, index1, array1.toString()));
        int prevValue =  array1.set(index1, a);
        System.out.println(String.format("previous value: value = %d", prevValue));
        System.out.println(String.format("Result: %s\n", array1.toString()));

        System.out.println("Test04: Finished\n");
    }

    @Test
    public void testArrayE5() {
        System.out.println("Test05: Started");
        System.out.println("Reason: проверка создания динамического массива на основе примитивного");
        System.out.println("Reason: проверка работы метода get(index)");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        Array array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current array: %s", array1.toString()));
        for (int i = 0; i < array1.size(); i++) {
            System.out.println(array1.get(i));
        }
        System.out.println("Test05: Finished\n");
    }

    @Test
    public void testArrayF6() {
        System.out.println("Test06: Started");
        System.out.println("Reason: проверка создания динамического массива на основе примитивного");
        System.out.println("Reason: проверка работы метода index(obj)");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        Array array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current array: %s", array1.toString()));
        int obj1 = 1;
        int obj2 = 4;
        int obj3 = 6;
        System.out.println(String.format("obj = %d -> result: index = %d", obj1, array1.indexOf(obj1)));
        System.out.println(String.format("obj = %d -> result: index = %d", obj2, array1.indexOf(obj2)));
        System.out.println(String.format("obj = %d -> result: index = %d", obj3, array1.indexOf(obj3)));
        System.out.println("Test06: Finished\n");
    }

    @Test
    public void testArrayG7() {
        System.out.println("Test07: Started");
        System.out.println("Reason: проверка создания динамического массива на основе примитивного");
        System.out.println("Reason: проверка работы метода remove(index)");
        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        Array array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("Current array: %s", array1.toString()));

        int deleteIndex1 = 0;
        System.out.println(String.format("index to delete: index = %d", deleteIndex1));
        array1.remove(deleteIndex1);
        System.out.println(String.format("Result array: %s\n", array1.toString()));

        int deleteIndex2 = 2;
        System.out.println(String.format("index to delete: index = %d", deleteIndex2));
        array1.remove(deleteIndex2);
        System.out.println(String.format("Result array: %s\n", array1.toString()));

        int deleteIndex3 = 3;
        System.out.println(String.format("index to delete: index = %d", deleteIndex3));
        array1.remove(deleteIndex3);
        System.out.println(String.format("Result array: %s\n", array1.toString()));

        System.out.println("Test07: Finished\n");
    }

    @Test
    public void testArrayH8() {
        System.out.println("Test08: Started");
        System.out.println("Reason: проверка создания динамического массива на основе примитивного");
        System.out.println("Reason: проверка работы метода isEmpty()");

        DynamicIntegerArray array1 = new DynamicIntegerArray();
        System.out.println(String.format("array: %s", array1.toString()));
        System.out.println(String.format("isEmpty: %b", array1.isEmpty()));
        System.out.println("Test08: Finished\n");
    }

    @Test
    public void testArrayI9() {
        System.out.println("Test09: Started");
        System.out.println("Reason: проверка создания динамического массива на основе примитивного");
        System.out.println("Reason: проверка работы метода contains(obj)");

        int[] arr = new int[]{1, 4, 6, 8, 3, 5};
        Array array1 = new DynamicIntegerArray(arr);
        System.out.println(String.format("array: %s\n", array1.toString()));

        int targetValue1 = 3;
        System.out.println(String.format("value to check: val = %d", targetValue1));
        System.out.println(String.format("contains? result: %b\n", array1.contains(targetValue1)));

        int targetValue2 = 100;
        System.out.println(String.format("value to check: val = %d", targetValue2));
        System.out.println(String.format("contains? result: %b\n", array1.contains(targetValue2)));

        System.out.println("Test09: Finished\n");
    }

    @Test
    public void testArrayJ10() {
        System.out.println("Test10: Started");
        System.out.println("Reason: проверка создания динамического массива на основе примитивного");
        System.out.println("Reason: проверка работы методов hashCode() и equals(obj)");

        int[] arr1 = new int[]{1, 4, 6, 8, 3, 5};
        Array array1 = new DynamicIntegerArray(arr1);
        System.out.println(String.format("array1: %s", array1.toString()));


        Array array2 = array1;
        System.out.println(String.format("array2: %s", array2.toString()));

        int[] arr3 = new int[]{1, 4, 6, 8, 3, 5};
        Array array3 = new DynamicIntegerArray(arr3);
        System.out.println(String.format("array3: %s", array3.toString()));

        int[] arr4 = new int[]{1, 4, 6, 10, 40, 70};
        Array array4 = new DynamicIntegerArray(arr4);
        System.out.println(String.format("array4: %s\n", array4.toString()));

        System.out.println(String.format("hashcode array1: val = %d", array1.hashCode()));
        System.out.println(String.format("hashcode array2: val = %d", array2.hashCode()));
        System.out.println(String.format("hashcode array3: val = %d", array3.hashCode()));
        System.out.println(String.format("hashcode array4: val = %d\n", array4.hashCode()));

        System.out.println(String.format("array1 equals? array2: val = %b", array1.equals(array2)));
        System.out.println(String.format("array1 equals? array3: val = %b", array1.equals(array3)));
        System.out.println(String.format("array2 equals? array3: val = %b", array2.equals(array3)));
        System.out.println(String.format("array2 equals? array4: val = %b", array2.equals(array4)));
        System.out.println(String.format("array3 equals? array4: val = %b", array3.equals(array4)));

        System.out.println("Test10: Finished\n");
    }

    @Test
    public void testArrayK11() {
        System.out.println("Test11: Started");
        System.out.println("Reason: проверка создания динамического массива на основе примитивного");
        System.out.println("Reason: проверка работы методов hashCode() и equals(obj)");

        int[] arr1 = new int[]{1, 4, 6, 8, 3, 5};
        Array array1 = new DynamicIntegerArray(arr1);
        System.out.println(String.format("array1: toString() -> %s", array1.toString()));

        System.out.println("Test11: Finished\n");
    }

    @Test
    public void testArrayL12() {
        System.out.println("Test12: Started");
        System.out.println("Reason: проверка создания динамического массива на основе примитивного");
        System.out.println("Reason: проверка работы метода getArrayData()");
        int[] arr1 = new int[]{1, 4, 6, 8, 3, 5};
        Array array1 = new DynamicIntegerArray(arr1);
        System.out.println(String.format("array1: toString() -> %s", array1.toString()));

        int[] arrResult = array1.getArrayData();
        System.out.println(String.format("Result: %s", Arrays.toString(arrResult)));
        System.out.println("Test12: Finished\n");
    }
}
