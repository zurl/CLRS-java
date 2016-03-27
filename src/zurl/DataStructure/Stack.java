package Zurl.DataStructure;

/**
 * Created by zcy on 3/26/2016.
 */
public class Stack {
    Vector data = new Vector();
    public Stack push(int x){
        data.push(x);
        return this;
    }
    public int size(){
        return data.length;
    }
    public int top(){
        return data.get(data.length -1);
    }
    public boolean isEmpty(){
        return data.getLength() == 0;
    }
    public Stack pop(){
        data.pop();
        return this;
    }
}
