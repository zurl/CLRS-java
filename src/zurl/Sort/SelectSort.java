package zurl.Sort;

/**
 * Created by furry on 1/29/2016.
 */
public class SelectSort {
    public static void sort(int[] a){
        for(int i=a.length-1;i>=1;i--){
            //init
            int maxn = a[i],maxp = i;
            //find the max value
            for(int j=0;j<=i-1;j++){
                if(a[j]>maxn){
                    maxn=a[j];
                    maxp=j;
                }
            }
            //swap
            int t = a[i];
            a[i] = a[maxp];
            a[maxp] = t;
        }
    }
    public static void main(String[] args){
        int[] test = {9,8,7,6,5,4,3};
        sort(test);
        for(int x : test)
            System.out.println(x);
    }
}
