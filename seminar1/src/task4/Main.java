package task4;

//todo Задание №4
//  Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
//  Метод должен пройтись по каждому элементу и проверить что он не равен null.
//  А теперь реализуйте следующую логику:
//      1. Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
//      2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 4, 6, 5, null, 8, 2};
        try {
            hasNull(arr);
            System.out.println("The array hasn't null elements!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean hasNull(Integer[] integers){
        boolean res = true;
        int len = integers.length;
        StringBuilder stringBuilder = new StringBuilder("The array has null elements at indexes: ");
        for (int i = 0; i < len; i++)
            if (integers[i] == null) {
                res = false;
                stringBuilder.append(i);
                stringBuilder.append(", ");
            }
        if (!res) throw new RuntimeException(stringBuilder.toString());
        return res;
    }
}
