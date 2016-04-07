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
    protected void beforeDelete(BaseNode now) {
        while(now.left != null && now.right !=null){
            rotate(now.left,Direction.right);
        }
    }

    @Override
    protected BaseNode afterInsert(BaseNode now) {
        if(now!=root) return Heapify(now);
        else return now.parent;
    }

    @SuppressWarnings("unchecked")
    protected BaseNode Heapify(BaseNode now){
        if(((T)now.key).compareTo((T)now.parent.key) > 0){
            if(now == now.parent.left)rotate(now,Direction.right);
            else rotate(now,Direction.left);
            return now;
        }
        else return now.parent;
    }

}
