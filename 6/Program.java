public class Program {
    public static void main(String[] args) throws InterruptedException {
        
        BaseCounter();
        // SyncronizedCounter();
        // SyncronizedLockedCounter();
        // SyncronizedBlockedCounter();
        
    }

    static void BaseCounter() throws InterruptedException{
        ICounter counter = new Counter();
        CounterThread increase = new CounterThread(true,counter);
        CounterThread decrease = new CounterThread(false,counter);

        increase.start();
        decrease.start();

        increase.join();
        decrease.join();

        counter.Write();
    }

    static void SyncronizedCounter() throws InterruptedException{

        ICounter counter = new SyncCounter();
        CounterThread increase = new CounterThread(true,counter);
        CounterThread decrease = new CounterThread(false,counter);

        increase.start();
        decrease.start();

        increase.join();
        decrease.join();

        counter.Write();
    }

    static void SyncronizedLockedCounter() throws InterruptedException{
        ICounter counter = new LockedCounter();
        CounterThread increase = new CounterThread(true,counter);
        CounterThread decrease = new CounterThread(false,counter);

        increase.start();
        decrease.start();

        increase.join();
        decrease.join();

        counter.Write();
    }

    static void SyncronizedBlockedCounter() throws InterruptedException{
        ICounter counter = new SyncBlockedCounter();
        CounterThread increase = new CounterThread(true,counter);
        CounterThread decrease = new CounterThread(false,counter);

        increase.start();
        decrease.start();

        increase.join();
        decrease.join();

        counter.Write();
    }
    
}