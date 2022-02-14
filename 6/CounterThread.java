public class CounterThread extends Thread {

    
    private ICounter counter;
    public boolean ifIncrease;

    public CounterThread(boolean ifIncrease,ICounter counter) {
        this.counter = counter;
        this.ifIncrease = ifIncrease;
        
    }

    @Override
    public void run() {
        for (int i = 1; i < 100000; i++) {
            if (ifIncrease) {
                this.counter.Increment();
            }
            else{
                this.counter.Decrement();
            }
            
        }
    }
}
