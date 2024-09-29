package task1;

//todo Задание 1. Проверка корректности даты
//  Напишите метод, который проверяет, является ли введенная строка корректной
//  датой в формате "YYYY-MM-DD". Дата должна быть в пределах от 0001-01-01
//  до 9999-12-31. Если дата корректна, возвращайте её. Если нет — сообщение об ошибке.

import java.util.Scanner;

public class Main {
    public static final int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data in format YYYY-MM-DD:");
        String line;
        try {
            line = scanner.nextLine();
            testData(line);
            System.out.println(line);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testData(String line) throws IllegalArgumentException {
        if (line.length() != 10) throw new IllegalArgumentException("Wrong format of data!");
        String[] periods = line.split("-");
        if (periods.length != 3) throw new IllegalArgumentException("Wrong format of data!");
        int yyyy, mm, dd;
        try {
            yyyy = Integer.parseInt(periods[0]);
            mm = Integer.parseInt(periods[1]);
            dd = Integer.parseInt(periods[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong format of data!");
        }
        if (yyyy < 1 || yyyy > 9999)
            throw new IllegalArgumentException("Wrong value of year!");
        if (mm < 1 || mm > 12)
            throw new IllegalArgumentException("Wrong value of month!");
        if (dd < 1 || months[mm-1] < dd || (!isLeap(yyyy) && mm == 2 && dd > 28))
            throw new IllegalArgumentException("Wrong value of day!");
    }

    public static boolean isLeap(int year) {
        if (year % 400 == 0) return true;
        else if (year % 100 == 0) return false;
        else return year % 4 == 0;
    }
}

