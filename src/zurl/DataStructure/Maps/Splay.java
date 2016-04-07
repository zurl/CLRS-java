package Zurl.DataStructure.Maps;

import java.math.BigInteger;

/**
 * Created by zcy on 3/31/2016.
 */
public class Splay<T extends Comparable,Y>
    extends AbstractBinarySearchTree<T,Y>{


    @Override
    protected BaseNode BaseNodeFactory(Object _key, Object _value, BaseNode _parent) {
        return new BaseNode(_key,_value,_parent);

    }

    @Override
    protected void afterFind(BaseNode now) {
        splay(now);
    }


    private boolean isLeft(BaseNode now){
        return now == now.parent.left;
    }

    private void splay(BaseNode now){
        while(root != now){
            if(now.parent == root){
                if(isLeft(now))rotate(now,Direction.right);
                else rotate(now,Direction.left);
                root = now;
            }else{
                if(isLeft(now)){
                    if(isLeft(now.parent)){
                        rotate(now.parent,Direction.right);
                        rotate(now,Direction.right);
                    }else{
                        rotate(now,Direction.right);
                        rotate(now,Direction.left);
                    }
                }else{
                    if(isLeft(now.parent)){
                        rotate(now,Direction.left);
                        rotate(now,Direction.right);
                    }else{
                        rotate(now.parent,Direction.left);
                        rotate(now,Direction.left);
                    }
                }
                if(now.parent.parent == null)root = now;
            }
        }
    }

}
