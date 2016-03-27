package Zurl.DataStructure;

/**
 * Created by zcy on 3/26/2016.
 */
public class Queue {
    LinkedList data= new LinkedList();
    public Queue push(int x){
        data.pushfront(x);
        return this;
    }
    public int size(){
        return data.length();
    }
    public int front(){
        return data.top();
    }
    public boolean isEmpty(){
        return data.length() == 0;
    }
    public Queue pop(){
        data.pop();
        return this;
    }
}
