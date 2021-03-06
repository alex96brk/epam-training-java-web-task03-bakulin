# EPAM Java Web Development Training
### Студент: Bakulin Alexey (Бакулин Алексей)
### Задание: Task03
### Навигация по репозиторию:
### Задание 1:
Создание типа Array [`-> (см. DynamicArray)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/entity/DynamicArray.java), который является классом оболочкой над массивом целого типа.
В данном типе должны быть реализованы конструкторы (позволяющие несколькими способами создавать объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(), equals(), hasCode()).
Программа должна иметь следующие возможности:
1. Сортировать массив тремя способами. [`-> (см. ArrayUtils, line: 14-28; 249-372)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/utils/ArrayUtils.java)
2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска) [`-> (см. ArrayUtils, line: 37-48)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/utils/ArrayUtils.java)
3. Нахождение максимального и минимального элемента массива. [`-> (см. ArrayUtils см. line: 116-135)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/utils/ArrayUtils.java)
4. Получить все простые числа находящиеся в массиве. [`-> (см. ArrayUtils см. line: 99-108)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/utils/ArrayUtils.java)
5. Получить все числа Фибонначчи находящиеся в массиве. [`-> (см. ArrayUtils, line: 154-177)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/utils/ArrayUtils.java)
6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр. [`-> (см. ArrayUtils, line: в 186-198)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/utils/ArrayUtils.java)
7. Заполнения элементов массива и с консоли [`-> (см. ConsoleUtils, line: 54-64)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/utils/ConsoleUtils.java), и с файла [`-> (см. IntegerArrayUtils, line: 377-394)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/IntegerArrayUtils.java) и с помощью генерации случайных чисел. [`-> (см. IntegerArrayUtils, line: 361-369)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/IntegerArrayUtils.java) 
### Задание 2:
Дан непрямоугольный целочисленный массив (jagged array) [`-> (см. JaggedIMatrix`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/entity/JaggedMatrix.java). Реализовать алгоритм "пузырьковой" сортировки, таким образом, чтобы была возможность упорядочить строки матрицы:
1. в порядке возрастания (убывания) сумм элементов строк матрицы; [`-> (см. JaggedMatrixUtils)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/utils/JaggedMatrixUtils.java)
2. в порядке возрастания (убывания) максимальных элементов строк матрицы; [`-> (см. JaggedIntegerArrayUtils)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/utils/JaggedMatrixUtils.java)
3. в порядке возрастания (убывания) минимальных элементов строк матрицы. [`-> (см. JaggedIntegerArrayUtils)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/do-generic/src/by/epamtc/bakulin/task03/utils/JaggedMatrixUtils.java)
Для сортировки методы класса Array не использовать! Основное требование избежать повтора кода!!!!!