package task7;

//todo Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и
//      возвращающий новый массив, каждый элемент которого равен сумме элементов двух
//      входящих массивов в той же ячейке.
//     Если длины массивов не равны, необходимо как-то оповестить пользователя.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {0, 1, 3, 5};
        int[] b = {0, 3, 1, 6};
        try {
            System.out.println(Arrays.toString(sumArrays(a, b)));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[] sumArrays(int[] a, int[] b) {
        if (a == null || b == null) throw new RuntimeException("По крайней мере один из массивов не существует!");
        int len = a.length;
        if (len != b.length) throw new RuntimeException("Длины массивов разные!");

        int[] result = new int[len];
        for (int i = 0; i < len; i++) result[i] = a[i] + b[i];
        return result;
    }
}
