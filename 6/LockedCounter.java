import java.util.concurrent.locks.ReentrantLock;

public class LockedCounter extends Counter {

    ReentrantLock lock = new ReentrantLock();
    
    @Override
    public void Increment()
    {
        lock.lock();
        try{
            number++;
        }
        finally{
            lock.unlock();
        }
    }

    @Override
    public void Decrement()
    {
        lock.lock();
        try{
            number--;
        }
        finally{
            lock.unlock();
        }
    }

}