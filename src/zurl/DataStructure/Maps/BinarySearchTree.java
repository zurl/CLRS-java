package Zurl.DataStructure.Maps;

/**
 * Created by zcy on 3/31/2016.
 */
public class BinarySearchTree <T extends Comparable,Y>
            extends AbstractBinarySearchTree<T,Y>{
    @Override
    protected BaseNode BaseNodeFactory(Object _key, Object _value, BaseNode _parent) {
        return new BaseNode(_key,_value,_parent);
    }

}
