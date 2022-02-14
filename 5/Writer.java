public class Writer implements  IWriter{
    
    private int amountOfSymbols;

    public void Write(char symbol){
        amountOfSymbols++;

        if (amountOfSymbols % 50 == 0) {
            System.out.print('\n');
        }
        System.out.print(symbol);
    }
    
}
