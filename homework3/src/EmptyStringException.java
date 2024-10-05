public class EmptyStringException extends IllegalArgumentException{
    public EmptyStringException() {
    }

    public EmptyStringException(String s) {
        super(s);
    }
}
