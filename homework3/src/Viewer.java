
public class Viewer {
    DataClass dataClass;
    Storage storage;

    public Viewer(DataClass dataClass, Storage storage) {
        this.dataClass = dataClass;
        this.storage = storage;
    }

    public static void printGetData() {
        System.out.println("Введите строку данных...");
    }

    public static void printGetDataAgain() {
        System.out.println("Введите строку данных снова...");
    }

    public static void printAskNewData() {
        System.out.println("Хотите ввести еще данные? (да - y/Y/д/Д; нет - любой символ)");
    }

    public void printErrorData() {
        switch (dataClass.getErrorCode()) {
            case LastName_Is_Empty -> System.out.println("Поле \"Фвмилия\" - пустое");
            case FirstName_Is_Empty -> System.out.println("Поле \"Имя\" - пустое");
            case SecondName_Is_Empty -> System.out.println("Поле \"Отчество\" - пустое");
            case Wrong_Format_Of_Date -> System.out.println("Неверный формат даты рождения. Правильный формат: dd.MM.yyyy");
            case DataString_Is_Null -> System.out.println("Строка данных - null");
            case Wrong_Format_Of_Sex -> System.out.println("Пол задан в неверном формате. Задайте 'm' или 'f'");
            case Wrong_Format_Of_PhoneNumber -> System.out.println("Неверный формат номера телефона. Введите только цифры номера");
            case AmountOfData_Less_Than_Pattern -> System.out.println("Количество полей данных в строке недостаточно");
            case AmountOfData_More_Than_Pattern -> System.out.println("Количество полей данных в строке избыточно");
            case Success -> System.out.println("Загрузка данных прошла успешно!");
        }
    }

    public void printErrorStorage() {
        switch (storage.getErrorCode()) {
            case Error_Of_FileAccess -> {
                System.out.println("Ошибка записи в файл: " + storage.getFileName());
                storage.getException().printStackTrace();
            }
            case Success -> System.out.println("Запись данных прошла успешно!");
        }
    }
}
