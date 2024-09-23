package homework.task2;

//todo Задача 2. Объединение массивов с проверкой длины и содержимого
//  Реализуйте метод mergeAndValidateArrays, который принимает два
//      массива целых чисел. Метод должен объединить массивы и вернуть новый
//      массив. Если длины массивов не равны, выбрасывайте исключение
//      IllegalArgumentException. Если хотя бы один элемент объединенного
//      массива отрицательный, выбрасывайте исключение RuntimeException с
//      сообщением "Обнаружен отрицательный элемент".

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {5,6,7,8};
        try {
            System.out.println(Arrays.toString(mergeAndValidateArrays(a, b)));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int[] mergeAndValidateArrays(int[] a, int[] b)
                                throws RuntimeException {
        int aLen = a.length, bLen = b.length;
        if (aLen != bLen) throw new IllegalArgumentException("Длины массивов не равны");

        int[] result = new int[aLen*2];
        int i = 0;
        for (int k : a)
            if (k < 0)  throw new RuntimeException("Обнаружен отрицательный элемент");
            else result[i++] = k;
        for (int k : b)
            if (k < 0) throw new RuntimeException("Обнаружен отрицательный элемент");
            else result[i++] = k;

        return result;
    }
}
