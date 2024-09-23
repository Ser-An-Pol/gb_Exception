package homework.task3;

//todo Задача 3. Обработка исключений для разностных массивов
//  Реализуйте метод subArraysWithExceptionHandling, который принимает
//      два массива целых чисел. Метод должен возвращать новый массив, где
//      каждый элемент является разностью соответствующих элементов двух входных
//      массивов. Если длины массивов не равны, выбрасывайте
//      IllegalArgumentException с сообщением "Массивы разной длины". Если
//      результат разности оказывается отрицательным, выбрасывайте
//      RuntimeException с сообщением "Отрицательный результат разности"

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {10,20,30,40};
        int[] b = {5,6,7,8};
        try {
            System.out.println(Arrays.toString(subArraysWithExceptionHandling(a, b)));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int[] subArraysWithExceptionHandling(int[] a, int[] b)
            throws RuntimeException {
        int aLen = a.length, bLen = b.length;
        if (aLen != bLen) throw new IllegalArgumentException("Массивы разной длины");

        int[] result = new int[aLen];
        for (int i = 0; i < aLen; i++) {
            result[i] = a[i] - b[i];
            if (result[i] < 0) throw new RuntimeException("Отрицательный результат разности");
        }

        return result;
    }
}