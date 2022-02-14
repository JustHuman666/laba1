public class WriterThread extends Thread{

    public IWriter writer;
    public char symbol = ' ';

    public WriterThread(IWriter writer,char symbol) {
        this.writer = writer;
        this.symbol = symbol;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 100; i++) {

                writer.Write(symbol);

                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
            System.out.println("Something went wrong" + ex.getMessage());
        }
    }
}