package Zurl.DataStructure;

import java.util.Comparator;

/**
 * Created by zcy on 3/26/2016.
 */
public class LinkedList {
    static public class Node{
        public int value;
        public Node prev;
        public Node(int val,Node pre){
            prev = pre;
            value = val;
        }
    }

    public Node getBegin() {
        return begin;
    }

    public Node getEnd() {
        Node x = begin;
        while(x!=null && x.prev!=null)x=x.prev;
        return x;
    }

    Node begin;
    Node end;

    public int length(){
        Node x = begin;int len = 0;
        while(x!=null && x.prev!=null){x=x.prev;len ++;}
        return x==null?len:len+1;
    }
    public boolean isEmpty(){
        return begin == null;
    }

    LinkedList push(int x){
        begin = new Node(x,begin);
        if(begin.prev == null)end = begin;
        return this;
    }
    LinkedList pushfront(int x){
        if(end == null){
            begin = end= new Node(x,null);
        }else{
            end.prev = new Node(x,null);
            end = end.prev;
        }
        return this;
    }

    public LinkedList pop(){
        if(begin!=null)begin = begin.prev;
        return this;
    }

    public int top(){
        return begin.value;
    }
    public Node search(int value){
        Node x = begin;
        while(x!=null && x.value != value) x=x.prev;
        return x;
    }

    boolean exchange(Node x){
        if(x.prev != null){
            if(x.value > x.prev.value){
                int t = x.value;
                x.value = x.prev.value;
                x.prev.value = t;
                return true;
            }
            return exchange(x.prev);
        }
        return false;
    }

    public LinkedList sort(){
        while(exchange(begin));
        return this;
    }

    private Node inverseNode(Node x){
        if( x.prev != null )(inverseNode(x.prev)).prev = x;
        else {begin.prev = null; begin = x;}
        return x;
    }
    public LinkedList inverse(){
        inverseNode(begin);
        return this;
    }

    public int[] toArray(){
        int[] ret = new int[this.length()];
        Node x = begin;
        for(int i=0;i<=ret.length-1;i++){
            ret[i] = x.value;
            x = x.prev;
        }
        return ret;
    }

}
