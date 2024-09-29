package task4;

//todo Задача 4. Нахождение среднеарифметического числа
//  Напишите метод, который находит среднее значение массива целых чисел.
//  Если массив пустой или null, метод должен вернуть Double.NaN и вывести
//  сообщение об ошибке.

public class Main {
    public static void main(String[] args) {
        System.out.println(mean(new int[]{10, 20, 30, 40, 50}));
    }

    public static double mean(int[] ints) {
        if (ints == null || ints.length == 0) return Double.NaN;
        double mean = 0;
        for (int el : ints) mean += el;
        return mean/ints.length;
    }
}
