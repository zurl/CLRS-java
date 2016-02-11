package Zurl.Sort;

import Zurl.Sort.QuickSort.*;

/**
 * Created by furry on 2/3/2016.
 */
public class SuperSort {
    public static void iSort(int[] a, int l, int r) {
        for (int i = l; i <= r; i++) {
            //Save the key value
            int key = a[i], j;
            //Find the insert pos
            for (j = i - 1; j >= l && a[j] > key; j--) {
                a[j + 1] = a[j];
            }
            //insert
            a[j + 1] = key;
        }
    }

    public static void uSort(int[] a, int l, int r) {
        if (r - l <= 8) {
            iSort(a, l, r);
        }else {
            int x = (int) (Math.random() * (r - l)) + l;
            //swap a[x] and a[r];
            int tt = a[x];
            a[x] = a[r];
            a[r] = tt;
            int t = Zurl.Sort.QuickSort.hoarePartition(a, l, r);
            uSort(a, l, t - 1);
            uSort(a, t + 1, r);
        }
    }

    public static void sort(int[] a) {
        uSort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] test = new int[20];
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
