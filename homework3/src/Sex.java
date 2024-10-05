public enum Sex {
    f,
    m;

    public static Sex parse(String str) {
        if (str == null || str.isBlank() || str.length() > 1) throw new SexFormatException();
        return switch (str.charAt(0)) {
            case 'f' -> Sex.f;
            case 'm' -> Sex.m;
            default -> throw new SexFormatException();
        };
    }
}
