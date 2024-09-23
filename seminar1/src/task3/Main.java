package task3;

//todo Задание №3
//  Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
//  Необходимо посчитать и вернуть сумму элементов этого массива.
//  При этом накладываем на метод 2 ограничения: метод может работать только с
//      квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
//      только значение 0 или 1.
//  Если нарушается одно из условий, метод должен вернуть код ошибки.
//  Программа должна корректно обработать код ошибки и вывести соответствующее
//      сообщение пользователю.
//  Сравнить такой вариант обработки исключений с предыдущим.
//  Какое преимущество у исключений перед кодами ошибок вы можете назвать в данном случае?


public class Main {
    public static void main(String[] args) {
        int[][] ints = {{0, 1, 1},
                {0, 0, 1},
                {0, 1, 1}};

        int result = getSumSquare(ints);
        switch (result) {
            case -1 -> System.out.println("Массив не существует!");
            case -2 -> System.out.println("Массив не квадратный!");
            case -3 -> System.out.println("Массив содержит значения отличные от 0 и 1!");
            default -> System.out.println(("Сумма квадратов мелементов матрицы равна " + result));
        }
    }

    public static int getSumSquare(int[][] arr) {
        if (arr == null) return -1;
        if (!isSquare(arr)) return -2;
        if ((!isZeroOne(arr))) return -3;

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
