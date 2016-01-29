package zurl.Math;

/**
 * Created by furry on 1/29/2016.
 */
public class Inversion {
    public static int mSort(int[] a,int l,int r){
        if(l==r)return 0;
        //part sort
        int mid=(l+r)/2,ans=0;
        ans+=mSort(a,l,mid);
        ans+=mSort(a,mid+1,r);
        //merge
        int[] ret = new int[r-l+1];
        int ll=l,rr=mid+1,now=-1;
        while(ll<=mid&&rr<=r){
            if(a[ll]<=a[rr]){
                ret[++now]=a[ll++];
            }else{
                ret[++now]=a[rr++];
                ans+=mid-ll+1;
            }
        }
        while(ll<=mid){
            ret[++now]=a[ll++];
        }
        while(rr<=r){
            ret[++now]=a[rr++];
        }
        //copy
        System.arraycopy(ret,0,a,l,r-l+1);
        return ans;
    }
    public static int sort(int[] a){
        //o(nlgn)
        return mSort(a,0,a.length-1);
    }
    public static void main(String[] args){
        int[] test = {9,8,2,7,3};
        System.out.println(sort(test));

    }
}
