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

    @Override
    public boolean add(E e) {
        boolean addResult = false;
        int currentIndex = size;

        if (size > 0) {
            currentIndex += 1;

            if (isArrayFull(currentIndex)) {
                arrayData = growArrayData();
            }
            arrayData[currentIndex] = e;
            ++size;
            addResult = true;
        }
        if (size == 0) {
            arrayData[currentIndex] = e;
            ++size;
            addResult = true;
        }
        return addResult;
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
     * Увеличивает текущий массив в 2 раза, в случае:
     * заполнения последнего элемента в массиве
     *
     * @return новый массив с увеличенным кол-вом ячеек;
     */
    private Object[] growArrayData() {
        int currentCapacity = arrayData.length;
        int newCapacity = currentCapacity + DEFAULT_CAPACITY;

        Object[] newArray = new Object[newCapacity];
        System.arraycopy(arrayData, 0, newArray, 0, arrayData.length);

        return newArray;
    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    @Override
    public E get(Object o) {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
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
