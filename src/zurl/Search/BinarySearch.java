package zurl.Search;
/**
 * Created by furry on 1/29/2016.
 */
public class BinarySearch {
    public static int search(int[] a,int x){
        //Need Asc Sorted Seq
        int l=0,r=a.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(a[mid]==x){
                return mid;
            }else if(a[mid]>x){
                r=mid-1;
            }else if(a[mid]<x){
                l=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] test = new int[10];
        for(int i=0;i<test.length;i++)
            test[i] = (int)(1+Math.random()*(1000-1+1));
        zurl.Sort.InsertSort.sort(test);
        for(int x :test)
            System.out.print(x+" ");
        System.out.println();
        System.out.println(search(test,test[5]));
    }
}
