package Zurl.DataStructure.Maps;

/**
 * Created by zcy on 4/5/2016.
 */
public abstract class AbstractBinarySearchTree <T extends Comparable,Y>
    implements Map<T,Y> {

    static class BaseNode{
        BaseNode left,right,parent;
        Object key;
        Object value;
        BaseNode(Object _key,Object _value,BaseNode _parent) {
            key = _key;
            value = _value;
            parent = _parent;
        }
    }

    abstract protected BaseNode BaseNodeFactory(Object _key,Object _value,BaseNode _parent);
    abstract protected void afterFind(BaseNode now);
    abstract protected void afterInsert(BaseNode now);

    protected BaseNode root;
    int size = 0;

    enum Direction{
        left,right;

    }

    protected void rotate(BaseNode now,Direction dir){
        //Link p<->p.p
        //System.out.print("1");
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
    }

    @SuppressWarnings("unchecked")
    private void insert(T key,Y value,BaseNode now){
        if(key.compareTo(now.key) == 0){
            now.value = value;
        }else{
            if(key.compareTo(now.key) < 0){
                if(now.left == null){now.left = BaseNodeFactory(key,value,now);afterInsert(now);size++;}
                else insert(key,value,now.left);
            }else{
                if(now.right == null){now.right = BaseNodeFactory(key,value,now);afterInsert(now);size++;}
                else insert(key,value,now.right);
            }
        }
    }


    @SuppressWarnings("unchecked")
    private Y find(T key,BaseNode now){
        if(now == null)throw new RuntimeException();
        if(key.compareTo(now.key) == 0){afterFind(now); return (Y)now.value;}
        else{
            if(key.compareTo(now.key) < 0){
                if(now.left != null)return find(key,now.left);
            }else{
                if(now.right != null)return find(key,now.right);
            }
        }
        throw new RuntimeException();
    }

    public void set(T key,Y value){
        if(root == null){root = BaseNodeFactory(key,value,BaseNodeFactory(new Object(),new Object(),null)); root.parent.left = root; size ++;}
        else insert(key,value,root);
    }

    public Y get(T key){
        return find(key,root);
    }

    public boolean hasKey(T key){
        try{
            find(key,root);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void clear(){
        size = 0;
        root = null;
    }

    public int size() {
        return size;
    }

}
