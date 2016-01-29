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
        int[] test = {9,8,7,6,5,4,3};
        System.out.println(search(test,7));
    }
}
