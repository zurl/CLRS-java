package zurl.Sort;

/**
 * Created by furry on 1/31/2016.
 */
public class HeapSort {
    public static void sort(int[] a){
        zurl.DataStructure.Heap.makeHeap(a);
        for(int i =a.length-1;i>=1;i--){
            //swap a[i]
            int t = a[i];
            a[i]=a[0];
            a[0]=t;
            //Heapify
            zurl.DataStructure.Heap.maxHeapifyWithoutRecursive(a,1,i);
        }
    }
    public static void main(String[] args){
        int[] test = {9,8,7,6,5,4,3};
        sort(test);
        for(int x : test)
            System.out.println(x);
    }
}
