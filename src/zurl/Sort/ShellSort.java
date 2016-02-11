package Zurl.Sort;

/**
 * Created by furry on 2/4/2016.
 */
public class ShellSort {
    public static void sort(int[] a) {
        //choose the gap
        for (int gap = a.length / 2; gap > 0; gap /= 2)
            //insert sort
            for (int i = gap; i < a.length; i++)
                //find insert point
                for (int j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
                    int t = a[j];
                    a[j] = a[j + gap];
                    a[j + gap] = t;
                }
    }

    public static void main(String[] args) {
        int[] test = {9, 8, 7, 6, 5, 4, 3};
        sort(test);
        for (int x : test)
            System.out.println(x);
    }
}
