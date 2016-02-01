package Zurl.Math;

/**
 * Created by furry on 1/29/2016.
 */
public class Qinjiushao {
    public static int work(int[] a,int x){
        int ans=0;
        for(int i=a.length-1;i>=0;i--){
            ans=(ans+a[i])*x;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] test = {9,8,2,7,3};
        int x=1;
        System.out.println(work(test,x));
    }
}
