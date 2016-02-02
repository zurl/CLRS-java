package Zurl.DataStructure;


import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * Created by furry on 1/31/2016.
 */
public class Vector implements Iterable {
    private int[] elementData;

    public int getLength() {
        return length;
    }

    int length;

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < length;
            }

            @Override
            public Object next() {
                return elementData[pos++];
            }
        };
    }

    public Vector(int length) {
        this.length = length;
        elementData = new int[length];
    }

    public Vector() {
        this.length = 0;
        elementData = new int[1];
    }

    public void expandElementDataSpace() {
        int[] newSpace = new int[(int) (elementData.length * 2.718281828)];
        if (length != 0)
            System.arraycopy(elementData, 0, newSpace, 0, length);
        elementData = newSpace;
    }

    //@SuppressWarnings("unchecked")
    public int get(int pos) {
        if (pos > length - 1)
            throw new ArrayIndexOutOfBoundsException("RT");
        return elementData[pos];
    }

    //@SuppressWarnings("unchecked")
    public void set(int pos, int value) {
        if (pos > length - 1)
            throw new ArrayIndexOutOfBoundsException("RT");
        elementData[pos] = value;
    }

    public void push(int value) {
        if (length >= elementData.length) {
            expandElementDataSpace();
        }
        elementData[++length - 1] = value;
    }

    public void pop() {
        length--;
    }

    //@SuppressWarnings("unchecked")
    public int[] getInnerArray() {
        return elementData;
    }

    public static void main(String[] args) {
        Vector a = new Vector();
        a.push(1);
        a.push(2);
        System.out.println(a.get(0));
        System.out.println(a.get(1));
        a.push(1);
        a.push(2);
        System.out.println(a.get(2));
        System.out.println(a.get(3));
    }
}
