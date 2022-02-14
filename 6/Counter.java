public class Counter implements ICounter{
    
    public int number;

    public void Increment(){
        number++;
    };
    public void Decrement(){
        number--;
    };
    public void Write(){
        System.out.println(number);
    }

    
}
