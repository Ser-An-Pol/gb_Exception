package task1;

//todo Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое
//     значение. Метод ищет в массиве заданное значение и возвращает его индекс. При этом,
//     например:
//      1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в
//          качестве кода ошибки.
//      2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
//      3. если вместо массива пришел null, метод вернет -3
//      4. придумайте свои варианты исключительных ситуаций и верните соответствующие
//          коды ошибок.
//  Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот
//  метод запросит искомое число у пользователя, вызовет первый, обработает возвращенное
//  значение и покажет читаемый результат пользователю. Например, если вернулся -2,
//  пользователю выведется сообщение: “Искомый элемент не найден”.

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int minLength = 5;
        manager(arr, minLength);
    }

    public static void manager(int[] array, int min) {
        int result = getIndex(array, min, getInteger());
        switch (result) {
            case -1 -> System.out.println("The array is too short!");
            case -2 -> System.out.println("There isn't such element in the array!");
            case -3 -> System.out.println("The array isn't exist");
            default -> System.out.println("The index of the element is " + result);
        }

    }

    public static int getIndex(int[] array, int min, int value) {
        if (array == null) return -3;
        if (array.length < min) return -1;
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, value);
        return (index < 0) ? -2 : index;
    }

    public static int getInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число...");
        String string = scanner.nextLine();
        while (true)
            try {
                return Integer.parseInt(string);
            } catch (RuntimeException e) {
                System.out.println("Неверный формат. Попробуйте снова...");
            }

    }
}
