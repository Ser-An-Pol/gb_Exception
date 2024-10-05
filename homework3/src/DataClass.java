import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataClass {
    private String lastName;
    private String firstName;
    private String secondName;
    private LocalDate birthDay;
    private long phoneNumber;
    private Sex sex;

    private String incoming;
    private ErrorCode errorCode;

    private String[] dataArray;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public DataClass() {
    }

    public DataClass(String incoming) {
        setIncoming(incoming);
    }

    public void setIncoming(String incoming) {
        this.incoming = incoming;
    }

    public void create() {
        switch (SplitIncoming()) {
            case 2 -> {
                errorCode = ErrorCode.DataString_Is_Null;
                return;
            }
            case 1 -> {
                errorCode = ErrorCode.AmountOfData_More_Than_Pattern;
                return;
            }
            case -1 -> {
                errorCode = ErrorCode.AmountOfData_Less_Than_Pattern;
                return;
            }
        }

        try {
            setLastName();
        } catch (EmptyStringException e) {
            errorCode = ErrorCode.LastName_Is_Empty;
            return;
        }
        try {
            setFirstName();
        } catch (EmptyStringException e) {
            errorCode = ErrorCode.FirstName_Is_Empty;
            return;
        }
        try {
            setSecondName();
        } catch (EmptyStringException e) {
            errorCode = ErrorCode.SecondName_Is_Empty;
            return;
        }
        try {
            setBirthDay();
        } catch (DateTimeParseException e) {
            errorCode = ErrorCode.Wrong_Format_Of_Date;
            return;
        }

        try {
            setPhoneNumber();
        } catch (NumberFormatException e) {
            errorCode =  ErrorCode.Wrong_Format_Of_PhoneNumber;
            return;
        }

        try {
            setSex();
        } catch (SexFormatException e) {
            errorCode = ErrorCode.Wrong_Format_Of_Sex;
            return;
        }

        errorCode = ErrorCode.Success;
    }

    private int SplitIncoming() {
        if (incoming == null) return 2;
        dataArray = incoming.split(" ");
        int count = dataArray.length - 6;
        return (count > 0) ? 1 : (count < 0) ? -1 : 0;
    }

    private void setLastName() throws EmptyStringException {
        if (dataArray[0].isBlank()) throw new EmptyStringException();
        this.lastName = dataArray[0];
    }

    private void setFirstName() throws EmptyStringException  {
        if (dataArray[1].isBlank()) throw new EmptyStringException();
        this.firstName = dataArray[1];
    }

    private void setSecondName() throws EmptyStringException {
        if (dataArray[2].isBlank()) throw new EmptyStringException();
        this.secondName = dataArray[2];
    }

    private void setBirthDay() throws DateTimeParseException {
        this.birthDay = LocalDate.parse(dataArray[3], dateTimeFormatter);
    }

    private void setPhoneNumber() throws NumberFormatException {
        this.phoneNumber = Long.parseLong(dataArray[4]);
    }

    public void setSex() throws SexFormatException{
        this.sex = Sex.parse(dataArray[5]);
    }

    public String getOutcoming() {
        return "<" + lastName + ">" +
                "<" + firstName + ">" +
                "<" + secondName + ">" +
                "<" + birthDay.format(dateTimeFormatter) + ">" +
                "<" + phoneNumber + ">" +
                "<" + sex + ">\n";
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getLastName() {
        return lastName;
    }
}
