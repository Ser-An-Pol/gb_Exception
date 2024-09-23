package task2;

//todo Задание №2
//  Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
//  Необходимо посчитать и вернуть сумму элементов этого массива.
//  При этом накладываем на метод 2 ограничения: метод может работать только с
//  квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
//  только значение 0 или 1.
//  Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об
//  ошибке.

public class Main {
    public static void main(String[] args) {
        int[][] ints = {{0, 1, 1},
                          {0, 2, 1},
                         {0, 1, 1}};
        try {
            System.out.println("Сумма квадратов мелементов матрицы равна " + getSumSquare(ints));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getSumSquare(int[][] arr) {
        if (arr == null) throw new RuntimeException("Массив не существует!");
        if (!isSquare(arr)) throw new RuntimeException("Массив не квадратный!");
        if ((!isZeroOne(arr))) throw new RuntimeException("Массив содержит значения отличные от 0 и 1!");
        int sum = 0;
        for (int[] anInt : arr)
            for ( int element : anInt) sum += element;
        return sum;
    }

    public static boolean isSquare(int[][] ints) {
        int len = ints.length;
        for (int[] anInt : ints)
            if (anInt.length != len) return false;
        return true;
    }

    public static boolean isZeroOne(int[][] ints) {
        for (int[] anInt : ints)
            for ( int element : anInt)
                if (element != 0 && element!= 1) return false;
        return true;
    }
}
