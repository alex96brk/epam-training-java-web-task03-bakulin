package by.epamtc.bakulin.task03.utils;

public class IntegerRandomGenerator {
    /**
     * В основу работы класса заложен - Линейный конгруэнтный метод генерации случайных чисел
     * (Самый простой и широко употребляемый)
     * x(n+1) = (a * x(n) + c) % m
     */
    private final Integer primeA;
    private final Integer funIncrementC;
    private final Integer module;
    private Integer randomX;

    public IntegerRandomGenerator(Integer primeA, Integer funIncrementC, Integer module, Integer randomX) {
        this.primeA = primeA;
        this.funIncrementC = funIncrementC;
        this.module = module;
        this.randomX = randomX;
    }

    public Integer calculateRandom() {
        randomX = (primeA * randomX + funIncrementC) % module;
        return Math.abs(randomX);
    }

}
