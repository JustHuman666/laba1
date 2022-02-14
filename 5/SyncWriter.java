public class SyncWriter implements IWriter {

    
    private Object lock = new Object();
    private int amountOfSymbols;
    private char currentSymbol;

    public void Write(char symbol) {

        synchronized (lock) {
            if (currentSymbol == symbol) {
                try
                {
                    lock.wait();
                } 
                catch (InterruptedException ex) {
                    System.out.println("Something went wrong"+ ex.getMessage());
                }
            }

            amountOfSymbols++;

            if (amountOfSymbols % 50 == 0) {
                System.out.print('\n');
            }

            currentSymbol = symbol;
            lock.notify();
            System.out.print(symbol);
        }
    }
    
}
