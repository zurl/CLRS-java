package Zurl.DataStructure.Maps;

/**
 * Created by zcy on 4/5/2016.
 */
public class Treap <T extends Comparable<T>,Y>
    extends AbstractBinarySearchTree<T,Y>{

    public static class Node
        extends BaseNode{
        int mark;
        Node(Object _key, Object _value, BaseNode _parent) {
            super(_key, _value, _parent);
            mark = (int)(Math.random()*1000000);
        }
    }

    @Override
    protected BaseNode BaseNodeFactory(Object _key, Object _value, BaseNode _parent) {
        return new Node(_key,_value,_parent);
    }

    @Override
    protected void afterFind(BaseNode now) {
        //do nothing
    }

    @Override
    protected void afterInsert(BaseNode now) {
        Heapify(now);
    }

    @SuppressWarnings("unchecked")
    protected void Heapify(BaseNode now){
        while(now != root){
            if(((Node)now).mark < ((Node)((Node)now).parent).mark){
                if(now == now.parent.left)rotate(now,Direction.right);
                else rotate(now,Direction.left);
                if(now.parent.parent == null)root = now;
            }else return;
        }
    }

}
