
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Storage {
    private final DataClass dataClass;
    private String fileName;
    private ErrorCode errorCode;
    private Exception exception;

    public Storage(DataClass dataClass) {
        this.dataClass = dataClass;
    }

    public void writeFile() {
        fileName = dataClass.getLastName() + ".data";
        try {
            Path path = Path.of(fileName);
            Files.write(path, dataClass.getOutcoming().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            errorCode = ErrorCode.Success;
        } catch (Exception e) {
            exception = e;
            errorCode = ErrorCode.Error_Of_FileAccess;
        }
    }

    public String getFileName() {
        return fileName;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Exception getException() {
        return exception;
    }
}
