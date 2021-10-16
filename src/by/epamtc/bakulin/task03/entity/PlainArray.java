package by.epamtc.bakulin.task03.entity;

public interface PlainArray extends Iterable<Integer> {

    /**
     * Добавляет элемент в конец массива
     *
     * @param e - добавляемый элемент в массив;
     * @return {@code true} если элемент был добавлен в массив;
     */
    boolean add(int e);

    /**
     * Добавляет элемент в указанный индекс, осуществляет
     * сдвиг элементов.
     *
     * @param index - индекс в массиве для записи элемента;
     * @param e - добавляемый элемент в массив;
     * @return {@code true} если элемент был добавлен в массив;
     */
    void add(int index, Integer e);

    /**
     * Добавляет элемент в указанный индекс ячейки массива.
     * В случае, если данная ячейка занята - происходит перезапись.
     *
     * @param index integer значение порядкового номера ячейки в массиве;
     * @param e добавляемый элемент в массив;
     * @return E элемент, который ранее находился на данной позиции;
     */
    Integer set(int index, Integer e);

    /**
     * Возвращает объект из массива, по указанному индексу.
     *
     * @param index integer значение порядкового номера ячейки в массиве;
     * @return E искомый элемент в массиве;
     */
    Integer get(int index);

    /**
     * Возвращает индекс в массиве, указанного объекта в качестве параметра
     * @return {@code -1} если объект отсутствует в массиве;
     */
    int indexOf(Object obj);

    /**
     * Удаляет объект из массива, указанный в качестве параметра.
     *
     * @param index индекс удаляемого элемента;
     * @return {@code e} возвращает удаленный элемент;
     */
    Integer remove (int index);

    /**
     * Возвращает текущее количество объектов в массиве
     *
     * @return {@code integer value};
     */
    int size();

    /**
     * Выполняет проверку массива на предмет пустоты.
     *
     * @return {@code true} если текущий массив пустой;
     */
    boolean isEmpty();

    /**
     * Выполняет проверку текущего массива на предмет наличия
     * указанного объекта в качестве параметра.
     *
     * @param obj искомый объект;
     * @return {@code true} если указанный объект присутствует в массиве;
     */
    boolean contains(int obj);

}
