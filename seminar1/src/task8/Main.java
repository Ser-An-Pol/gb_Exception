package task8;

//todo Задание №8 (доп)
//  Реализуйте метод, принимающий в качестве аргументов двумерный массив.
//  Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
//      детализировать какие строки со столбцами не требуется.
//  Как бы вы реализовали подобный метод?

public class Main {
    public static void main(String[] args) {

    }

    public static boolean isEqualLengthOfRowAndCol(int[][] arr) {
        boolean res = true;
        int lenCol = arr.length;
        for (int[] ints : arr)
            if (ints.length != lenCol) res = false;
        return res;
    }
}
