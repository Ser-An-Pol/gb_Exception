package homework.task1;

//todo Задание 1. Преобразование строки в число
//  Реализуйте метод convertAndSum, который принимает массив строк, каждая
//      из которых должна быть преобразована в целое число. Метод возвращает
//      сумму всех чисел. Если хотя бы одна строка не может быть преобразована в
//      число, метод должен выбросить исключение NumberFormatException.
//  Дополнительно, если сумма чисел превышает 100, выбрасывайте
//      ArithmeticException с сообщением "Превышен лимит суммы".

public class Main {
    public static void main(String[] args) {
        String[] strings = {"10", "20", "60"};
        try {
            System.out.println(convertAndSum(strings, 100));
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int convertAndSum(String[] strings, int maxValue)
                                    throws NumberFormatException, ArithmeticException{
        int result = 0;
        for (String string : strings) result += stringToInt(string);
        if (result > maxValue) throw new ArithmeticException("Превышен лимит суммы");
        return result;
    }

    public static int stringToInt(String s) throws NumberFormatException {
        int result;
        try {
            result = Integer.parseInt(s);
        } catch (Exception e) {
            throw new NumberFormatException("Cтрока '" + s + "' не может быть преобразована в целое число");
        }
        return result;
    }
}
