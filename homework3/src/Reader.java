import java.util.Scanner;

public class Reader {
    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean getAnswer() {
        String s = getString();
        return switch (s.charAt(0)) {
            case 'y', 'Y', 'д', 'Д' -> true;
            default -> false;
        };
    }
}
