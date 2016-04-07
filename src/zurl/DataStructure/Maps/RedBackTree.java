package Zurl.DataStructure.Maps;

/**
 * Created by zcy on 4/6/2016.
 */
public class RedBackTree<T extends Comparable<T>,Y>
    extends AbstractBinarySearchTree<T,Y>{

    enum Color{
        black,red
    }

    class Node extends BaseNode{
        Color color;
        Node(Object _key, Object _value, BaseNode _parent) {
            super(_key, _value, _parent);
            color = Color.red;
        }
    }

    @SuppressWarnings("unchecked")
    private boolean isRed(BaseNode x){
        return x!=null && ((Node)x).color == Color.red;
    }

    @Override
    protected BaseNode BaseNodeFactory(Object _key, Object _value, BaseNode _parent) {
        //TODO:: fucking
        return new Node(_key,_value,_parent);
    }

    @Override
    protected void afterFind(BaseNode now) {
        //Do Nothing Here
    }

    @SuppressWarnings("unchecked")
    private void filpColor(Node now){
        now.color = Color.red;
        ((Node) now.left).color = Color.black;
        ((Node) now.right).color = Color.black;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected BaseNode afterInsert(BaseNode now) {
        Node p = (Node)(now.parent);
        if(isRed(p.right) && !isRed(p.left))p = (Node)rotate(p.right,Direction.left);
        if(isRed(p.left) && isRed(p.left.left))p = (Node)rotate(p.left,Direction.right);
        if(isRed(p.left) && isRed(p.right))filpColor(p);
        return p;
    }

    @Override
    protected void beforeDelete(BaseNode now) {
        //TODO:: complete it
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void beforeRotate(BaseNode now) {
        ((Node)now).color = ((Node)now.parent).color;
        ((Node)now.parent).color = Color.red;
    }
}
