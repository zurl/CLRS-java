package Zurl.Sort;

/**
 * Created by furry on 1/29/2016.
 */
public class MultiSort {
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

    public static void mSort(int[] a, int l, int r) {
        if (r - l <= 8) {
            iSort(a, l, r);
            return;
        }
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

    public static void sort(int[] a) {
        mSort(a, 0, a.length - 1);
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
