package Zurl.Sort;

/**
 * Created by furry on 1/29/2016.
 */
public class MergeSort {
    public static void mSort(int[] a, int l, int r) {
        if (l == r) return;
        //part sort
        int mid = (l + r) / 2;
        mSort(a, l, mid);
        mSort(a, mid + 1, r);
        //merge
        int[] ret = new int[r - l + 1];
        int ll = l, rr = mid + 1, now = -1;
        while (ll <= mid && rr <= r) {
            if (a[ll] < a[rr]) {
                ret[++now] = a[ll++];
            } else {
                ret[++now] = a[rr++];
            }
        }
        while (ll <= mid) {
            ret[++now] = a[ll++];
        }
        while (rr <= r) {
            ret[++now] = a[rr++];
        }
        //copy
        System.arraycopy(ret, 0, a, l, r - l + 1);
    }
    public static void mSort(double[] a, int l, int r) {
        if (l == r) return;
        //part sort
        int mid = (l + r) / 2;
        mSort(a, l, mid);
        mSort(a, mid + 1, r);
        //merge
        double[] ret = new double[r - l + 1];
        int ll = l, rr = mid + 1, now = -1;
        while (ll <= mid && rr <= r) {
            if (a[ll] < a[rr]) {
                ret[++now] = a[ll++];
            } else {
                ret[++now] = a[rr++];
            }
        }
        while (ll <= mid) {
            ret[++now] = a[ll++];
        }
        while (rr <= r) {
            ret[++now] = a[rr++];
        }
        //copy
        System.arraycopy(ret, 0, a, l, r - l + 1);
    }
    public static void sort(int[] a) {
        mSort(a, 0, a.length - 1);
    }
    public static void sort(double[] a) {
        mSort(a, 0, a.length - 1);
    }
    public static void main(String[] args) {
        int[] test = new int[10];
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
