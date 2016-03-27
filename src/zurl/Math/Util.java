package Zurl.Math;

/**
 * Created by furry on 2/4/2016.
 */
public class Util {
    public static int max(int[] a,int l,int r){
        int maxn = a[l];
        for(int i=l;i<=r;i++)
            if(a[i]>maxn)maxn = a[i];
        return maxn;
    }
    public static int min(int[] a,int l,int r){
        int minn = a[l];
        for(int i=l;i<=r;i++)
            if(a[i]<minn)minn = a[i];
        return minn;
    }

    //select the kth max number
    public static int select(int[] a,int l,int r,int k){
        //O(n) time;
        //Use QuickSort Mindset
        if( l == r )return a[l];
        //partition
        int pos = Zurl.Sort.QuickSort.hoarePartition(a,l,r);
        int rank = pos - l + 1;
        if(rank == k)return a[pos];
        else if(rank < k)return select(a,pos+1,r,k-rank);
        else return select(a,l,pos-1,k);
    }
    public static void main(String[] args){
        int[] test = new int[20];
        for (int i = 0; i < test.length; i++)
            test[i] = (int) (1 + Math.random() * (1000 - 1 + 1));
        for (int x : test)
            System.out.print(x + " ");
        System.out.println();
        //copy
        int[] a = new int[test.length];
        System.arraycopy(test,0,a,0,test.length);
        System.out.println(select(a,0,a.length-1,10));
        //sort
        Zurl.Sort.QuickSort.sort(test);
        for (int x : test)
            System.out.print(x + " ");
        int minn = min(test,0,test.length-1);
        int maxn = max(test,0,test.length-1);
        System.out.println(minn + " "+maxn);
    }
}
