package Zurl.DataStructure;

/**
 * Created by furry on 1/31/2016.
 */
public class PriorityQueue {
    Heap elementData = new Heap();

    public void push (int x){
        elementData.insert(x);
    }

    public int front(){
        return elementData.getMax();
    }

    public void pop(){
        elementData.popMax();
    }

    public int size(){
        return elementData.getLength();
    }

    public boolean isEmpty(){
        return elementData.getLength() == 0;
    }

    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue();
        pq.push(15);
        pq.push(25);
        pq.push(18);
        pq.push(7);
        while(!pq.isEmpty()){
            System.out.println(pq.front());
            pq.pop();
        }
    }
}
