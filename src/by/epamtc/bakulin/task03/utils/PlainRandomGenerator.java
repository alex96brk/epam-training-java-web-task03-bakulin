package by.epamtc.bakulin.task03.utils;

public class PlainRandomGenerator {
    /**
     * В основу работы класса заложен - Линейный конгруэнтный метод генерации случайных чисел
     * (Самый простой и широко употребляемый)
     * x(n+1) = (a * x(n) + c) % m
     */
    private final int primeA;
    private final int funIncrementC;
    private final int module;
    private int randomX;

    public PlainRandomGenerator(int primeA, int funIncrementC, int module, int randomX) {
        this.primeA = primeA;
        this.funIncrementC = funIncrementC;
        this.module = module;
        this.randomX = randomX;
    }

    public int calculateRandom() {
        randomX = (primeA * randomX + funIncrementC) % module;
        return Math.abs(randomX);
    }


}
