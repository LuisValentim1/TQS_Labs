import java.util.ArrayList;
import java.util.NoSuchElementException;

public class tqs_stack <T>{

    private ArrayList<T> stackLine = new ArrayList<T>();
    private boolean bounded = false;
    private int boundRange;

    public void boundTo(int range){
        this.bounded = true;
        this.boundRange = range;
    }

    public void unbound(){
        this.bounded = false;
        this.boundRange = Integer.parseInt(null);
    }

    public boolean isEmpty(){
        if(stackLine.size()>0){
            return false;
        }
        return true;
    }

    public int size(){
        return stackLine.size();
    }

    public void push(T obj){
        if(this.bounded == true && this.size() == this.boundRange) {
            throw new IllegalStateException();
        }
        stackLine.add(obj);
    }

    public T pop(){
        if(this.isEmpty()) throw new NoSuchElementException();
        T element = stackLine.get(stackLine.size()-1);
        stackLine.remove(stackLine.size()-1);
        return element;
    }

    public T peek(){
        if(this.isEmpty()) throw new NoSuchElementException();
        return stackLine.get(stackLine.size()-1);
    }
}
