public class Program {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        BaseCounter();
        // SyncronizedCounter();
        // SyncronizedLockedCounter();
        // SyncronizedBlockedCounter();
        System.out.println((double) (System.currentTimeMillis() - startTime) + " milliseconds");
        
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
        CounterThread increase2 = new CounterThread(true,counter);
        CounterThread decrease2 = new CounterThread(false,counter);

        increase.start();
        decrease.start();
        increase2.start();
        decrease2.start();

        increase.join();
        decrease.join();
        increase2.join();
        decrease2.join();

        counter.Write();
    }

    static void SyncronizedLockedCounter() throws InterruptedException{
        ICounter counter = new LockedCounter();
        CounterThread increase = new CounterThread(true,counter);
        CounterThread decrease = new CounterThread(false,counter);
        CounterThread increase2 = new CounterThread(true,counter);
        CounterThread decrease2 = new CounterThread(false,counter);

        increase.start();
        decrease.start();
        increase2.start();
        decrease2.start();

        increase.join();
        decrease.join();
        increase2.join();
        decrease2.join();

        counter.Write();
    }

    static void SyncronizedBlockedCounter() throws InterruptedException{
        ICounter counter = new SyncBlockedCounter();
        CounterThread increase = new CounterThread(true,counter);
        CounterThread decrease = new CounterThread(false,counter);
        CounterThread increase2 = new CounterThread(true,counter);
        CounterThread decrease2 = new CounterThread(false,counter);

        increase.start();
        decrease.start();
        increase2.start();
        decrease2.start();

        increase.join();
        decrease.join();
        increase2.join();
        decrease2.join();

        counter.Write();
    }
    
}