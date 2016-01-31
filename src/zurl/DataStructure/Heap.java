package zurl.DataStructure;

/**
 * Created by furry on 1/31/2016.
 */

public class Heap {

    //Heap Data Structure

    int[] v;

    public Heap(int n) {
        v = new int[n];
    }

    public Heap(int[] v) {
        this.v = v;
        makeHeap(v);
    }


    //Heap Algorithm

    static public int getLeftSon(int x) {
        return (x + 1) * 2 - 1;
    }

    static public int getRightSon(int x) {
        return 2 * (x + 1);
    }
   static public int getParent(int x) {
        return (x + 1) / 2 - 1;
    }

    static public void maxHeapifyWithoutRecursive(int[] a, int x, int length) {
        while (x < length / 2) { //Is the Son Node
            if (getLeftSon(x) < length && a[getLeftSon(x)] > a[x]) {
                if (getRightSon(x) < length && a[getRightSon(x)] > a[x]) {
                    if (a[getRightSon(x)] < a[getLeftSon(x)]) {
                        //l>r>x
                        int t = a[x];
                        a[x] = a[getLeftSon(x)];
                        a[getLeftSon(x)] = t;
                        x = getLeftSon(x);
                    } else {
                        //r>l>x
                        int t = a[x];
                        a[x] = a[getRightSon(x)];
                        a[getRightSon(x)] = t;
                        x = getRightSon(x);

                    }
                } else {
                    //l>x>r
                    int t = a[x];
                    a[x] = a[getLeftSon(x)];
                    a[getLeftSon(x)] = t;
                    x = getLeftSon(x);
                }
            } else if (getRightSon(x) < length && a[getRightSon(x)] > a[x]) {
                //r>x>l || r>l>x
                int t = a[x];
                a[x] = a[getRightSon(x)];
                a[getRightSon(x)] = t;
                x = getRightSon(x);
            }
            //x>l>r || x>r>l
        }
    }

    static public void maxHeapify(int[] a, int x, int length) {
        if (getLeftSon(x) < length && a[getLeftSon(x)] > a[x]) {
            if (getRightSon(x) < length && a[getRightSon(x)] > a[x]) {
                if (a[getRightSon(x)] < a[getLeftSon(x)]) {
                    //l>r>x
                    int t = a[x];
                    a[x] = a[getLeftSon(x)];
                    a[getLeftSon(x)] = t;
                    maxHeapify(a, getLeftSon(x), length);
                } else {
                    //r>l>x
                    int t = a[x];
                    a[x] = a[getRightSon(x)];
                    a[getRightSon(x)] = t;
                    maxHeapify(a, getRightSon(x), length);

                }
            } else {
                //l>x>r
                int t = a[x];
                a[x] = a[getLeftSon(x)];
                a[getLeftSon(x)] = t;
                maxHeapify(a, getLeftSon(x), length);
            }
        } else if (getRightSon(x) < length && a[getRightSon(x)] > a[x]) {
            //r>x>l || r>l>x
            int t = a[x];
            a[x] = a[getRightSon(x)];
            a[getRightSon(x)] = t;
            maxHeapify(a, getRightSon(x), length);
        }
        //x>l>r || x>r>l
    }

    static public void insertIntoHeap(int[] a, int pos) {
        int length = pos + 1;
        while (pos != 0) {
            pos = getParent(pos);
            maxHeapifyWithoutRecursive(a, pos, length);
        }
    }

    static public void makeHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--)
            maxHeapifyWithoutRecursive(a, i, a.length);
    }

    static public void makeHeapWithInsertion(int[] a) {
        for (int i = 0; i <= a.length - 1; i++)
            insertIntoHeap(a, i);
    }

    static public boolean isMaxHeap(int[] a) {
        for (int i = 0; i <= a.length; i++){
            if(getLeftSon(i)<a.length){
                if (a[i] < a[getLeftSon(i)])return false;
            }else return true;
            if(getRightSon(i)<a.length){
                if (a[i] < a[getRightSon(i)])return false;
            }else return true;
        }
        return true;
    }
    static public void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        makeHeap(test);
        for (int x : test)
            System.out.println(x);
        System.out.println(isMaxHeap(test));
    }
}
