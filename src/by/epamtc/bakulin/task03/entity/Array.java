package by.epamtc.bakulin.task03.entity;

import java.util.Iterator;

public class Array<E extends Number> implements PlainArray<E> {

    /**
     * Значение длины массива по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Пустой экземпляр массива
     */
    private static final Object[] EMPTY_ARRAY_DATA = {};

    /**
     * Текущее количество элементов в массиве.
     */
    private int size;

    /**
     * Массив, непосредственно выполняющий функцию
     * хранилища данных.
     */
    private Object[] arrayData;

    public Array() {
        this.arrayData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Конструктор для создания пустого массива с указанной
     * начальной вместимостью.
     *
     * @param userInitialCapacity вместимость массива
     */
    public Array(int userInitialCapacity) {
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
     * Добавляет элемент в конец массива
     *
     * @param e - добавляемый элемент в массив;
     * @return {@code true} если элемент был добавлен в массив;
     */
    @Override
    public boolean add(E e) {
        boolean addResult = false;
        int currentIndex = size;

        if (size > 0) {
            //currentIndex += 1;

            if (isArrayFull(currentIndex)) {
                arrayData = increaseArrayCapacity();
            }
            addResult = doAddElement(currentIndex, e);
        }

        if (size == 0) {
            addResult = doAddElement(currentIndex, e);

        }
        return addResult;
    }

    /**
     * Добавляет элемент в указанный индекс, осуществляет
     * сдвиг элементов.
     *
     * @param index - индекс в массиве для записи элемента;
     * @param e - добавляемый элемент в массив;
     * @return {@code true} если элемент был добавлен в массив;
     */
    @Override
    public void add(int index, E e) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Illegal Index. Can not be < 0: index = %d", index));
        }
        if(index > arrayData.length ) {
            throw new IndexOutOfBoundsException(String.format("Illegal Index. Can not be larger then array.length: index = %d; array.length = %d", index, arrayData.length));
        }
        if(index == 0) {
            doArrayShift();
        }
        if (isArrayFull(index)) {
            arrayData = increaseArrayCapacity(index);
        }

        doAddElement(index, e);

    }

    /**
     * Служит для уменьшения количества повторяющегося кода
     * Выполняет присвоение указанной в параметре ячейки, соответствующего элемента
     * @param index номер ячейки массива
     * @param e элемент, помещаемый в массив
     * @return {@code true} если указанный элемент был добавлен в массив
     */
    private boolean doAddElement(int index, E e) {
        arrayData[index] = e;
        ++size;
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
     * Увеличивает текущий массив +10 элементов, в случае:
     * если не хватает емкости текущего массива
     * Для добавления элемента в конец массива
     *
     * @return новый массив с увеличенным кол-вом ячеек;
     */
    private Object[] increaseArrayCapacity() {
        int currentCapacity = arrayData.length;
        int currentIndexCopyFrom = 0;
        int newIndexCopyTo = 0;

        int newCapacity = currentCapacity + DEFAULT_CAPACITY;

        Object[] newArray = new Object[newCapacity];
        System.arraycopy(arrayData, currentIndexCopyFrom, newArray, newIndexCopyTo, arrayData.length);

        return newArray;
    }
    /**
     * Увеличивает текущий массив в +10 элементов, в случае:
     * если не хватает емкости текущего массива
     *
     * @return новый массив с увеличенным кол-вом ячеек;
     */
    private Object[] increaseArrayCapacity(int currentIndex) {
        int currentCapacity = arrayData.length;
        int currentIndexCopyFrom = 0;
        int newIndexCopyTo = 0;

        int newCapacity = currentCapacity + DEFAULT_CAPACITY;

        Object[] newArr = new Object[newCapacity];
        if(currentIndex == 0) {
            System.arraycopy(arrayData, currentIndexCopyFrom, newArr, (newIndexCopyTo + 1), (arrayData.length - 1));
        }
        if(currentIndex > 0) {
            System.arraycopy(arrayData, currentIndexCopyFrom, newArr, newIndexCopyTo, currentIndex);
            System.arraycopy(arrayData, currentIndex, newArr, currentIndex, (arrayData.length - currentIndex));
        }

        return newArr;
    }

    private void doArrayShift() {

        for(int i = size; i != 0; i-- ) {
            arrayData[i] = arrayData[(i - 1)];
        }
    }

    /**
     * Добавляет элемент в указанный индекс ячейки массива.
     * В случае, если данная ячейка занята - происходит перезапись.
     *
     * @param index integer значение порядкового номера ячейки в массиве;
     * @param e добавляемый элемент в массив;
     * @return E элемент, который ранее находился на данной позиции;
     */
    @Override
    public E set(int index, E e) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Illegal Index. Can not be < 0: index = %d", index));
        }
        if(index > arrayData.length ) {
            throw new IndexOutOfBoundsException(String.format("Illegal Index. Can not be larger then array.length: index = %d; array.length = %d", index, arrayData.length));
        }
        E oldValue = (E)arrayData[index];
        arrayData[index] = e;
        return oldValue;
    }

    @Override
    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Illegal Index. Can not be < 0: index = %d", index));
        }
        if(index > arrayData.length ) {
            throw new IndexOutOfBoundsException(String.format("Illegal Index. Can not be larger then array.length: index = %d; array.length = %d", index, arrayData.length));
        }
        E returnResult = (E)arrayData[index];
        return returnResult;
    }

    @Override
    public int indexOf() {
        return 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
