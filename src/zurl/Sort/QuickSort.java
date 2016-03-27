package Zurl.Sort;

import java.util.function.*;

/**
 * Created by furry on 1/29/2016.
 */
public class QuickSort {
    public static int hoarePartition(int[] a, int l, int r) {
        //init
        int x = a[r]; //Let a[r] = base value
        while(l < r){
            while(a[l]<=x && l<r)l++;//find first a[l] >=x
            //cir1 : a[l]<x INT
            //make a[r] = a[l]; r--;
            if(l<r)a[r--]=a[l];
            //cir2 l<r INT
            //break;
            while(a[r]>=x && l<r)r--;
            //cir1 : a[r]>=x INT
            //make a[r] = a[l]; r--;
            if(l<r)a[l++]=a[r];
            //cir2 l<r INT
            //break;
        }
        //make a[l]=a[r]=x;
        a[l] = x;
        return l;
    }

    //Thought :: Divide into two part
    //A[i]<=a[k]<=a[j] i<k<j
    public static int normalPartition(int[] a, int l, int r) {
        //choose the base value;
        int x = a[r];
        //set left pointer
        //We can see i,j as the baffle.
        //divide int two part
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (a[j] <= x) {
                i++;
                //swap a[j] a[i]
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
            }
        }
        //execute return value
        //swap a[i+1] a[r]
        int t = a[i + 1];
        a[i + 1] = a[r];
        a[r] = t;
        return i + 1;
    }

    public static void qSort(int[] a, int l, int r) {
        //stop
        if (r - l < 1) return;
        //Rearrange
        int t = hoarePartition(a, l, r);
        qSort(a, l, t - 1);
        qSort(a, t + 1, r);
    }

    public static void qSortWithTailRecursion(int[] a, int l, int r) {
        //stop
        while (l < r) {
            int t = hoarePartition(a, l, r);
            qSortWithTailRecursion(a, l, t - 1);
            l = t + 1;
        }
        //Rearrange
    }

    public static void qSortWithThreeRoads(int[] a, int l, int r) {
        //TODO:: DELAY
    }

    public static void qSortWithDualRadix(int[] a, int l, int r) {
        //TODO:: DELAY
    }

    public static void qSortWithRandom(int[] a, int l, int r) {
        if (l >= r) return;
        //Randomize
        int x = (int) (Math.random() * (r - l)) + l;
        //swap a[x] and a[r];
        int tt = a[x];
        a[x] = a[r];
        a[r] = tt;
        //Rearrange
        int t = hoarePartition(a, l, r);
        qSortWithRandom(a, l, t - 1);
        qSortWithRandom(a, t + 1, r);
    }

    public static void sort(int[] a) {
        qSort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] test = new int[20];
        for (int i = 0; i < test.length; i++)
            test[i] = (int) (1 + Math.random() * (1000 - 1 + 1));
        for (int x : test)
            System.out.print(x + " ");
        System.out.println();
        int[] a = new int[test.length];
        System.arraycopy(test, 0, a, 0, test.length);
        Zurl.Sort.BubbleSort.sort(a);
        for (int x : a)
            System.out.print(x + " ");
        System.out.println();
        sort(test);
        for (int x : test)
            System.out.print(x + " ");
        System.out.println();
    }

}
