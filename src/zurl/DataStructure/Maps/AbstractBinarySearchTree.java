package Zurl.DataStructure.Maps;

import Zurl.Search.BinarySearch;

/**
 * Created by zcy on 4/5/2016.
 */
public abstract class AbstractBinarySearchTree <T extends Comparable,Y>
    implements Map<T,Y> {

    static class BaseNode{
        BaseNode left,right,parent;
        Object key;
        Object value;
        int size;
        BaseNode(Object _key,Object _value,BaseNode _parent) {
            key = _key;
            value = _value;
            parent = _parent;
            size = 1;
        }
    }

    abstract protected BaseNode BaseNodeFactory(Object _key,Object _value,BaseNode _parent);
    protected void afterFind(BaseNode now){}
    protected BaseNode afterInsert(BaseNode now){ return now.parent;}
    protected void beforeDelete(BaseNode now){}
    protected void beforeRotate(BaseNode now){}

    protected BaseNode root;

    enum Direction{
        left,right
    }

    protected BaseNode rotate(BaseNode now,Direction dir){
        //Link p<->p.p
        //System.out.print("1");
        beforeRotate(now);
        BaseNode p = now.parent;
        now.parent = p.parent;
        if(p.parent.left == p ) p.parent.left = now;
        else p.parent.right = now;
        //Link now.son <-> now
        if(dir == Direction.right){
            p.left = now.right;
            if(now.right != null) p.left.parent = p;
            now.right = p;

        }else{
            p.right = now.left;
            if(now.left != null)p.right.parent = p;
            now.left = p;
        }
        p.parent = now;
        now.size = p.size;
        p.size = getNodeSize(p.left) + getNodeSize(p.right) + 1;
        return now;
    }

    private int getNodeSize(BaseNode x){
        return x==null?0:x.size;
    }

    @SuppressWarnings("unchecked")
    private BaseNode insert(T key,Y value,BaseNode now){
        if(key.compareTo(now.key) == 0){
            now.value = value;
        }else{
            if(key.compareTo(now.key) < 0){
                if(now.left == null) now.left = BaseNodeFactory(key,value,now);
                else now.left = insert(key,value,now.left);
                now.size = getNodeSize(now.left) + getNodeSize(now.right) + 1;
                now = afterInsert(now.left);
            }else{
                if(now.right == null) now.right = BaseNodeFactory(key,value,now);
                else now.right = insert(key,value,now.right);
                now.size = getNodeSize(now.left) + getNodeSize(now.right) + 1;
                now = afterInsert(now.right);
            }

        }
        return now;
    }

    @SuppressWarnings("unchecked")
    protected BaseNode find(T key,BaseNode now,boolean doAfter){
        if(now == null)throw new RuntimeException();
        if(key.compareTo(now.key) == 0){if(doAfter)afterFind(now); return now;}
        else{
            if(key.compareTo(now.key) < 0){
                if(now.left != null)return find(key,now.left,doAfter);
            }else{
                if(now.right != null)return find(key,now.right,doAfter);
            }
        }
        throw new RuntimeException();
    }

    private BaseNode getFirstNullLeft(BaseNode now){
        while(now.left != null)now = now.left;
        return now;
    }

    protected void move(BaseNode from,BaseNode to){
        if(from.parent.parent == null)root = to;
        else if(from.parent.left == from)from.parent.left = to;
        else from.parent.right = to;
        if(to!=null)to.parent = from.parent;
    }

    @Override
    public void delete(T key) throws Exception {
        BaseNode now = find(key,root,false);
        beforeDelete(now);
        boolean isRoot = (now == root);
        if(now.left == null)move(now,now.right);
        else if(now.right == null)move(now,now.left);
        else {
            BaseNode pos = getFirstNullLeft(now.right);
            if(pos.parent != now){
                move(pos,pos.right);
                pos.right = now.right;
                pos.right.parent = pos;
            }
            move(now,pos);
            pos.left = now.left;
            now.left.parent = pos;

        }
    }

    public void set(T key, Y value){
        if(root == null){
            root = BaseNodeFactory(key,value,BaseNodeFactory(new Object(),new Object(),null));
            root.parent.left = root;
        }
        else root = insert(key,value,root);
    }

    @SuppressWarnings("unchecked")
    public Y get(T key){
        return (Y)(find(key,root,true).value);
    }

    public boolean hasKey(T key){
        try{
            find(key,root,true);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public int order(T key) throws Exception {
        BaseNode now = find(key,root,true);
        return now.size - getNodeSize(now.right);
    }

    public void clear(){
        root = null;
    }

    public int size() {
        return root == null?0:root.size;
    }

    public static void main(String[] args){
        Map<String,String> mp = new RedBackTree<>();
        mp.set("a","a");
        mp.set("b","a");
        mp.set("c","a");
        mp.set("d","a");
        mp.set("e","a");
        mp.set("f","a");
        mp.set("g","a");
        mp.set("h","a");
    }
}
