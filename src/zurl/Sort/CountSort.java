package Zurl.Sort;

/**
 * Created by furry on 2/4/2016.
 */
public class CountSort {
    public static void cSort(int[] a,int lower,int upper){
        int b[] = new int[upper - lower + 1];
        for(int x : a)b[x-lower]++;
        int t = -1;
        for(int i=0;i<=upper-lower;i++)
            for(int j=1;j<=b[i];j++)
                a[++t]=i + lower;
    }
    public static void sort(int[] a){
        int minn=a[0],maxn=a[0];
        for(int x : a){
            if(x<minn)minn=x;
            if(x>maxn)maxn=x;
        }
        cSort(a,minn,maxn);
    }

    public static void main(String[] args) {
        int[] test = {9, 8, 7, 6, 5, 4, 3};
        sort(test);
        for (int x : test)
            System.out.println(x);
    }
}
