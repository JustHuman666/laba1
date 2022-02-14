public class SyncBlockedCounter extends Counter {
    @Override
    public void Increment()
    {
        synchronized(this)
        {
            number++;
        }
    }

    @Override
    public void Decrement()
    {
        synchronized(this)
        {
            number--;
        }
    }
    
}
