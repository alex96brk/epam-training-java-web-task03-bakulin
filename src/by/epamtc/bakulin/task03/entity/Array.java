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
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * Пустой экземпляр массива
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

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
        this.arrayData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * Конструктор для создания пустого массива с указанной
     * начальной вместимостью.
     * @param userInitialCapacity вместимость массива
     */
    public Array(int userInitialCapacity) {
        if(userInitialCapacity > 0) {
            this.arrayData = new Object[userInitialCapacity];
        }
        if (userInitialCapacity == 0) {
            this.arrayData = EMPTY_ELEMENT_DATA;
        }
        if (userInitialCapacity < 0) {
            throw new IllegalArgumentException(String.format("Negative capacity is not Allowed: %d", userInitialCapacity));
        }
    }

    @Override
    public boolean add(E e) {
        return false;
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
        return 0;
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
