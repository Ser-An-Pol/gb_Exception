package task0;

//todo Задание №0
// -Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
// -Если длина массива меньше некоторого заданного минимума, метод возвращает -1,
//   в качестве кода ошибки, иначе - длину массива.


public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2, 3, 4, 5, 6, 7, 8};
        int minLength = 16;
        System.out.println(getLength(arr, minLength));
    }

    public static int getLength(int[] array, int min) {
        int len = array.length;
        return (len < min) ? -1 : len;
    }
}
