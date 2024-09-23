package homework.task4;

//todo Задача 4. Поиск и замена строк
//  Реализуйте метод findAndReplace, который принимает массив строк, строку
//  для поиска и строку для замены. Если искомая строка не найдена, добавьте
//  сообщение об ошибке в список. Верните новый массив строк с выполненной заменой.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<String> errors = new ArrayList<>();

    public static void main(String[] args) {
        String[] strings = {"a", "b", "c", "d"};
        findAndReplace(strings, "k", "e");
        System.out.println(Arrays.toString(strings));
        System.out.println(errors.toString());
    }

    public static void findAndReplace(String[] strings, String find, String replace) {
        boolean flag = true;
        for (int i = 0; i < strings.length; i++)
            if (strings[i].equals(find)) {
                strings[i] = replace;
                flag = false;
            }
        if (flag) errors.add("Строка '" + find + "' не найдена!");
    }
}
