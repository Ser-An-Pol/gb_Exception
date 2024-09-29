package task3;

//todo Задача 3. Сортировка массива строк
//  Напишите метод, который принимает массив строк и сортирует его в
//  алфавитном порядке. Если входной массив null, метод должен вернуть пустой
//  массив и вывести сообщение об ошибке.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new String[]{"banana", "apple", "cherry"})));
    }

    public static String[] sort(String[] array) {
        if (array == null) {
            System.out.println("Не задан массив для сортировки");
            return new String[0];
        }
        Arrays.sort(array);
        return array;
    }
}
