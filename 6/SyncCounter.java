public class SyncCounter extends Counter{

    @Override
    public synchronized void Increment(){
        number++;
    };

    @Override
    public synchronized void Decrement(){
        number--;
    };
}
