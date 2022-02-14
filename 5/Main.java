public class Main {
    public static void main(String[] args) {
        // WriteSymbols();
        WriteWithSync();

    }

    static void WriteSymbols(){

        IWriter writer = new Writer();
        WriterThread first = new WriterThread(writer,'-');
        WriterThread second = new WriterThread(writer,'|');
        first.start();
        second.start();
    }

    static void WriteWithSync(){

        IWriter syncWriter = new SyncWriter();
        WriterThread firstSync = new WriterThread(syncWriter,'-');
        WriterThread secondSync = new WriterThread(syncWriter,'|');
        firstSync.start();
        secondSync.start();

    }
    
}
