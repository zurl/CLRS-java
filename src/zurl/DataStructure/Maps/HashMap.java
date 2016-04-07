package Zurl.DataStructure.Maps;

/**
 * Created by zcy on 3/30/2016.
 */



public class HashMap <T,Y>
implements Map<T,Y>
{
    static class Node{
        Object value;
        Object key;
        Node next;
        Node(Object _key,Object _value,Node _next){
            key = _key;
            value = _value;
            next = _next;
        }
    }
    private Node[] data;
    private int capacity = 4;


    private int size = 0;

    HashMap(){
        data = new Node[4];
    }

    private int getHashCode(int hashCode){
        return (hashCode & 0x7FFFFFFF) % capacity;
    }

    @Override
    public void delete(T key) throws Exception {
        Node now = data[getHashCode(key.hashCode())];
        if(now.key.equals(key)) data[getHashCode(key.hashCode())] = now.next;
        else {
            while(now.next != null){
                if(now.next.key.equals(key)){
                    now.next = now.next.next;
                    return;
                }
            }
            throw new RuntimeException();
        }
    }

    @SuppressWarnings("unchecked")
    private void resize(int newsize){
        Node[] old = data;
        data = new Node[newsize];
        capacity = newsize;
        size = 0;
        for(Node x : old){
            while(x != null){
                set((T)x.key,(Y)x.value);
                x = x.next;
            }
        }
    }

    public void set(T key,Y value){
        if(size > capacity * 0.75)resize(capacity * 2);
        int code = getHashCode(key.hashCode());
        if(data[code] == null){
            data[code] = new Node(key,value,null); size ++;
        }else {
            Node now = data[code];
            while (now != null) {
                if (now.key.equals(key)) {
                    now.value = value;
                    return;
                }
                if (now.next == null) {
                    now.next = new Node(key, value, null);size ++;
                    return;
                }
                now = now.next;
            }
        }
    }
    @SuppressWarnings("unchecked")
    public Y get(T key){
        Node now = data[getHashCode(key.hashCode())];
        while(now != null){
            if(now.key.equals(key))return (Y)now.value;
            now = now.next;
        }
        return null;
    }
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
