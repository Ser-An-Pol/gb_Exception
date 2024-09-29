package task2;

//todo Задача 2. Проверка строки на палиндром
//  Напишите метод, который проверяет, является ли введенная строка
//  палиндромом. Если строка палиндром, возвращайте "Palindrome". Если нет — "Not a palindrome".

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (isPalindrome(scanner.nextLine()))
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");
    }
    public static boolean isPalindrome(String string) {
        String s = string.toLowerCase(Locale.ROOT).replace(" ", "");
        int len = s.length();
        int half = len-- / 2;
        for (int i = 0; i <= len; i++)
            if (s.charAt(i) != s.charAt(len-i)) return false;
        return true;
    }
}

