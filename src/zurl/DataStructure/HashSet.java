package Zurl.DataStructure;

/**
 * Created by zcy on 3/31/2016.
 */

public class HashSet <T> {
    static class Node{
        Object key;
        Node next;
        Node(Object _key,Node _next){
            key = _key;
            next = _next;
        }
    }
    private Node[] data;
    private int capacity = 1;


    private int size = 0;

    HashSet(){
        data = new Node[4];
    }

    private int getHashCode(int hashCode){
        return hashCode % capacity;
    }



    @SuppressWarnings("unchecked")
    private void resize(int newsize){
        Node[] old = data;
        data = new Node[newsize];
        capacity = newsize;
        size = 0;
        for(Node x : old){
            while(x != null){
                set((T)x.key);
                x = x.next;
            }
        }
    }

    public void set(T key){
        if(size > capacity * 0.75)resize(capacity * 2);
        int code = getHashCode(key.hashCode());
        if(data[code] == null){
            data[code] = new Node(key,null); size ++;
        }else {
            Node now = data[code];
            while (now != null) {
                if (now.key.equals(key)) {
                    return;
                }
                if (now.next == null) {
                    now.next = new Node(key,  null);size ++;
                    return;
                }
                now = now.next;
            }
        }
    }
    @SuppressWarnings("unchecked")
    public boolean hasKey(T key){
        Node now = data[getHashCode(key.hashCode())];
        while(now != null){
            if(now.key.equals(key))return true;
            now = now.next;
        }
        return false;
    }

    public void clear(){
        capacity = 4;
        size = 0;
        data = null;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public static void main(String[] args){

    }
}
