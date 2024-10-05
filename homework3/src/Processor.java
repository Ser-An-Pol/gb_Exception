public class Processor {

    public void run() {
        DataClass dataClass = new DataClass();
        Storage storage = new Storage(dataClass);
        Viewer viewer = new Viewer(dataClass, storage);

        do {
            Viewer.printGetData();
            dataClass.setIncoming(Reader.getString());
            dataClass.create();

            while (dataClass.getErrorCode() != ErrorCode.Success) {
                viewer.printErrorData();
                Viewer.printGetDataAgain();
                dataClass.setIncoming(Reader.getString());
                dataClass.create();
            }

            storage.writeFile();
            viewer.printErrorStorage();
            if (storage.getErrorCode() != ErrorCode.Success) System.exit(-1);
            Viewer.printAskNewData();
        } while (Reader.getAnswer());
    }
}
