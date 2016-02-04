package Zurl.Sort;

import java.util.function.*;

/**
 * Created by furry on 1/29/2016.
 */
public class QuickSort {
    public static int hoarePartition(int[] a, int l, int r) {
        //init

        int x = a[l];
        int i = l - 1;
        int j = r + 1;
        while (true) {
            do{j--;}while(a[j]>x);
            do{i++;}while(a[i]<x);
            //j--;while(a[j]>x)j--;
            //i++;while(a[i]<x)i++;
            if(i<j){
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
            }else{
                a[i] = x;
                return i;
            }
        }
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

    public static void qsort(int[] a, int l, int r) {
        //stop
        if (l >= r) return;
        //Rearrange
        int t = hoarePartition(a, l, r);
        qsort(a, l, t - 1);
        qsort(a, t + 1, r);
    }
    public static void qsortWithTailRecursion(int[] a, int l, int r) {
        //stop
        while(l<r){
            int t = hoarePartition(a, l, r);
            qsortWithTailRecursion(a, l, t - 1);
            l=t+1;
        }
        //Rearrange
    }


    public static void qsortWithRandom(int[] a, int l, int r) {
        if (l >= r) return;
        //Randomize
        int x = (int) (Math.random() * (r - l)) + l;
        //swap a[x] and a[r];
        int tt = a[x];
        a[x] = a[r];
        a[r] = tt;
        //Rearrange
        int t = hoarePartition(a, l, r);
        qsortWithRandom(a, l, t - 1);
        qsortWithRandom(a, t + 1, r);
    }

    public static void sort(int[] a) {
        qsortWithTailRecursion(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] test = new int[200];
        for (int i = 0; i < test.length; i++)
            test[i] = (int) (1 + Math.random() * (1000 - 1 + 1));
        for (int x : test)
            System.out.print(x + " ");
        System.out.println();
        sort(test);
        for (int x : test)
            System.out.print(x + " ");
        System.out.println();
    }

}
