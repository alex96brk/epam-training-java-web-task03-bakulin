# EPAM Java Web Dewelopment Training
### Студент: Bakulin Alexey (Бакулин Алексей)
### Задание: Task03
### Навигация по репозиторию:
### Задание 1:
Создание типа Array [`-> (см. DynamicIntegerArray)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/entity/DynamicIntegerArray.java), который является классом оболочкой над массивом целого типа.
В данном типе должны быть реализованы конструкторы (позволяющие несколькими способами создавать объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(), equals(), hasCode()).
Программа должна иметь следующие возможности:
1. Сортировать массив тремя способами. [`-> (см. IntegerArrayUtils, line: 18-112)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/IntegerArrayUtils.java)
2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска) [`-> (см. IntegerArrayUtils, line: 126-148)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/IntegerArrayUtils.java).
3. Нахождение максимального и минимального элемента массива. [`-> (см. IntegerArrayUtils, line: 156-175; 194-213)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/IntegerArrayUtils.java)
4. Получить все простые числа находящиеся в массиве. [`-> (см. IntegerArrayUtils, line: 232-247)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/IntegerArrayUtils.java)
5. Получить все числа Фибонначчи находящиеся в массиве. [`-> (см. IntegerArrayUtils, line: 255-287)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/IntegerArrayUtils.java)
6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр. [`-> (см. IntegerArrayUtils, line: 338-350)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/IntegerArrayUtils.java)
7. Заполнения элементов массива и с консоли [`-> (см. ConsoleUtils, line: 54-62)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/ConsoleUtils.java), и с файла [`-> (см. IntegerArrayUtils, line: 377-394)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/IntegerArrayUtils.java) и с помощью генерации случайных чисел. [`-> (см. IntegerArrayUtils, line: 361-369)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/IntegerArrayUtils.java) 
### Задание 2:
Дан непрямоугольный целочисленный массив (jagged array) [`-> (см. JaggedIntegerArray`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/entity/JaggedIntegerArray.java). Реализовать алгоритм "пузырьковой" сортировки, таким образом, чтобы была возможность упорядочить строки матрицы:
• в порядке возрастания (убывания) сумм элементов строк матрицы; [`-> (см. JaggedIntegerArrayUtils, line: 18-39)`](https://github.com/alex96brk/epam-training-java-web-task03-bakulin/blob/non-generic/src/by/epamtc/bakulin/task03/utils/JaggedIntegerArrayUtils.java)
• в порядке возрастания (убывания) максимальных элементов строк матрицы; [`-> (см. JaggedIntegerArrayUtils, line: в работе)`]
• в порядке возрастания (убывания) минимальных элементов строк матрицы. [`-> (см. JaggedIntegerArrayUtils, line: в работе)`]
Для сортировки методы класса Array не использовать! Основное требование избежать повтора кода!!!!!