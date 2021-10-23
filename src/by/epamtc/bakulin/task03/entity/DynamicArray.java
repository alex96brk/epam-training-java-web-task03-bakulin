package by.epamtc.bakulin.task03.entity;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DynamicArray<E extends Number> implements Array<E> {

    /**
     * Значение длины массива по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Пустой экземпляр массива
     */
    private static final Object[] EMPTY_ARRAY_DATA = {};

    /**
     * Указывает начальный индекс копирования данных из старого массива
     */
    private static final int START_INDEX_COPY_FROM = 0;

    /**
     * Указывает начальный индекс копирования данных в новый массив
     */
    private static final int START_INDEX_COPY_TO = 0;

    /**
     * Текущее количество элементов в массиве.
     */
    private int size;

    /**
     * Массив, непосредственно выполняющий функцию
     * хранилища данных.
     */
    private Object[] arrayData;

    private int modCounter = 0;

    /**
     * Конструктор для создания пустого массива
     * с вместимостью по умолчанию
     */
    public DynamicArray() {
        this.arrayData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Конструктор для создания пустого массива с указанной
     * начальной вместимостью.
     *
     * @param userInitialCapacity вместимость массива
     */
    public DynamicArray(int userInitialCapacity) {
        if (userInitialCapacity > 0) {
            this.arrayData = new Object[userInitialCapacity];
        }
        if (userInitialCapacity == 0) {
            this.arrayData = EMPTY_ARRAY_DATA;
        }
        if (userInitialCapacity < 0) {
            throw new IllegalArgumentException(String.format("Illegal Capacity: %d", userInitialCapacity));
        }
    }

    /**
     * Конструктор для создания динамического массива
     * на основе пользовательского массива
     *
     * @param userArray пользовательский массив int[]
     */
    public DynamicArray(E[] userArray) {

        if (userArray == null || userArray.length == 0) {
            this.arrayData = EMPTY_ARRAY_DATA;
        }
        this.arrayData = userArray;
        this.size = userArray.length;
    }


    @Override
    public boolean add(E e) {
        boolean addResult = false;
        int currentIndex = size;

        if (size > 0) {
            if (isArrayFull(currentIndex)) {
                arrayData = increaseArrayCapacity(size);
            }
            addResult = writeElement(currentIndex, e);
        }
        if (size == 0) {
            addResult = writeElement(currentIndex, e);

        }
        return addResult;
    }

    @Override
    public void add(int index, E e) {
        checkIndex(index);

        if(index == 0) {
            if ((size + 1) < arrayData.length) {
                doArrayShift();
                writeElement(index, e);
            }
            if ((size + 1) >= arrayData.length) {
                arrayData = increaseArrayCapacity(index);
                writeElement(index, e);
            }
        }

        if(index > 0 && index != size) {
            if ((size + 1) < arrayData.length) {
                doArrayShift(index);
                writeElement(index, e);
            }
            if ((size + 1) >= arrayData.length) {
                arrayData = increaseArrayCapacity(index);
                writeElement(index, e);
            }
        }

        if(index == size) {
            if ((size + 1) < arrayData.length) {
                writeElement(index, e);
            }
            if ((size + 1) >= arrayData.length) {
                arrayData = increaseArrayCapacity(index);
                writeElement(index, e);
            }
        }
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index);
        E oldValue = elementData(index);
        arrayData[index] = e;
        return oldValue;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return elementData(index);
    }

    @Override
    public int indexOf(Object obj) {
        return indexOfRange( obj, 0, size);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E deletedElement = elementData(index);
        doArrayShiftRemove(index);
        writeOutElement();
        return deletedElement;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(int obj) {
        return indexOf(obj) >= 0;
    }

    /**
     * Возвращает текущий массив.
     * @return примитивный массив int[]
     */
    @Override
    public E[] getArrayData() {
        return (E[])this.arrayData;
    }

    @Override
    public void setArrayData(E[] newArrayData) {
        this.arrayData = newArrayData;
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + size;
        result = 31 * result + arrayData.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        DynamicArray targetArray = (DynamicArray) obj;
        if (this.size != targetArray.size) {
            return false;
        }
        if (equalsArrayData(this.arrayData, targetArray.arrayData)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = String.format("Array{ size = %d, arrayData = %s}", size, arrayStringBuilder(this.arrayData));
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E> {
        //next element to return
        int cursor = 0;
        //last returned element
        int lastReturn = -1;

        int expectedModCounter = modCounter;

        ArrayIterator() {}

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public E next() {
            checkModificationCounter();
            try {
                int i = cursor;
                E next = get(i);
                lastReturn = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                checkModificationCounter();
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            if (lastReturn < 0) {
                throw new IllegalStateException();
            }
            checkModificationCounter();

            try {
                DynamicArray.this.remove(lastReturn);
                if (lastReturn < cursor) {
                    cursor--;
                }
                lastReturn = -1;
                expectedModCounter = modCounter;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new ConcurrentModificationException();
            }
        }

        void checkModificationCounter() {
            if (modCounter != expectedModCounter) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private boolean equalsArrayData(Object[] a, Object[] b) {
        boolean result = false;
        if (a == b) {
            result = true;
        }
        if (a == null || b == null) {
            result = false;
        }
        if (a.length != b.length) {
            result = false;
        }
        int iterationCounter = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null || b[i] == null) {
                break;
            }
            if (a[i].equals(b[i])) {
                iterationCounter++;
                continue;
            } else {
                result = false;
                break;
            }
        }
        if ((iterationCounter) == size ) {
            result = true;
        }
        return result;
    }

    /**
     * Служит для уменьшения количества повторяющегося кода.
     * Выполняет запись элемента в массив
     *
     * @param index номер ячейки массива
     * @param e     элемент, помещаемый в массив
     * @return {@code true} если указанный элемент был добавлен в массив
     */
    private boolean writeElement(int index, E e) {
        arrayData[index] = e;
        ++size;
        return true;
    }

    private boolean writeOutElement() {
        --size;
        return true;
    }

    /**
     * Осуществляет проверку:
     * Является ли массив полностью заполненным?
     *
     * @param currentIndex текущий индекс элемента
     * @return {@code true} если текущий индекс больше текущей вместимости массива
     */
    private boolean isArrayFull(int currentIndex) {
        boolean isFull = false;

        if (currentIndex >= arrayData.length) {
            isFull = true;
        }
        return isFull;
    }

    /**
     * Увеличивает текущий массив в +10 элементов, в случае:
     * если не хватает емкости текущего массива
     *
     * @return новый массив с увеличенным кол-вом ячеек;
     */
    private Object[] increaseArrayCapacity(int currentIndex) {
        Object[] newArr = generateNewArray();

        if (currentIndex == 0) {
            System.arraycopy(arrayData, START_INDEX_COPY_FROM, newArr, (START_INDEX_COPY_TO + 1), arrayData.length);
        }
        if (currentIndex > 0) {
            System.arraycopy(arrayData, START_INDEX_COPY_FROM, newArr, START_INDEX_COPY_TO, currentIndex);
            System.arraycopy(arrayData, currentIndex, newArr, (currentIndex + 1), (arrayData.length - currentIndex));
        }

        return newArr;
    }

    /**
     * При вызове, создает новый массив
     * с вместимостью old.length + 10
     *
     * @return newArray.length = old.length + 10
     */
    private Object[] generateNewArray() {
        int currentCapacity = arrayData.length;
        int newCapacity = currentCapacity + DEFAULT_CAPACITY;

        return new Object[newCapacity];
    }

    /**
     * Выполняет сдвиг элементов массива, в случае:
     * если массив не полностью заполнен
     */
    private void doArrayShift() {
        for (int i = size; i != 0; i--) {
            arrayData[i] = arrayData[(i - 1)];
        }
    }

    private void doArrayShiftRemove(int targetIndex) {
        int lastElementIndex = size - 1;
        for (int i = targetIndex; i < lastElementIndex; i++) {
            arrayData[i] = arrayData[(i + 1)];
        }
        arrayData[lastElementIndex] = null;
    }

    private void doArrayShift(int targetIndex) {
        int lastElementIndex = size;

        for (int i = lastElementIndex; i >= targetIndex ; i--) {
            arrayData[i] = arrayData[(i - 1)];
        }

    }

    private int indexOfRange(Object obj, int start, int end) {
        Object[] currentArray = arrayData;
        int result = -1;

        if (obj == null) {
            for (int i = start; i < end; i++) {
                if (currentArray[i] == null) {
                    result = i;
                }
            }
        }
        for (int i = start; i < end; i++) {
            if (obj.equals(currentArray[i])) {
                result = i;
            }
        }
        return result;
    }

    private String arrayStringBuilder(Object[] targetArray) {
        if (targetArray == null) {
            return "null";
        }
        int indexMax = size - 1;
        if (indexMax == -1) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; ;i++) {
            stringBuilder.append(targetArray[i]);
            if(i == indexMax) {
                return stringBuilder.append(']').toString();
            }
            stringBuilder.append(", ");
        }
    }

    /**
     * Осуществляет проверку указанного индекса на:
     * Возможность передачи отрицательного значения
     * Возможность передачи значения, большего чем вместимость массива
     *
     * @param index указанный индекс
     */
    private void checkIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Illegal Index. Can not be < 0: index = %d", index));
        }
        if (index > arrayData.length) {
            throw new IndexOutOfBoundsException(String.format("Illegal Index. Can not be larger then array.length: index = %d; array.length = %d", index, arrayData.length));
        }
    }

    private E elementData(int index) {
        return (E) arrayData[index];
    }


}
