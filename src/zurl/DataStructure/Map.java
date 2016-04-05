package Zurl.DataStructure;

/**
 * Created by zcy on 4/4/2016.
 */

public interface Map <T,Y> {
    void clear();
    int size();

    void set(T key,Y value);
    Y get(T key);
    boolean hasKey(T key);
}
